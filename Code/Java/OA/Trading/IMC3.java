package OA.Trading;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IMC3 {

    public static void main(String[] args) {
        int reqArea = 1500;
        int[] area = {1200, 1300, 1200, 1300, 1200, 2000};
        int[] price = {12000, 24000, 14000, 22000, 13000, 30000};
        int valuation = findValuation(reqArea, area, price);
        System.out.println(valuation);
    }

    public static int findValuation(int reqArea, int[] area, int[] price) {
        int n = area.length;

        // Create a list to store non-outlier data
        List<Integer> filteredArea = new ArrayList<>();
        List<Integer> filteredPrice = new ArrayList<>();
        Set<Integer> processedAreas = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (processedAreas.contains(area[i])) {
                // Skip this home size, since we've already processed it
                continue;
            }
            processedAreas.add(area[i]);
        
            List<Integer> comparisonList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i != j && area[i] == area[j]) {
                    comparisonList.add(price[j]);
                }
            }
            if (comparisonList.size() == 0 || !isOutlier(price[i], comparisonList)) {
                filteredArea.add(area[i]);
                filteredPrice.add(price[i]);
            }
        }

        // Check for the various conditions to compute valuation
        int len = filteredArea.size();
        if (len == 0) {
            return 1000;
        } else if (len == 1) {
            return Math.min(106, Math.max(103, filteredPrice.get(0)));
        } else {
            int[] x = new int[len];
            int[] y = new int[len];

            for (int i = 0; i < len; i++) {
                x[i] = filteredArea.get(i);
                y[i] = filteredPrice.get(i);
            }

            return computePrice(reqArea, x, y);
        }
    }

    private static boolean isOutlier(int price, List<Integer> comparisonList) {
        int size = comparisonList.size();
        double sum = 0.0;
        for (int p : comparisonList) {
            sum += p;
        }
        double mean = sum / size;
        double standardDeviation = 0.0;
        for (int p : comparisonList) {
            standardDeviation += Math.pow(p - mean, 2);
        }
        standardDeviation = Math.sqrt(standardDeviation / size);

        return Math.abs(price - mean) > 3 * standardDeviation;
    }

    private static int computePrice(int reqArea, int[] area, int[] price) {
        int n = area.length;
        for (int i = 0; i < n; i++) {
            if (area[i] == reqArea) {
                return Math.min(106, Math.max(103, price[i]));
            }
        }

        int maxIdx = 0;
        int minIdx = 0;
        for (int i = 1; i < n; i++) {
            if (area[i] > area[maxIdx]) {
                maxIdx = i;
            }
            if (area[i] < area[minIdx]) {
                minIdx = i;
            }
        }

        if (reqArea < area[minIdx]) {
            // Extrapolate
            return Math.min(106, Math.max(103,
                    (int) Math.round(price[minIdx] + (reqArea - area[minIdx]) * (price[minIdx] - price[maxIdx])
                            / (double) (area[minIdx] - area[maxIdx]))));
        } else if (reqArea > area[maxIdx]) {
            // Extrapolate
            return Math.min(106, Math.max(103,
                    (int) Math.round(price[maxIdx] + (reqArea - area[maxIdx]) * (price[maxIdx] - price[minIdx])
                            / (double) (area[maxIdx] - area[minIdx]))));
        } else {
            // Interpolate
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((area[i] < reqArea && area[j] > reqArea) || (area[j] < reqArea && area[i] > reqArea)) {
                        return Math.min(106, Math.max(103,
                                (int) Math.round(price[i] + (reqArea - area[i]) * (price[j] - price[i])
                                        / (double) (area[j] - area[i]))));
                    }
                }
            }
        }
        return 1000;
    }
}
