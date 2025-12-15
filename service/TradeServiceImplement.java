package service;

import models.Commodity;
import models.Transaction;
import models.User;
import threads.GoldPriceThread;
import threads.OilPriceThread;
import threads.SilverPriceThread;
import util.DateTimeUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TradeServiceImplement implements TradeService {

    @Override
    public void processBuy(int commodityID, int quantity, List<Commodity> commodities, User sessionUser, List<Transaction> transactions) {

        Commodity commodity = commodities.get(commodityID);

        String pathName = commodity.getPathName();
        File filePath = new File(pathName);

        int currentPrice = 0;
        int currentQuantity = commodity.getQuantity();

        try (Scanner myReader = new Scanner(filePath)) {
            currentPrice = myReader.nextInt();
        } catch (FileNotFoundException e) {
            System.out.println("Price File Not found");
        }

        int transactionSize = transactions.size();
        LocalDateTime now = DateTimeUtil.getCurrentDateTime();
        String formattedNow = DateTimeUtil.formateDate(now);

        Transaction newTransaction = new Transaction(transactionSize + 1, formattedNow, currentPrice, commodityID, sessionUser.getId(), quantity);

        int billPrice = quantity * currentPrice;
        int currentBalance = sessionUser.getTotalBalance();
        synchronized (this) {
            if (currentBalance >= billPrice) {
                sessionUser.setTotalBalance(currentBalance - billPrice);
                if (quantity < currentQuantity) {
                    transactions.add(newTransaction);
                    commodity.setQuantity(currentQuantity - quantity);

                    System.out.println("Successfully Bought");
                    System.out.println("Quantity Left" + commodity.getQuantity());
                } else {
                    System.out.println("Insufficient Quantity");
                }
            } else {
                System.out.println("Insufficient Balance");
            }
        }
    }

    public void InitializeThreads(List<Commodity> commodities) {
        Commodity gold = new Commodity(0, "AU", "Metal", "Gold", "./resource/gold.txt");
        Commodity silver = new Commodity(1, "AG", "Metal", "Silver", "./resource/silver.txt");
        Commodity oil = new Commodity(2, "Oil", "Liquid", "Oil", "./resource/oil.txt");
        commodities.add(gold);
        commodities.add(silver);
        commodities.add(oil);


        GoldPriceThread goldThread = new GoldPriceThread();
        SilverPriceThread silverThread = new SilverPriceThread();
        OilPriceThread oilThread = new OilPriceThread();


        ScheduledExecutorService goldScheduler = Executors.newScheduledThreadPool(10);
        ScheduledExecutorService silverScheduler = Executors.newScheduledThreadPool(10);
        ScheduledExecutorService oilScheduler = Executors.newScheduledThreadPool(10);

        goldScheduler.scheduleWithFixedDelay(goldThread, 0, 1, TimeUnit.SECONDS);
        silverScheduler.scheduleWithFixedDelay(silverThread, 0, 1, TimeUnit.SECONDS);
        oilScheduler.scheduleWithFixedDelay(oilThread, 0, 1, TimeUnit.SECONDS);
    }

}
