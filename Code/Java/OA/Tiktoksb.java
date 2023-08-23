/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-12-02 23:09:08
 * @LastEditTime: 2022-12-02 23:16:33
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/OA/Tiktoksb.java
 */
package OA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tiktoksb {
    public class Solution {
        public static void main(String[] args) throws IOException {
            // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    
            // int numsCount = Integer.parseInt(bufferedReader.readLine().trim());
    
            // List<Integer> nums = IntStream.range(0, numsCount).mapToObj(i -> {
            //     try {
            //         return bufferedReader.readLine().replaceAll("\\s+$", "");
            //     } catch (IOException ex) {
            //         throw new RuntimeException(ex);
            //     }
            // })
            //     .map(String::trim)
            //     .map(Integer::parseInt)
            //     .collect(toList());
    
            Scanner scanner = new Scanner(System.in);
            String[] arr = scanner.nextLine().split(",");
            List<Integer> nums = new ArrayList<>();
            for (String num : arr) {
                nums.add(Integer.valueOf(num.trim()));
            }

            // int result = Result.pushtoback(nums);
            
            // bufferedWriter.write(String.valueOf(result));
            // bufferedWriter.newLine();
    
            // bufferedReader.close();
            // bufferedWriter.close();
        }
    }
}
