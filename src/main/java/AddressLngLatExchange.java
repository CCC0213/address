import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class AddressLngLatExchange {

    public String getLngLat(String address) {
        StringBuffer json = new StringBuffer();
        try {
            URL u = new URL("http://restapi.amap.com/v3/geocode/geo?address="+address+"&output=JSON&key=5a50f8f8890c4a0fc75694c3aab8b3fd");
            URLConnection yc = u.openConnection();
            //读取返回的数据
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(),"UTF-8"));
            String inputline = null;
            while((inputline=in.readLine())!=null){
                json.append(inputline);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String jsonStr=json.toString();
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        System.out.println(jsonObject);

        if(jsonObject.getJSONArray("geocodes").size()>0) {
            return jsonObject.getJSONArray("geocodes").getJSONObject(0).get("location").toString();
        } else {
            return null;
        }
    }
    public static void main(String[] args)  {
        AddressLngLatExchange addressLngLatExchange=new AddressLngLatExchange();
        System.out.println(addressLngLatExchange.getLngLat("石家庄市赵村新区9号楼-一单元"));
        System.out.println(addressLngLatExchange.getLngLat("石家庄市赵村新区17号楼-一单元"));

    }
}