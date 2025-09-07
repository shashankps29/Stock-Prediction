package application.model;

public class Stock {
    private int id;
    private String symbol;
    private String name;

    public Stock(int id, String symbol, String name) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
    }

    // ✅ Add this constructor for use when ID is not yet assigned
    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }
}
