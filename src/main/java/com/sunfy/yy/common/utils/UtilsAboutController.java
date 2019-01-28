package com.sunfy.yy.common.utils;

import com.sunfy.yy.common.domain.Result;
import com.sunfy.yy.common.enums.EnumException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Controller 相关的工具类
 */
public class UtilsAboutController {

    public static Result setResult(List result_list) {
        if (result_list != null && result_list.size() > 0 && "ERROR".equals(result_list.get(0))) {
            return UtilsResult.success(null, (EnumException) result_list.get(1));
        } else if (result_list != null) {
            return UtilsResult.success(result_list, EnumException.SUCCESS);
        }
        return UtilsResult.error(EnumException.ERROR_NULL);
    }

    public static String addArgs(String url, Map map) {
        if(map != null){
//            Map maps = (Map) JSON.parse(String.valueOf(map));
//            Iterator it = maps.entrySet().iterator();
//            while (it.hasNext()) {
//                Map.Entry entry = (Map.Entry) it.next();
//                String key = (String)entry.getKey();
//                Object value = maps.get(key);
//                System.out.println(key);
//                System.out.println(value);
//                url += "&"+key+"="+value;
//                JSONObject json = JSONObject.fromObject(valueList1);
//                String content = json.getString("content");
//                String selType = json.getString("selType");
//                //为了同一个字段多个查询条件的情况 每个key后会有一个阿拉伯数字进行区分，拼写SQL时进行处理
//                key = key.substring(0,key.length()-1);
//                assSql += " and "+key +" "+selType+ " '"+content+ "'";
//                assSql_num += " and "+key +" "+selType+ " '"+content+ "'";
//            }
        }
        return url;
    }
}
