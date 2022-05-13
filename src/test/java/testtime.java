import java.text.ParseException;
import java.text.SimpleDateFormat;

public class testtime {

    public static void main(String[] args) throws ParseException {


        String str1="20220513100000";
        String str2="20220513103000";

        //System.out.print(str2.compareTo(str1));
        Boolean bl = minuteComper(str1,str2);
        System.out.print(bl);

    }

    public static Boolean minuteComper(String str1, String str2) throws ParseException {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
        long time1 = sdf.parse(str1).getTime();
        long time2 = sdf.parse(str2).getTime();
        Boolean bl = time1>time2;
        return bl;
    }
}


