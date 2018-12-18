package com.sunfy.yy.culture.service;

import com.sunfy.yy.common.enums.EnumCultureApi;
import com.sunfy.yy.common.utils.HttpRequest;
import com.sunfy.yy.common.utils.JsonUtils;
import com.sunfy.yy.culture.domain.Culture_Idiom;
import com.sunfy.yy.culture.repository.Culture_Idiom_Repository;
import com.sunfy.yy.culture.utils.EnumRepositoryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Map;

@Service
public class Culture_Idiom_Service extends Culture_Service{

    //成语数据库操作对象
    @Autowired
    private Culture_Idiom_Repository culture_idiom_repository;

    //发送http请求的对象
    HttpRequest httpRequest = new HttpRequest();

    private final static Logger logger = LoggerFactory.getLogger(Culture_Idiom_Service.class);

    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    public ArrayList addIdiomList(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Idiom_Service—addIdiomList】请求成功！参数：url="+url);
        }
        Culture_Idiom culture_idiom = null;
        ArrayList<Culture_Idiom> result_list = new ArrayList();
        String jsonResult = httpRequest.get(url);
        JsonUtils jsonUtils = new JsonUtils();
        Map map = null;
        try {
            map = jsonUtils.toMap(jsonResult);
            Integer total = (Integer) map.get("total");
            ArrayList list = (ArrayList) map.get("result");
            if(list != null && list.size() > 0){
                for (int i = 0; i < list.size(); i++) {
                    Map mapList = (Map) list.get(i);
                    String id = (String)mapList.get("id");
                    String urlDetails = EnumCultureApi.IDIOM_DETAILS.getURL();
                    if(!id.equals("") && id != null){
                        urlDetails += "&id="+id;
                    }
                    String jsonResultDetails = httpRequest.get(urlDetails);
                    Map mapDetails = jsonUtils.toMap(jsonResultDetails);

                    //将原始数据进行过滤，根据返回状态判断是否写入数据库
                    ArrayList listFiltrate = this.listFiltrate((Map) mapDetails.get("result"));
                    //初始化数据库中是否存在该对象（默认是不存在）
                    Boolean filtrate_isHave = false;
                    if (listFiltrate != null && listFiltrate.size() > 0){
                        filtrate_isHave = (Boolean) listFiltrate.get(0);
                        if(listFiltrate.size() > 1){
                            culture_idiom = (Culture_Idiom) listFiltrate.get(1);
                            System.out.println(culture_idiom.getTid());
                        }
                    }
                    //将数据存入数据库
                    if(filtrate_isHave){
                        if(logger.isErrorEnabled()){
                            logger.info("【Culture_Idiom_Service—addIdiomList】插入数据！");
                        }
                        culture_idiom = culture_idiom_repository.save(this.mapToBean((Map) mapDetails.get("result")));
                    }else{
                        if(logger.isErrorEnabled()){
                            logger.info("【Culture_Idiom_Service—addIdiomList】数据已存在！");
                        }
                    }
                }
                result_list.add(culture_idiom);
                return result_list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    //事务操作 防止多条数据插入时 有失败情况
    public ArrayList addIdiom(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Idiom_Service—addIdiom】请求成功！参数：url="+url);
        }
        return addList(url, EnumRepositoryType.IDIOM.getRepositoryType());
    }

    //事务操作 防止多条数据插入时 有失败情况
    public ArrayList<Culture_Idiom> addIdiomRandom(String url) {
        if(logger.isInfoEnabled()){
            logger.info("【Culture_Idiom_Service—addIdiomRandom】请求成功！参数：url="+url);
        }
        return addRandom(url, EnumRepositoryType.IDIOM.getRepositoryType());
    }

    /**
     * 将map中数据存入指定bean对象中并将bean对象返回
     * @param map 带有数据的map
     * @return 返回存入数据的bean对象
     */
    public static Culture_Idiom mapToBean(Map map){
        //创建要转换的bean对象
        Culture_Idiom culture_idiom = new Culture_Idiom();
        /*
         * 从传入的map中获取对应的数据并将获取的内容写入对应的bean对象中
         * 【注：此处不同的bean对象都需做对应修改】
         */
        culture_idiom.setIdiomid((String) map.get("id"));
        culture_idiom.setIdiomname((String) map.get("name"));
        culture_idiom.setIdiom_spell((String) map.get("spell"));
        culture_idiom.setIdiom_content((String) map.get("content"));
        culture_idiom.setIdiom_derivation((String) map.get("derivation"));
        culture_idiom.setIdiom_samples((String) map.get("samples"));
        return culture_idiom;
    }

    /**
     * 对数据进行过滤，移除重复数据
     * @param map 待检查数据
     * @return 返回过滤结果 true：已存在 false：不存在
     */
    public ArrayList listFiltrate(Map map){
        ArrayList result_list = new ArrayList();
        String id = (String)map.get("id");
        //根据获得到的内容进行过滤，判断内容是否存在，存在返回true，否则返回false
        Culture_Idiom culture_idiom = culture_idiom_repository.findByIdiomid(id);
        if(culture_idiom != null){
            result_list.add(true);
            result_list.add(culture_idiom);
            System.out.println(result_list.toString());
            return result_list;
        }
        result_list.add(false);
        return result_list;
    }

}
