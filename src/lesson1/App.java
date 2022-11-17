package lesson1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        Trader justin = new Trader("Justin", "Canada");
        Trader selena = new Trader("Selena", "Canada");
        Trader zayn = new Trader("Zayn", "UK");
        Trader drake = new Trader("Drake", "USA");
        Trader smith = new Trader("Smith", "USA");
        Trader willow = new Trader("Willow", "Australia");

        Transaction transaction1 = new Transaction(justin, 2021, 15000);
        Transaction transaction2 = new Transaction(zayn, 2022, 37000);
        Transaction transaction3 = new Transaction(drake, 2013, 42000);
        Transaction transaction4 = new Transaction(smith, 2013, 76000);
        Transaction transaction5 = new Transaction(willow, 2013, 12000);
        Transaction transaction6 = new Transaction(selena, 2017, 45000);

        List<Transaction> listOfTransactions = new ArrayList<>();

        listOfTransactions.add(transaction1);
        listOfTransactions.add(transaction2);
        listOfTransactions.add(transaction3);
        listOfTransactions.add(transaction4);
        listOfTransactions.add(transaction5);
        listOfTransactions.add(transaction6);


        // Starting streaming process
        // Find all the transactions in 2013
        List<Transaction> filteredTransaction = listOfTransactions.stream()
                .filter(transaction -> transaction.getYear() == 2013)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        //filteredTransaction.forEach(System.out::println);

        // what are the unique cities where the traders work
        listOfTransactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        // Find trader from canada and sort by name
        listOfTransactions.stream()
//                .map(transaction -> transaction.getTrader())
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Canada"))
                .sorted(Comparator.comparing(Trader::getName).reversed())
                .forEach(System.out::println);

        // Return a string which contains all tranders names sorted alphabet
       String finalString =  listOfTransactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                        .collect(Collectors.joining(":"));
//                .reduce(":", (n1, n2) -> n1+":"+n2);

        System.out.println(finalString);

        // Any Traders from UK
        Boolean UKBased = listOfTransactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("UK"));

        System.out.println(UKBased);

        // Find highest amount of all the transactions
        Optional<Transaction> highestAmount = listOfTransactions.stream()
                        .max(Comparator.comparing(Transaction::getAmount));
        System.out.println(highestAmount);
    }
}
