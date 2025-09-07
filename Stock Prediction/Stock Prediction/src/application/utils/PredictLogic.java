package application.utils;

import java.util.List;

public class PredictLogic {

    public static double predictNextPrice(List<Double> prices) {
        int size = prices.size();
        int window = Math.min(3, size);  // Use last 3 prices or fewer

        double sum = 0;
        for (int i = size - window; i < size; i++) {
            sum += prices.get(i);
        }

        return sum / window;
    }
}
