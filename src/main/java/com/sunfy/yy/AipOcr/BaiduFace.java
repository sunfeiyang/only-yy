package com.sunfy.yy.AipOcr;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.sunfy.yy.common.utils.UtilsGetImageBase64;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class BaiduFace {
    //设置APPID/AK/SK
    public static final String APP_ID = "15275660";
    public static final String API_KEY = "r1O1fbh1Rt0BXMKj2DlnjcqV";
    public static final String SECRET_KEY = "fzu2eeys5bsXMGkeQQQW8agZGRTDC1wl";

    public static void main(String[] args) {
        // 初始化一个AipFace
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String pathUrl = "E:/face3.jpg";
        String path = UtilsGetImageBase64.GetImageStr(pathUrl);
        String imageType = "BASE64";
//        JSONObject res = client.detect(path,imageType, new HashMap<String, String>());
//        System.out.println(res.toString(2));

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("face_field", "age");
        options.put("max_face_num", "2");
        options.put("face_type", "LIVE");

        // 人脸检测
        JSONObject res1 = client.detect(path, imageType, options);
//        System.out.println(res1.toString(2));

        //人脸对比
        String image1 = "E:/face6.png";
        String image2 = "E:/face2.jpg";
        String path1 = UtilsGetImageBase64.GetImageStr(image1);
        String path2 = UtilsGetImageBase64.GetImageStr(image2);

        // image1/image2也可以为url或facetoken, 相应的imageType参数需要与之对应。
        MatchRequest req1 = new MatchRequest(path1, "BASE64");
        MatchRequest req2 = new MatchRequest(path2, "BASE64");
        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
        requests.add(req2);

        JSONObject res = client.match(requests);
        System.out.println(res.toString(2));


    }
}
