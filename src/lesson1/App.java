package lesson1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        Trader justin = new Trader("Justin", "Canada");
        Trader zayn = new Trader("Zayn", "UK");
        Trader drake = new Trader("Drake", "USA");
        Trader smith = new Trader("Smith", "USA");
        Trader willow = new Trader("Willow", "Australia");

        Transaction transaction1 = new Transaction(justin, 2021, 15000);
        Transaction transaction2 = new Transaction(zayn, 2022, 37000);
        Transaction transaction3 = new Transaction(drake, 2013, 42000);
        Transaction transaction4 = new Transaction(smith, 2013, 76000);
        Transaction transaction5 = new Transaction(willow, 2013, 12000);

        List<Transaction> listOfTransactions = new ArrayList<>();
        listOfTransactions.add(transaction1);
        listOfTransactions.add(transaction2);
        listOfTransactions.add(transaction3);
        listOfTransactions.add(transaction4);
        listOfTransactions.add(transaction5);

        // Starting streaming process
        List<Transaction> filteredTransaction = listOfTransactions.stream()
                .filter(transaction -> transaction.getYear() == 2013)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        filteredTransaction.forEach(System.out::println);

    }
}
