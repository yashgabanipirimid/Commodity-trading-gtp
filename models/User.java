package models;

public class User {
    private String userName;
    private int id;
    private int totalBalance;
    private String passWord;

    public User(String userName, int totalBalance, int id, String passWord) {
        this.userName = userName;
        this.totalBalance = totalBalance;
        this.id = id;
        this.passWord = passWord;
    }

    public String getpassWord() {
        return passWord;
    }

    public void setPassword(String password) {
        passWord = password;
    }

    public String getuserName() {
        return userName;
    }

    public void setUsername(String username) {
        userName = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(int totalBalance) {
        this.totalBalance = totalBalance;
    }
}