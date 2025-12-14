package service;

import models.Commodity;
import models.Transaction;
import models.User;

import java.util.List;

public interface UserService {
    User createUser(User sessionUser, List<User> users);

    void handleOperation(User sessionUser, List<Commodity> commodities, List<Transaction> transactions);
}
