import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BigInteger f0 = BigInteger.ONE;
        BigInteger f1 = BigInteger.valueOf(3);

        ArrayList<BigInteger> oddValues = new ArrayList<>();
        oddValues.add(f0);
        oddValues.add(f1);

        BigInteger prev2 = f0;
        BigInteger prev1 = f1;

        while (oddValues.size() < 40) {
            BigInteger fn = prev1.multiply(BigInteger.valueOf(5)).add(prev2);
            if (fn.mod(BigInteger.TWO).equals(BigInteger.ONE)) {
                oddValues.add(fn);
            }
            prev2 = prev1;
            prev1 = fn;
        }
        System.out.println("A[39]:");
        System.out.println(oddValues.get(39));
    }
}
