package com.sunfy.yy.AipOcr.service.Impl;

import com.baidu.aip.ocr.AipOcr;
import com.sunfy.yy.AipOcr.service.OcrService;
import com.sunfy.yy.common.enums.EnumAi;
import com.sunfy.yy.common.enums.EnumPath;
import com.sunfy.yy.common.utils.JsonUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class OcrServiceImpl implements OcrService {

    /**
     * 通用文字识别
     */
    @Override
    public ArrayList OcrText(String ImageUrl){
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(EnumAi.OCR_APP_ID.getValue(), EnumAi.OCR_API_KEY.getValue(), EnumAi.OCR_SECRET_KEY.getValue());

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = EnumPath.AIPATH.getValue() +ImageUrl;
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
//        System.out.println(res.toString(2));

        // 对识别结果进行格式化处理
        String ocrStr = res.toString(2);
        JsonUtils jsonUtils = new JsonUtils();
        ArrayList result = new ArrayList();
        //返回结果全部拼接
        String res1 = "";
        //逐行添加<br>显示
        String res2 = "";
        //识别结果直接返回形成多条数据（ArrayList）
        ArrayList res3 = new ArrayList();
        try {
            Map map = jsonUtils.toMap(ocrStr);
            Set<String> keySet = map.keySet();
            for (String str : keySet) {
//                System.out.println(str+"###"+map.get(str));
                if("words_result".equals(str)){
                    ArrayList list = (ArrayList) map.get(str);
                    for (int i = 0; i < list.size(); i++) {
                        Map map1 = (Map) list.get(i);
                        String strWords = (String) map1.get("words");
                        System.out.println(strWords);
                        res1 += strWords;
                        res2 += strWords+"<br>";
                        res3.add(strWords);
                    }
                    result.add(res1);
                    result.add(res2);
                    result.add(res3);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
