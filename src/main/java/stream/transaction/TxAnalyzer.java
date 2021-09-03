package stream.transaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TxAnalyzer {
    public static void main(String[] args) {
        List<Transaction> transaction = Transaction.getTransaction();
        System.out.println("transaction");
        System.out.println(transaction);

        // 1. 통화별로 구분
        Map<Currency, List<Transaction>> collect = transaction.stream()
                .collect(Collectors.groupingBy(tx -> tx.getCurrency()));
        System.out.println("collect");
        System.out.println(collect);
    }
}
