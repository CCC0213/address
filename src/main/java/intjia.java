import java.util.Scanner;
import java.util.function.IntBinaryOperator;

public class intjia {
    public static void main(String[] args) {
        Scanner ss= new Scanner(System.in);


        System.out.println("清输入第一个数：");
        int a = ss.nextInt();
        System.out.println("清输入第二个数：");
        int b= ss.nextInt();
        System.out.println(a+b);

        IntBinaryOperator intBinaryOperator = (int x, int y) -> {
            System.out.println(a*2 + b*3);
            return 1;
        };
    }
}
