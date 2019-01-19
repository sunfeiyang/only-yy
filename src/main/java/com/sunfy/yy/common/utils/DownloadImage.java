package com.sunfy.yy.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 根据图片url保存图片
 */
public class DownloadImage {  
  
    /** 
     * @param args 
     * @throws Exception  
     */  
    public static void main(String[] args) throws Exception {
        String url = Class.class.getClass().getResource("/").getPath();
        System.out.println(url);

        // TODO Auto-generated method stub
//         download("https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2539661066.jpg", "1_li1325169021.jpg","E:\\image\\");
         download("https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2529389608.webp", "1222.jpg","E:\\image\\");
        System.out.println("图片保存成功！");
    }
      
    public static void download(String urlString, String filename,String savePath) {
        try{
            // 构造URL
            URL url = new URL(urlString);
            // 打开连接
            URLConnection con = url.openConnection();
            //设置请求超时为5s
            con.setConnectTimeout(5*1000);
            // 输入流
            InputStream is = con.getInputStream();

            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            File sf=new File(savePath);
            if(!sf.exists()){
                sf.mkdirs();
            }
            OutputStream os = new FileOutputStream(sf.getPath()+"\\"+filename);
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            // 完毕，关闭所有链接
            os.close();
            is.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }   
  
}  