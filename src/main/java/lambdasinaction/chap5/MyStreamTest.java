package lambdasinaction.chap5;

import java.util.stream.Stream;

public class MyStreamTest {
    public static void main(String[] args) {
        Stream.generate(() -> (int) (Math.random() * 5 + 1)).limit(20).forEach(System.out::println);
    }
}
