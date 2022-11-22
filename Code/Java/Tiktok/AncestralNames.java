/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-22 00:09:26
 * @LastEditTime: 2022-11-22 00:09:26
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tiktok/AncestralNames.java
 */
package Tiktok;

import java.util.Arrays;
import java.util.HashMap;

public class AncestralNames {
    public static int romanToInt(String roman) {
        int total = 0;
        //create hashmap to store the roman numerals
        HashMap<Character, Integer> romans = new HashMap<>();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);
        for (int j = 0; j < roman.length(); j++) {
            char c = roman.charAt(j); //grab first char
            //check to see if next roman is greater
            if (j + 1 < roman.length() && romans.get(c) < romans.get(roman.charAt(j + 1))) {
                //if next roman is greater, you need to subtract
                int add = romans.get(roman.charAt(j + 1)) - romans.get(c);
                total += add;
                j++; //skip over next one since already calculated
            }
            //if less than, just add in order
            else {
                total += romans.get(c);
            }
        }
        return total;
    }

    public static String[] getSortedList(String[] names) {
        Arrays.sort(names, (s1, s2) -> {
            //split the strings up into name,roman
            String[] arr1 = s1.split(" ");
            String[] arr2 = s2.split(" ");

            //grab the numerical values of the romans
            int val1 = romanToInt(arr1[1]);
            int val2 = romanToInt(arr2[1]);

            //if the names are equal, compare the numerals
            if (arr1[0].equals(arr2[0])) {
                //if first one is greater than, push it back
                if (val1 > val2) {
                    return 1;
                }
                //if first one is less than, stay same
                else {
                    return -1;
                }
            }
            else { //if not same, just compare the names
                return arr1[0].compareTo(arr2[0]);
            }
        });
        return names;
    }

    public static void main(String[] args) {
        String[] names = {"Steven XVI", "David IX", "Steven XL", "Mary XV", "Mary XIII", "Mary XX"};
        System.out.println(Arrays.toString(getSortedList(names)));
    }
 }
