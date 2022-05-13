import java.text.ParseException;
import java.text.SimpleDateFormat;

public class testtime {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");

        String str1="20220513100000";
        String str2="20220513103000";

        //System.out.print(str2.compareTo(str1));
        long time1 = sdf.parse(str1).getTime();
        long time2 = sdf.parse(str2).getTime();
        System.out.print(time2>time1);

    }
}


