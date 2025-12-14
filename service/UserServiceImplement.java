package service;

import models.Commodity;
import models.Transaction;
import models.User;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.exit;

public class UserServiceImplement implements UserService {
    private final TradeServiceImplement commodityService = new TradeServiceImplement();

    @Override
    public User createUser(User sessionUser, List<User> users) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Username ");
        String userName = scanner.nextLine();
        System.out.println("Enter Your Password");
        String Password = scanner.nextLine();
        for (User user : users) {
            if (Objects.equals(userName, user.getuserName()) && Password.equals(user.getpassWord())) {
                sessionUser = user;
                break;
            }
        }
        if (sessionUser == null) {
            User newUser = new User(userName, 0, users.size() + 1, Password);
            System.out.println(newUser);
            users.add(newUser);
            return newUser;
        }
        return sessionUser;
    }

    @Override
    public void handleOperation(User sessionUser, List<Commodity> commodities, List<Transaction> transactions) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Select operation to perform");
            System.out.println("1 - Buy a Commodity");
            System.out.println("2- Add Funds");
            System.out.println("3 - See Transaction History");

            int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    System.out.println("Select a Commodity");
                    System.out.println("1 - Gold");
                    System.out.println("2 - Silver");
                    System.out.println("3 - Oil");
                    int BuyOperation = scanner.nextInt();
                    System.out.println("Enter Quantity");
                    int Quantity = scanner.nextInt();

                    commodityService.processBuy(BuyOperation - 1, Quantity, commodities, sessionUser, transactions);
                    break;
                case 2:
                    System.out.println("Enter amount to Add");
                    int amount = scanner.nextInt();
                    synchronized (this) {
                        int currentBalance = sessionUser.getTotalBalance();
                        sessionUser.setTotalBalance(currentBalance + amount);
                    }
                    break;
                case 3:
                    transactions.stream().filter(transaction -> transaction.getUserId() == sessionUser.getId()).forEach(transaction -> System.out.println("Transaction Id :-" + transaction.getTransactionId() + " User Id :-" + transaction.getUserId() + " Commodity :-" + transaction.getCommodityId() + " Price :-" + transaction.getPrice() + " Quantity :- " + transaction.getQuantity() + " Time :-" + transaction.getTimeStamp()));
                    break;
                default:
                    exit(0);
            }
        }
    }
}
