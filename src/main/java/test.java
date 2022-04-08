
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class test {

    public static void main(String[] args) {
        /*String afid ="4719000";
        String apcdfimd="20220222";
        String afidapcdfimd="20220222";

        if(!PdNullUtils.nullor(afid) || (PdNullUtils.nullor(afid) && !apcdfimd.equals(afidapcdfimd))){
            System.out.println("1");
        }

        if(PdNullUtils.nullor(afid) && apcdfimd.equals(afidapcdfimd)){
            System.out.println("2");
        }
*/
        /*int a=1;
        int b=3;
        int c=5;
        boolean d=true;
        System.out.println(a>b||c>b&&d);//==>F||T&&T==>T
        System.err.println(b>a||a>c&&d);//==>T||F&&T==>T
        System.out.println(a>b||c>b&&false);//==>F||T&&F==>F
        System.out.println(b>a||c>b&&false);//==>T||T&&F==>T*/
        String afid="";
        String afidapcdfimd ="";
        String apcdfimd="20220225";
        if (!PdNullUtils.nullor(afid) || (PdNullUtils.nullor(afid) && !apcdfimd.equals(afidapcdfimd))) {
                System.out.println(true);
            }




        String afidapcdfrlt = "20220223121200";
        String apcdfptt ="20220223125000";
        String afidapcdfplt ="20220223115000";
        String apcdfrtt ="20220223134200";
        Integer releaseYesorNo = 0;

        System.out.println(Calendar.SECOND);

        if(PdNullUtils.nullor(afidapcdfrlt)){
            if(PdNullUtils.nullor(afidapcdfrlt) && PdNullUtils.nullor(apcdfptt) && PdNullUtils.nullor(afidapcdfplt)){
                Long normalDate1 = Long.valueOf(minutesCompute(String.valueOf(Long.valueOf(afidapcdfrlt) + Long.valueOf(apcdfptt) - Long.valueOf(afidapcdfplt)),1800));
                System.out.println(normalDate1);
                Long normalDate2 = Long.valueOf(minutesCompute(apcdfptt,1200));
                System.out.println(normalDate2);
                Long normalDate = normalDate1 > normalDate2 ? normalDate1 : normalDate2;
                releaseYesorNo = normalDate >= Long.valueOf(apcdfrtt) ? 1 : releaseYesorNo;
                System.out.println(releaseYesorNo);
            }
        }
        Calendar calender =Calendar.getInstance();
        System.out.println(Calendar.SECOND);
        System.out.println(calender.get(Calendar.SECOND));
        System.out.println(Calendar.MINUTE);
        System.out.println(calender.get(Calendar.MINUTE));
        System.out.println(Calendar.HOUR);
        System.out.println(calender.get(Calendar.HOUR));
    }

    public static String minutesCompute(String dateStr, int amount) {
        SimpleDateFormat sdf_return = new SimpleDateFormat("yyyyMMddHHmmss");
        java.util.Date date = null;
        try {
            if (dateStr.length() == 12) {
                SimpleDateFormat sdf_target = new SimpleDateFormat("yyyyMMddHHmm");
                date = sdf_target.parse(dateStr);
            } else if (dateStr.length() == 14) {
                SimpleDateFormat sdf_target = new SimpleDateFormat("yyyyMMddHHmmss");
                date = sdf_target.parse(dateStr);
            } else if (dateStr.length() == 16) {
                SimpleDateFormat sdf_target = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                date = sdf_target.parse(dateStr);
            } else if (dateStr.length() == 19) {
                SimpleDateFormat sdf_target = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                date = sdf_target.parse(dateStr);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Calendar calendar = new GregorianCalendar();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, amount);

        return sdf_return.format(calendar.getTime());
    }
}
