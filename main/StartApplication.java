package main;

import models.Commodity;
import models.Transaction;
import models.User;
import service.TradeService;
import service.TradeServiceImplement;
import service.UserService;
import service.UserServiceImplement;

import java.util.ArrayList;
import java.util.List;

public class StartApplication {
    static List<User> users = new ArrayList<>();
    static List<Transaction> transactions = new ArrayList<>();
    static List<Commodity> commodities = new ArrayList<>();
    static User sessionUser = null;

    public static void main(String[] args) {
        TradeService tradeService = new TradeServiceImplement();
        UserService userService = new UserServiceImplement();
        tradeService.InitializeThreads(commodities);
        sessionUser = userService.createUser(sessionUser, users);
        userService.handleOperation(sessionUser, commodities, transactions);
    }
}