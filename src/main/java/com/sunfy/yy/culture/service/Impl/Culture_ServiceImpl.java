package com.sunfy.yy.culture.service.Impl;

import com.sunfy.yy.common.enums.EnumException;
import com.sunfy.yy.common.exception.ExceptionSystem;
import com.sunfy.yy.common.utils.HttpRequest;
import com.sunfy.yy.common.utils.JsonUtils;
import com.sunfy.yy.culture.domain.*;
import com.sunfy.yy.culture.repository.*;
import com.sunfy.yy.culture.service.Culture_Service;
import com.sunfy.yy.common.enums.EnumRepositoryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Culture_ServiceImpl implements Culture_Service {

    //歇后语数据库操作对象
    @Autowired
    private Culture_Allegorical_Repository culture_allegorical_repository;

    //字典数据库操作对象
    @Autowired
    private Culture_Dic_Repository culture_Dic_repository;

    //名人名言数据库操作对象
    @Autowired
    private Culture_Famous_Repository culture_famous_repository;

    //成语数据库操作对象
    @Autowired
    private Culture_Idiom_Repository culture_idiom_repository;

    //唐诗宋词数据库操作对象
    @Autowired
    private Culture_Poem_Repository culture_poem_repository;

    //历史上的今天数据库操作对象
    @Autowired
    private Culture_Today_History_Repository culture_today_history_repository;

    //历史上的今天数据库操作对象
    @Autowired
    private Culture_WordSea_Repository culture_wordSea_repository;

    private final static Logger logger = LoggerFactory.getLogger(Culture_ServiceImpl.class);

    /**
     * 随机生成一条
     *
     * @param url            请求链接
     * @param repositoryType 数据库请求对象类型
     * @return ArrayList
     */
    @Override
    public ArrayList addRandom(String url, String repositoryType) {
        if (logger.isInfoEnabled()) {
            logger.info("【Culture_ServiceImpl—addRandom】请求成功！参数：url=" + url);
        }
        //定义返回对象
        ArrayList result_list = new ArrayList();
        //数据请求结果
        String jsonResult = HttpRequest.get(url);

        JsonUtils jsonUtils = new JsonUtils();
        Map map = null;
        try {
            //当网络异常时，获取数据为null，此时随机从现有数据中随机生成一条返回
            if (jsonResult == "" || jsonResult == null) {
//            throw new ExceptionCulture(EnumCultureException.NETWORKANOMALY);
                result_list.add(getRepositoryTypeResult(null, repositoryType));
            } else {
                map = jsonUtils.toMap(jsonResult);
                Map mapList = (Map) map.get("result");
                result_list.add(getRepositoryTypeResult(mapList, repositoryType));
            }
            return result_list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 多条数据同时写入
     *
     * @param url            请求链接
     * @param repositoryType 数据库请求对象类型
     * @return ArrayList
     */
    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    @Override
    public ArrayList addList(String url, String repositoryType) {
        if (logger.isInfoEnabled()) {
            logger.info("【Culture_ServiceImpl—addList】请求成功！参数：url=" + url);
        }
        //定义返回对象
        ArrayList result_list = new ArrayList();

        String jsonResult = HttpRequest.get(url);
        JsonUtils jsonUtils = new JsonUtils();
        Map map = null;
        try {
            if (jsonResult == "" || jsonResult == null) {
                throw new ExceptionSystem(EnumException.SUCCESSNULL);
            } else {
                map = jsonUtils.toMap(jsonResult);
                Integer total = (Integer) map.get("total");
                ArrayList list = (ArrayList) map.get("result");
                if (list != null && list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        Map mapList = (Map) list.get(i);
                        //将数据存入数据库
                        result_list.add(this.getRepositoryTypeResult(mapList, repositoryType));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (result_list == null || result_list.size() <= 0) {
                result_list.add("ERROR");
                result_list.add(EnumException.SUCCESSNULL);
            }
            return result_list;
        }
    }

    /**
     * Like查询数据库中内容
     * @param map 所要查询的字段及内容
     * @return ArrayList
     */
    @Override
    public ArrayList selLikeList(Map map,String repositoryType){
        String keyword = map.get("keyword")+ "";
        if (!repositoryType.equals(EnumRepositoryType.DIC.getRepositoryType())){
            keyword = "%"+  map.get("keyword")+"%";
        }
        ArrayList list = null;

        if (repositoryType.equals(EnumRepositoryType.ALLEGORICAL.getRepositoryType())) {
            list = (ArrayList) culture_allegorical_repository.findByAllegoricalquestionLike(keyword);
            list.addAll( culture_allegorical_repository.findByAllegoricalanswerLike(keyword));
        } else if (repositoryType.equals(EnumRepositoryType.DIC.getRepositoryType())) {
            // 字典时，逐字进行查询
            if(keyword != "" && keyword != null){
                for (int i = 0; i < keyword.length(); i++) {
                    String keyword_i = keyword.substring(i,i+1);
                    if(keyword_i != "" && keyword_i != null){
                        List result = culture_Dic_repository.findByDichanzi(keyword_i);
                        // 此处需要在初次赋值时进行特殊处理，否则会有空指针异常
                        if(i == 0){
                            list = (ArrayList) result;
                        }else{
                            list.addAll(result);
                        }
                    }
                }
            }
        } else if (repositoryType.equals(EnumRepositoryType.FAMOUS.getRepositoryType())) {
            list = (ArrayList) culture_famous_repository.findByFamousnameLike(keyword);
            list.addAll(culture_famous_repository.findByFamoussayingLike(keyword));
        } else if (repositoryType.equals(EnumRepositoryType.IDIOM.getRepositoryType())) {
            list = (ArrayList) culture_idiom_repository.findByIdiomnameLike(keyword);
        } else if (repositoryType.equals(EnumRepositoryType.POEM.getRepositoryType())) {
            list = (ArrayList) culture_poem_repository.findByPoembiaotiLike(keyword);
            list.addAll(culture_poem_repository.findByPoemzuozheLike(keyword));
        } else if (repositoryType.equals(EnumRepositoryType.TODAY_HISTORY.getRepositoryType())) {
            list = (ArrayList) culture_today_history_repository.findByTodayhistorytitleLike(keyword);
        } else if (repositoryType.equals(EnumRepositoryType.WORD_SEA.getRepositoryType())) {
            list = (ArrayList) culture_wordSea_repository.findByWordseawordsLike(keyword);
        }

        if(list != null && list.size()>0){
            if (logger.isInfoEnabled()) {
                logger.info("【Culture_ServiceImpl—selLikeList】查询到数据！类型为：" + repositoryType);
            }
            return list;
        }else{
            list.add("ERROR");
            list.add(EnumException.SUCCESSNULL);
            if (logger.isInfoEnabled()) {
                logger.info("【Culture_ServiceImpl—selLikeList】查询数据为空！类型为：" + repositoryType);
            }
        }
        return list;
    }

    /**
     * 分页查询
     * @param map 查询条件
     * @return ArrayList
     */
    @Override
    public List selListPage(Map map,String repositoryType){
        Integer pageSize = (Integer) map.get("pageSize");
        Integer pageNum = (Integer) map.get("pageNum");
//        Pageable pageable = new Pageable(pageNum == null? 0 : Integer.parseInt(pageNum),
////                pageSize == null? 10 : Integer.parseInt(pageSize),
////                new Sort(Sort.Direction.DESC), "tid");
        Pageable pageable =new PageRequest(pageNum, pageSize);
        List page_result = null;

        if (repositoryType.equals(EnumRepositoryType.ALLEGORICAL.getRepositoryType())) {
            page_result = culture_allegorical_repository.findAll(pageable).getContent();
        } else if (repositoryType.equals(EnumRepositoryType.DIC.getRepositoryType())) {
            page_result = culture_Dic_repository.findAll(pageable).getContent();
        } else if (repositoryType.equals(EnumRepositoryType.FAMOUS.getRepositoryType())) {
            page_result = culture_famous_repository.findAll(pageable).getContent();
        } else if (repositoryType.equals(EnumRepositoryType.IDIOM.getRepositoryType())) {
            page_result = culture_idiom_repository.findAll(pageable).getContent();
        } else if (repositoryType.equals(EnumRepositoryType.POEM.getRepositoryType())) {
            page_result = culture_poem_repository.findAll(pageable).getContent();
        } else if (repositoryType.equals(EnumRepositoryType.TODAY_HISTORY.getRepositoryType())) {
            page_result = culture_today_history_repository.findAll(pageable).getContent();
        } else if (repositoryType.equals(EnumRepositoryType.WORD_SEA.getRepositoryType())) {
            page_result = culture_wordSea_repository.findAll(pageable).getContent();
        }

        if(page_result != null && page_result.size() > 0){
            if (logger.isInfoEnabled()) {
                logger.info("【Culture_ServiceImpl—selListPage】分页查询到数据！类型为：" + repositoryType);
            }
            return page_result;
        }else{
            if (logger.isInfoEnabled()) {
                logger.info("【Culture_ServiceImpl—selListPage】分页未查询到数据！类型为：" + repositoryType);
            }
            page_result.add("ERROR");
            page_result.add(EnumException.SUCCESSNULL);
        }
        return page_result;
    }



    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    @Override
    public ArrayList addDetailsList(String url, String urlDetailsStar, String repositoryType) {
        if (logger.isInfoEnabled()) {
            logger.info("【Culture_ServiceImpl—addDetailsList】请求成功！参数：url=" + url);
        }
        ArrayList result_list = new ArrayList();
        Object obj = null;
        String jsonResult = HttpRequest.get(url);
        JsonUtils jsonUtils = new JsonUtils();
        Map map = null;
        try {
            if (jsonResult == "" || jsonResult == null) {
                throw new ExceptionSystem(EnumException.SUCCESSNULL);
            } else {
                map = jsonUtils.toMap(jsonResult);
                Integer total = (Integer) map.get("total");
                ArrayList list = (ArrayList) map.get("result");
                if (list != null && list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        Map mapList = (Map) list.get(i);
                        String id = (String) mapList.get("id");
                        String urlDetails = "";
                        if (!id.equals("") && id != null) {
                            urlDetails = urlDetailsStar + "&id=" + id;
                        }
                        String jsonResultDetails = HttpRequest.get(urlDetails);
                        Map mapDetails = jsonUtils.toMap(jsonResultDetails);

                        //将原始数据进行过滤，根据返回状态判断是否写入数据库
                        Map mapInsert = (Map) mapDetails.get("result");
                        result_list.add(this.getRepositoryTypeResult(mapInsert, repositoryType));
                    }
                }
                result_list.add("ERROR");
                result_list.add(EnumException.SUCCESSNULL);
                return result_list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据不同的数据库请求对象，将数据写入对应的数据库
     *
     * @param mapList        待写入数据数据
     * @param repositoryType 数据库请求对象类型
     * @return Object
     */
    public Object getRepositoryTypeResult(Map mapList, String repositoryType) {
        //定义返回对象
        Object obj = null;
        //根据mapList是有为空，空则随机返回一条，非空则尝试写入数据库【为空主要是因为调用的接口地址异常，今天访问数达到上限导致】
        if (mapList != null && !mapList.isEmpty()) {
            //此处需要动态修改【每次插入数据前根据设置的唯一性标识检查数据是否存在，存在则直接返回】
            //数据是否存在的标识
            Boolean dataIsHave = false;
            if (repositoryType.equals(EnumRepositoryType.ALLEGORICAL.getRepositoryType())) {
                String question = (String) mapList.get("question");
                String answer = (String) mapList.get("answer");
                Culture_Allegorical culture_allegorical = culture_allegorical_repository.findByAllegoricalquestionAndAllegoricalanswer(question, answer);
                if (culture_allegorical != null) {
                    dataIsHave = true;
                    obj = culture_allegorical;
                } else {
                    obj = culture_allegorical_repository.save(Culture_Allegorical_ServiceImpl.mapToBean(mapList));
                }
            } else if (repositoryType.equals(EnumRepositoryType.DIC.getRepositoryType())) {
                String hanzi = (String) mapList.get("hanzi");
                List culture_dic = culture_Dic_repository.findByDichanzi(hanzi);
                if (culture_dic != null) {
                    dataIsHave = true;
                    obj = culture_dic;
                } else {
                    obj = culture_Dic_repository.save(Culture_Dic_ServiceImpl.mapToBean(mapList));
                }
            } else if (repositoryType.equals(EnumRepositoryType.FAMOUS.getRepositoryType())) {
                String famous_name = (String) mapList.get("famous_name");
                String famous_saying = (String) mapList.get("famous_saying");
                Culture_Famous culture_famous = culture_famous_repository.findByFamousnameAndFamoussaying(famous_name, famous_saying);
                if (culture_famous != null) {
                    dataIsHave = true;
                    obj = culture_famous;
                } else {
                    obj = culture_famous_repository.save(Culture_Famous_ServiceImpl.mapToBean(mapList));
                }
            } else if (repositoryType.equals(EnumRepositoryType.IDIOM.getRepositoryType())) {
                String id = (String) mapList.get("id");
                Culture_Idiom culture_idiom = culture_idiom_repository.findByIdiomid(id);
                if (culture_idiom != null) {
                    dataIsHave = true;
                    obj = culture_idiom;
                } else {
                    obj = culture_idiom_repository.save(Culture_Idiom_ServiceImpl.mapToBean(mapList));
                }
            } else if (repositoryType.equals(EnumRepositoryType.POEM.getRepositoryType())) {
                String id = (String) mapList.get("id");
                Culture_Poem culture_poem = culture_poem_repository.findByPoemid(id);
                if (culture_poem != null) {
                    dataIsHave = true;
                    obj = culture_poem;
                } else {
                    obj = culture_poem_repository.save(Culture_Poem_ServiceImpl.mapToBean(mapList));
                }
            } else if (repositoryType.equals(EnumRepositoryType.TODAY_HISTORY.getRepositoryType())) {
                String title = (String) mapList.get("title");
                Culture_Today_History culture_today_history = culture_today_history_repository.findByTodayhistorytitle(title);
                if (culture_today_history != null) {
                    dataIsHave = true;
                    obj = culture_today_history;
                } else {
                    obj = culture_today_history_repository.save(Culture_Today_History_ServiceImpl.mapToBean(mapList));
                }
            } else if (repositoryType.equals(EnumRepositoryType.WORD_SEA.getRepositoryType())) {
                String words = (String) mapList.get("words");
                Culture_WordSea culture_wordSea = culture_wordSea_repository.findByWordseawords(words);
                if (culture_wordSea != null) {
                    dataIsHave = true;
                    obj = culture_wordSea;
                } else {
                    obj = culture_wordSea_repository.save(Culture_WordSea_ServiceImpl.mapToBean(mapList));
                }
            }
            //控制台数据标识
            if (dataIsHave) {
                if (logger.isInfoEnabled()) {
                    logger.info("【Culture_ServiceImpl—getRepositoryTypeResult】数据已存在！类型为：" + repositoryType);
                }
            } else {
                if (logger.isInfoEnabled()) {
                    logger.info("【Culture_ServiceImpl—getRepositoryTypeResult】插入数据！类型为：" + repositoryType);
                }
            }
            return obj;

        } else {
            if (logger.isInfoEnabled()) {
                logger.info("【Culture_ServiceImpl—getRepositoryTypeResult】请求数据为null！类型为【" + repositoryType + "】");
            }
//            throw new ExceptionCulture(EnumCultureException.ERROR_NULL);
            Integer tid = (int) (Math.random() * 600);
            if (repositoryType.equals(EnumRepositoryType.ALLEGORICAL.getRepositoryType())) {
                obj = culture_allegorical_repository.findByTid(tid);
            } else if (repositoryType.equals(EnumRepositoryType.DIC.getRepositoryType())) {
                obj = culture_Dic_repository.findByTid(tid);
            } else if (repositoryType.equals(EnumRepositoryType.FAMOUS.getRepositoryType())) {
                obj = culture_famous_repository.findByTid(tid);
            } else if (repositoryType.equals(EnumRepositoryType.IDIOM.getRepositoryType())) {
                obj = culture_idiom_repository.findByTid(tid);
            } else if (repositoryType.equals(EnumRepositoryType.POEM.getRepositoryType())) {
                obj = culture_poem_repository.findByTid(tid);
            } else if (repositoryType.equals(EnumRepositoryType.TODAY_HISTORY.getRepositoryType())) {
                obj = culture_today_history_repository.findByTid(tid);
            } else if (repositoryType.equals(EnumRepositoryType.WORD_SEA.getRepositoryType())) {
                obj = culture_wordSea_repository.findByTid(tid);
            }
            return obj;
        }
    }

}
