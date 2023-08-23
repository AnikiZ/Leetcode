package OA.Cisco;

import java.util.ArrayList;
import java.util.List;

public class NumbersWithDigitSum {

    public static void main(String[] args) {
        int X = 20;
        int Y = 5;
        
        int count = findNumbersWithDigitSum(X, Y);
        
        System.out.println(count);
    }

    public static int findNumbersWithDigitSum(int X, int Y) {
        if (Y == 0) {
            return (X >= 0) ? 1 : -1;
        }
        int maxDigits = Integer.toString(X).length();
        int highestDigit = Character.getNumericValue(Integer.toString(X).charAt(0));
        
        List<String> combinations = new ArrayList<>();
        generateCombinations(new StringBuilder(), 0, Y, maxDigits, highestDigit, combinations);

        int count = 0;
        for (String combination : combinations) {
            System.out.println(combination);
            System.out.println(Integer.parseInt(combination));
            if (Integer.parseInt(combination) <= X) {
                count++;
            }
        }
        
        return count == 0 ? -1 : count;
    }
    
    private static void generateCombinations(StringBuilder suffix, int currentSum, int targetSum, int maxDigits, int highestDigit, List<String> combinations) {
        if (suffix.size > maxDigits || currentSum > targetSum) {
            return;
        }
        
        if (currentSum == targetSum && !suffix.isEmpty()) {
            combinations.add(suffix);
            return;
        }
        
        for (int i = 0; i <= 9; i++) {
            if (suffix.isEmpty() && i > highestDigit) {
                break;
            }
            generateCombinations(suffix + i, currentSum + i, targetSum, maxDigits, highestDigit, combinations);
        }
    }
}
