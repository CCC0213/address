import java.text.ParseException;
import java.text.SimpleDateFormat;

public class testtime {

    public static void main(String[] args) throws ParseException {


        String str1="20220513100000";
        String str2="20220513103000";

        //System.out.print(str2.compareTo(str1));
        Boolean bl = minuteComperString(str1,str2);
        System.out.print(bl);

    }

    public static Boolean minuteComperString(String str1, String str2) {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
        long time1 = 0;
        long time2 = 0;
        try {
            time1 = sdf.parse(str1).getTime();
            time2 = sdf.parse(str2).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Boolean bl = time1>time2;
        return bl;
    }
}


