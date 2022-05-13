import java.text.SimpleDateFormat;

public class testtime {

    public static void main(String[] args) {

        SimpleDateFormat sdf =new SimpleDateFormat();

        String str1="20220513100000";
        String str2="20220513103000";

        System.out.print(str2.compareTo(str1));


    }
}


