package mysql;


import java.util.Arrays;

public class testLambda {
    public static void main(String[] args) {

        String[] aaa = new String[]{"123","3213","3123"};
        //Arrays.sort(aaa, (s1, s2) -> s1.compareTo(s2));
        Arrays.sort(aaa,(a,b) ->a.compareTo(b));
        System.out.println(String.join(", ", aaa));
    }
}
