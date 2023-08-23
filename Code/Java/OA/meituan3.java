package OA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class meituan3 {
      public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        String[] arrLine = cin.nextLine().split(" ");
        int number = Integer.valueOf(arrLine[0]);
        int day = Integer.valueOf(arrLine[1]);
        ArrayList<Integer> list = new ArrayList(number);
        for (int i = 0; i < number; i++) {
          list.add(i);
        }
        UnionFindSet ufs = new UnionFindSet(list);
        for (int i = 0; i < day; i++) {
          String[] query = cin.nextLine().split(" ");
          String op = query[0];
          int city = Integer.valueOf(query[1]);
          if (op.equals("L")) {
            if (city == 1) {
              continue;
            }
            ufs.unionLeft(city, city - 1);
            ufs.unionRight(city, city - 1);
          } else if (op.equals("R")) {
            if (city == number) {
              continue;
            }
            ufs.unionRight(city, city + 1);
            ufs.unionLeft(city, city + 1);
          } else if (op.equals("Q")) {
            Element<Integer> left = (Element<Integer>) ufs.elementMap.get(city);
            Element<Integer> left = ufs.findLeft();
            Element<Integer> right = ufs.findRight(city);
            
          }
        }
      }
      public int compareTo(Integer a, Integer b) {
          return a.compareTo(b);
      }
      public static class Element<V> {
        public V value;
        public Element(V value) {
          this.value = value;
        }
        public V getValue() {
          return value;
        }
      }
      public static class UnionFindSet<V> {
        public HashMap<V, Element<V>> elementMap;
        public HashMap<Element<V>, Element<V>> leftFatherMap;
        public HashMap<Element<V>, Element<V>> rightFatherMap;
        public UnionFindSet(List<V> list) {
          elementMap = new HashMap<>();
          leftFatherMap = new HashMap<>();
          rightFatherMap = new HashMap<>();
          for (V value : list) {
            Element<V> element = new Element<V>(value);
            elementMap.put(value, element);
            leftFatherMap.put(element, element);
            rightFatherMap.put(element, element);
          }
        }
        public Element<V> findLeft(Element<V> element) {
          Stack<Element<V>> path = new Stack<>();
          while (element != leftFatherMap.get(element)) {
            path.push(element);
            element = leftFatherMap.get(element);
          }
          while (!path.isEmpty()) {
            leftFatherMap.put(path.pop(), element);
          }
          return element;
        }
        public Element<V> findRight(Element<V> element) {
          Stack<Element<V>> path = new Stack<>();
          while (element != rightFatherMap.get(element)) {
            path.push(element);
            element = rightFatherMap.get(element);
          }
          while (!path.isEmpty()) {
            rightFatherMap.put(path.pop(), element);
          }
          return element;
        }
       
        public void unionLeft(V a, V b) {
          if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            Element<V> aF = findLeft(elementMap.get(a));
            Element<V> bF = findLeft(elementMap.get(b));
            if (aF != bF) {
              V af = aF.getValue();
              V bf = bF.getValue();
              int c = ((String) af).compareTo((String) bf);
              Element<V> small = (c <= 0) ? aF : bF;
              Element<V> big = small == aF ? bF : aF;
              leftFatherMap.put(big, small);
            }
          }
        }
        public void unionRight(Integer a, Integer b) {
          if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            Element<V> aF = findRight(elementMap.get(a));
            Element<V> bF = findRight(elementMap.get(b));
            if (aF != bF) {
              V af = aF.getValue();
              V bf = bF.getValue();
              int c = ((String) af).compareTo((String) bf);
              Element<V> small = (c <= 0) ? aF : bF;
              Element<V> big = small == aF ? bF : aF;
              rightFatherMap.put(small, big);
            }
          }
        }
      }
}
