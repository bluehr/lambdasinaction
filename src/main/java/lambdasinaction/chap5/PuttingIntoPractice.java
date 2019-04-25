package lambdasinaction.chap5;


import java.util.*;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class PuttingIntoPractice {
    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300,true),
            new Transaction(raoul, 2012, 1000,false),
            new Transaction(raoul, 2011, 400,true),
            new Transaction(mario, 2012, 710,true),
            new Transaction(mario, 2012, 700,false),
            new Transaction(alan, 2012, 950,false)
        );


//        (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
        List<Transaction> collect = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue)).collect(toList());
//        (2) 交易员都在哪些不同的城市工作过？
        List<String> citys = transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().collect(toList());
//        (3) 查找所有来自于剑桥的交易员，并按姓名排序。

        List<Trader> traders = transactions.stream()
                        .map(Transaction::getTrader)
                        .filter(trader -> trader.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(comparing(Trader::getName))
                        .collect(toList());
        System.out.println(traders);
//        (4) 返回所有交易员的姓名字符串，按字母顺序排序。
        String s = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);

//        (5) 有没有交易员是在米兰工作的？
        boolean anyMatch = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        if (anyMatch) {
            System.out.println("有在米兰工作的员工");
        }
//        (6) 打印生活在剑桥的交易员的所有交易额。
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
//        (7) 所有交易中，最高的交易额是多少？
        Optional<Integer> optionalInteger = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        optionalInteger.ifPresent(System.out::println);


//        (8) 找到交易额最小的交易。


//        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
//        List<Transaction> tr2011 = transactions.stream()
//                                               .filter(transaction -> transaction.getYear() == 2011)
//                                               .sorted(comparing(Transaction::getValue))
//                                               .collect(toList());
//        System.out.println(tr2011);
//
//        // Query 2: What are all the unique cities where the traders work?
//        List<String> cities =
//            transactions.stream()
//                        .map(transaction -> transaction.getTrader().getCity())
//                        .distinct()
//                        .collect(toList());
//        System.out.println(cities);
//
//        // Query 3: Find all traders from Cambridge and sort them by name.
//
//        List<Trader> traders =
//            transactions.stream()
//                        .map(Transaction::getTrader)
//                        .filter(trader -> trader.getCity().equals("Cambridge"))
//                        .distinct()
//                        .sorted(comparing(Trader::getName))
//                        .collect(toList());
//        System.out.println(traders);
//
//
//        // Query 4: Return a string of all traders’ names sorted alphabetically.
//
//        String traderStr =
//            transactions.stream()
//                        .map(transaction -> transaction.getTrader().getName())
//                        .distinct()
//                        .sorted()
//                        .reduce("", (n1, n2) -> n1 + n2);
//        System.out.println(traderStr);
//
//        // Query 5: Are there any trader based in Milan?
//
//        boolean milanBased =
//            transactions.stream()
//                        .anyMatch(transaction -> transaction.getTrader()
//                                                            .getCity()
//                                                            .equals("Milan")
//                                 );
//        System.out.println(milanBased);
//
//
//        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
//        transactions.stream()
//                    .map(Transaction::getTrader)
//                    .filter(trader -> trader.getCity().equals("Milan"))
//                    .forEach(trader -> trader.setCity("Cambridge"));
//        System.out.println(transactions);
//
//
//        // Query 7: What's the highest value in all the transactions?
//        int highestValue =
//            transactions.stream()
//                        .map(Transaction::getValue)
//                        .reduce(0, Integer::max);
//        System.out.println(highestValue);
    }
}