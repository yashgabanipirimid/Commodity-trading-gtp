package models;
class Comodity {
    String Name;
    String Symbol;
    String Category;

    public Comodity(String symbol, String category, String name) {
        Symbol = symbol;
        Category = category;
        Name = name;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}