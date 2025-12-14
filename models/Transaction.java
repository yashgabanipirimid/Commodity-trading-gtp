package models;

public class Transaction {

    private int transactionId;
    private int userId;
    private int commodityId;
    private int price;
    private String timeStamp;
    private int quantity;

    public Transaction(int transactionId, String timeStamp, int price, int commodityId, int userId, int quantity) {
        this.transactionId = transactionId;
        this.timeStamp = timeStamp;
        this.price = price;
        this.commodityId = commodityId;
        this.userId = userId;
        this.quantity = quantity;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}