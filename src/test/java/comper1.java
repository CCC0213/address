import java.math.BigDecimal;

public class comper1 {

    public static void main(String[] args) {

        BigDecimal feltBig = new BigDecimal("20220515231500");
        BigDecimal chtmBig = new BigDecimal("20220515233000");
        System.out.print(chtmBig.compareTo(feltBig));
    }

}
