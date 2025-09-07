package application.model;

import java.time.LocalDate;

public class StockData {
    private int id;
    private String stockName;
    private String date;
    private double closingPrice;

    public StockData(int id, String stockName, String date, double closingPrice) {
        this.id = id;
        this.stockName = stockName;
        this.date = date;
        this.closingPrice = closingPrice;
    }

    public StockData(String stockName, String date, double closingPrice) {
        this(0, stockName, date, closingPrice);
    }

    public StockData(String stockName, double closingPrice) {
        this(0, stockName, LocalDate.now().toString(), closingPrice);
    }

    public int getId() { return id; }
    public String getStockName() { return stockName; }
    public String getDate() { return date; }
    public double getClosingPrice() { return closingPrice; }
}
