
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 获取经纬度
 *
 * @author Sunny
 * 密钥:f247cdb592eb43ebac6ccd27f796e2d2
 */
public class GetLatAndLngByBaidu {
    /**
     * @param addr
     * 查询的地址
     * @return
     * @throws IOException
     */
    public Object[] getCoordinate(String addr) throws IOException {
        String lng = null;//经度
        String lat = null;//纬度
        String address = null;
        try {
            address = java.net.URLEncoder.encode(addr, "UTF-8");
            System.out.println("address="+address);
        }catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        String key = "f247cdb592eb43ebac6ccd27f796e2d2";
        String url = String .format("http://api.map.baidu.com/geocoder?address=%s&output=json&key=%s", address, key);
        URL myURL = null;
        URLConnection httpsConn = null;
        try {
            myURL = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println("myURL="+myURL);

        InputStreamReader insr = null;
        BufferedReader br = null;
        try {
            httpsConn = (URLConnection) myURL.openConnection();// 不使用代理
            System.out.println("httpsConn="+httpsConn);

            if (httpsConn != null) {
                insr = new InputStreamReader( httpsConn.getInputStream(), "UTF-8");
                System.out.println("insr="+insr);
                br = new BufferedReader(insr);
                System.out.println("br="+br);
                String data = null;
                int count = 1;
                StringBuffer json = new StringBuffer();
                while((data= br.readLine())!=null){
                    json.append(data);
                    System.out.println("data="+data);
                    if(count==5){
                        lng = (String)data.subSequence(data.indexOf(":")+1, data.indexOf(","));//经度
                        count++;
                    }else if(count==6){
                        lat = data.substring(data.indexOf(":")+1);//纬度
                        count++;
                    }else{
                        count++;
                    }
                }
                String jsonStr=json.toString();
                JSONObject jsonObject = JSONObject.fromObject(jsonStr);
                System.out.println("jsonStr="+jsonObject);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(insr!=null){
                insr.close();
            }
            if(br!=null){
                br.close();
            }
        }
        return new Object[]{lng,lat};
    }


    public static void main(String[] args) throws IOException {
        GetLatAndLngByBaidu getLatAndLngByBaidu = new GetLatAndLngByBaidu();
        Object[] o = getLatAndLngByBaidu.getCoordinate("石家庄市裕华区赵村新区9-1-3402");
        System.out.println(o[0]);//经度
        System.out.println(o[1]);//纬度
    }

}