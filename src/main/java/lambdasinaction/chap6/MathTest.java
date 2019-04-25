package lambdasinaction.chap6;

import java.sql.SQLOutput;
import java.util.stream.IntStream;

public class MathTest {
    public static Boolean isPrime(int targetNumber) {
        if (targetNumber <= 3) {
            return targetNumber > 1;
        }
        int candidateRoot = (int) Math.sqrt((double) targetNumber);
        return IntStream.range(2, candidateRoot)
                .noneMatch(i -> targetNumber % i == 0);
    }

    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();

        IntStream.range(0, 1000000)
                .forEach(
                        n->{
                            if (isPrime(n)) {
                                System.out.println(n+"是质数");
                            }
                        });
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("耗时："+(currentTimeMillis1 - currentTimeMillis)+"毫秒");
    }



    public static boolean testIsPrime3(int n){
        if (n <= 3) {
            return n > 1;
        }

        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }
}
