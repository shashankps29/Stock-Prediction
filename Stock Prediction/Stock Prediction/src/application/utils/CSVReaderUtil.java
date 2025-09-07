package application.utils;

import application.dao.StockDAO;
import application.model.StockData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderUtil {

    public static void readAndInsertCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;
            StockDAO dao = new StockDAO();

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                // Skip header
                if (lineNumber == 1 && line.toLowerCase().contains("stock name")) continue;

                String[] parts = line.split(",");
                if (parts.length != 3) {
                    System.out.println("❌ Skipped line " + lineNumber + ": Invalid format");
                    continue;
                }

                String name = parts[0].trim().replaceAll("\"", "");
                String date = parts[1].trim().replaceAll("\"", "");
                double price = Double.parseDouble(parts[2].trim().replaceAll("\"", ""));

                StockData stock = new StockData(name, date, price);
                boolean success = dao.addStock(stock);

                if (success) {
                    System.out.println("✅ Inserted: " + name + " | " + date + " | " + price);
                } else {
                    System.out.println("❌ Insert failed at line " + lineNumber);
                }
            }

        } catch (IOException e) {
            System.err.println("❌ Error reading CSV: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
