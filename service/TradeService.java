package service;

import models.Commodity;
import models.Transaction;
import models.User;

import java.util.List;

public interface TradeService {
    void processBuy(int commodityID, int quantity, List<Commodity> commodities, User sessionUser, List<Transaction> transactions);

    void InitializeThreads(List<Commodity> commodities);

}
