public class PdNullUtils {
    public static boolean nullor(String key){
        if(key!=null&&key.replaceAll("\\s","").replace(" ","").length()>0){
            return true;
        }else {
            return false;
        }
    }

    public static String reAllNull(String key){
        if(PdNullUtils.nullor(key)){
            return key.replaceAll("\\s", "").replace(" ", "")
                    .replace(" ","").replace("　","")
                    .replace("　","").trim();
        }else{
            return null;
        }
    }

    public static String reAllTeSh(String key){
        if(PdNullUtils.nullor(key)){
            return key.replaceAll("\001", "").trim();
        }else{
            return "";
        }
    }

    /**
     * 给省市区专用的去除空格的方法
     * @param key
     * @return
     */
    public static String reAllNullforSSQ(String key){
        if(PdNullUtils.nullor(key)){
            return key.replaceAll("\\s", "").replace(" ", "")
                    .replace(" ","").replace("　","")
                    .replace("　","").trim();
        }else{
            return "";
        }
    }

    public static String filterNull(String key){
        if(PdNullUtils.nullor(key)){
            if(!"null".equals(key)){
                return PdNullUtils.reAllNull(key);
            }else{
                return "";
            }
        }else{
            return "";
        }
    }

    public static String filterNullnoKg(String key){
        if(PdNullUtils.nullor(key)){
            if(!"null".equals(key)){
                return key;
            }else{
                return "";
            }
        }else{
            return "";
        }
    }

    /**
     * 给政策用的
     * @param key
     * @return
     */
    public static String filterNulls(String key){
        if(PdNullUtils.nullor(key)){
            if(!"null".equals(key)){
                return key.replaceAll("\\s", " ").replace(" ", "")
                        .replace("　","")
                        .replace("　","").trim();
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    public static String checkNull(String s) {
        String ss = "";
        if (!PdNullUtils.nullor(s)) {
            ss = "";
        } else {
            ss = s;
        }
        return ss;
    }





}
