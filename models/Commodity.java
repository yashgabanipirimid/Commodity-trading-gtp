package models;

public class Commodity {
    private final String name;
    private final String symbol;
    private final String category;
    private final int commodityId;
    private int quantity;
    private String pathName;


    public Commodity(int CommodityId, String symbol, String category, String name, String pathName) {
        this.commodityId = CommodityId;
        this.symbol = symbol;
        this.category = category;
        this.name = name;
        this.pathName = pathName;
        this.quantity = 1000;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        symbol = symbol;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        commodityId = commodityId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        category = category;
    }
}