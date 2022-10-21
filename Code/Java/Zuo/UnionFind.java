/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-10-20 19:03:08
 * @LastEditTime: 2022-10-20 22:30:37
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Leetcode/Code/Java/Zuo/UnionFind.java
 */
package Zuo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class UnionFind {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> networks;
        String[][] pairs;
        List<Integer> ans = new ArrayList<>();

        System.out.println("how many sets of data?");

        String t = scanner.nextLine();

        for (int i = 0; i < Integer.valueOf(t); i++) {
            System.out.println("how many pairs of relationships?");
            String m = scanner.nextLine();
            networks = new ArrayList<>();
            pairs = new String[Integer.valueOf(m)][2];
            for (int j = 0; j < Integer.valueOf(m); j++) {
                // m pairs:
                // split by possibly multiple spaces
                String[] arr = scanner.nextLine().split("\\s+");
                // check two?
                while (arr.length != 2) {
                    System.out.println("should be two inputs!");
                    arr = scanner.nextLine().split("\\s+");
                }
                if (!networks.contains(arr[0])) {
                    networks.add(arr[0]);
                }
                if (!networks.contains(arr[1])) {
                    networks.add(arr[1]);
                }
                pairs[j] = arr;
            }
            UnionFindSet<String> unionFindSet = new UnionFindSet<>(networks);
            for (String[] pair : pairs) {
                unionFindSet.union(pair[0], pair[1]);
            }
            int max = 1;
            for (int value : unionFindSet.sizeMap.values()) {
                if (max < value) {
                    max = value;
                }
            }
            System.out.println("Max is " + max);
            ans.add(max);
        }
        scanner.close();
    }
    public static class Element<V> {
        public V value;
        public Element(V value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<V> {
        public HashMap<V, Element<V>> elementMap;
        // key Element value: its father
        public HashMap<Element<V>, Element<V>> fatherMap;
        // key: Element of a set value: size of the set
        public HashMap<Element<V>, Integer> sizeMap;

        // 
        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<V>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        private Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>();
            while (element != fatherMap.get(element)) {
                path.push(element);
                element = fatherMap.get(element);
            }
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), element);
            }
            return element;
            // 递归实现：
            // if (element == fatherMap.get(element)) {
            //     return element;
            // }
            // fatherMap.put(element, findHead(fatherMap.get(element)));
            // return fatherMap.get(element);
        }

        public void union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> aF = findHead(elementMap.get(a));
                Element<V> bF = findHead(elementMap.get(b));
                if (aF != bF) {
                    Element<V> big = sizeMap.get(aF) >= sizeMap.get(bF) ? aF : bF;
                    Element<V> small = big == aF ? bF : aF;
                    fatherMap.put(small, big);
                    sizeMap.put(big, sizeMap.get(aF) + sizeMap.get(bF));
                    sizeMap.remove(small);
                }
            }
        }

        public boolean isSameSet(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }
    }
}
