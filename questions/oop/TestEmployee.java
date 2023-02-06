package com.example.demo1.oop;

import com.example.demo1.oop.Employee;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestEmployee {

    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Bob", "Wayne", 22, 1234, 5000033));
        empList.add(new Employee(4, "Bob", "Paul", 42, 3000, 5002));
        empList.add(new Employee(3, "John", "Adam", 42, 4444, 500003));
        empList.add(new Employee(2, "James", "Adam", 33, 334, 1));


        /** The hasCode **/
        // 1. Consistency: HashCode method should always return the same hash code for a particular object if it is not modified
        // 2. Uniqueness: Ideally, the hash code for two different object should be different
        // 3. Distribution: HashCode should be evenly distributed  accross the entire range of possible values
        // 4, Performance: fast as possible, since it is called frequently.
        System.out.println(empList.get(0).hashCode());
        System.out.println(empList.get(1).hashCode());
        /** To compare two Java objects, we need to override both equals and hashCode (Good practice).**/
        System.out.println("------");
        HashMap<Employee, String> map = new HashMap<>();
        map.put(new Employee(1, "Lebron", "James", 33), "NBA player");

        Employee james = new Employee(2, "Lebron", "James", 33);
        Employee bob = new Employee(2, "Bob", "James", 33);
        String majorJames = map.get(james);
        String majorBob = map.get(bob);
        System.out.println("James's major is " + majorJames);
        System.out.println("James's major is " + majorBob);
        System.out.println("------");
        /**
         * If the hashCode and equals methods are implemented correctly, the color variable will be set to "NBA player"
         * and the output will be "James's major is NBA player". However, if the hashCode method is not implemented
         * correctly and returns different values for the same object, the map.get method may not be able to find the
         * correct value in the map, resulting in a null value being returned.
         *
         * In summary, implementing hashCode and equals methods correctly is crucial for ensuring that objects can be
         * correctly stored and retrieved in hash-based data structures like HashMap.
         *
         */

        // order by id
        Collections.sort(empList, (a, b) -> Integer.compare(b.getId(), a.getId()));

        /** Collection with comparator : sort by name and lastName */
        // String type object should use "CompareTo" instead of subtraction
        Collections.sort(empList, (a, b) -> {
            if (a.getFirstName().compareTo(b.getFirstName()) != 0) {
                return a.getFirstName().compareTo(b.getFirstName());
            } else {
                return a.getLasName().compareTo(b.getLasName());
            }
        });

        Collections.sort(empList, new EmployeeComparator());
        /*** Java 8 Comparator ***/
        // Comparator is an interface in Java 8 that is used to define the order of elements in the collection.
        empList.sort(Comparator.comparing(Employee::getFirstName).reversed().thenComparingInt(Employee::getSalary).reversed());
        empList.stream().forEach(System.out::println);
        System.out.println("------using Comparator ------");
        empList.sort(Comparator.comparing(Employee::getFirstName).reversed().thenComparingInt(Employee::getId));
        empList.stream().forEach(System.out::println);
        System.out.println("------using Comparator with lambda ------");
        empList.sort(Comparator.comparing(Employee::getLasName).reversed().thenComparingInt(e -> e.getId()).reversed());
        empList.stream().forEach(System.out::println);
        System.out.println("------");


//        for (int i = 0; i < empList.size(); i++) {
//            System.out.println(empList.get(i).toString());
//        }

        /** Java 8 Stream  API */
        // 1. filter() method
        empList.stream().filter(employee -> employee.getId() > 1 && employee.getLasName().equals("Adam")).forEach(System.out::println);
        // Java 8 stream println
        //empList.stream().forEach(System.out::println);


        /** sortFibonacciArray
         * Given the fibonacci sequence array, sort the array with all the odd numbers at the begining and the non even
         * numbers at the end.Don’t use any temp array.
         * **/
        int[] fib = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89,144,233,377,610,987, 1597, 2584};
        sortFibonacciArray(fib);
        System.out.println(Arrays.toString(fib));
        int[] fib2 = {0, 1, 1, 2, 3, 5, 8};
        sortFibonacciArray(fib2);
        System.out.println(Arrays.toString(fib2));
        /** Permutation of String **/
        List<String> prem = getPermutations("abc");
        prem.stream().forEach(System.out::println);
        System.out.println("------");
        List<String> premList = getPermutations2("abc");
        premList.stream().forEach(System.out::println);

        /** Given a hashmap with subject name and marks. Sort hashmap by values.*/
        System.out.println("------");
        sortMapTest();

        /**quick sort **/
        int[] arr = {10, 7, 8, 9, 1, 5};
        sort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }


    public static void sortFibonacciArray(int[] fib) {
        // 1, 1, 2, 3, 5
        // l
        //       r
        int l = 0;
        int r = fib.length - 1;

        while (l < r) {
            while (fib[l] % 2 == 0 && l < r) l++; // first half
            while (fib[r] % 2 != 0 && l < r) r--; // second half
            if (l < r) {
                int tmp = fib[l];
                fib[l] = fib[r];
                fib[r] = tmp;
            }
        }
    }

    public static List<String> getPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        getPermutations("", str, permutations);
        return permutations;
    }
    public static List<String> getPermutations2(String str) {
        List<String> permutations = new ArrayList<>();
        backtrack(str,0,str.length() -1, permutations);
        return permutations;
    }

    private static void getPermutations(String prefix, String str, List<String> permutations) {
        int n = str.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                getPermutations(prefix + str.charAt(i), str.substring(0, i) +
                        str.substring(i + 1, n), permutations);
            }
        }
    }

    public static String swap(String a, int i, int j) {
        char[] charArray = a.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
    private static void backtrack(String s, int idx, int n, List<String> res) {
        if (idx == n)
            res.add(s);
        else {
            for (int i = idx; i <= n; i++) {
                s = swap(s, idx, i);
                backtrack(s, idx + 1, n, res);
                s = swap(s, idx, i);
            }
        }
    }

    private static void sortMapTest() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Mathematics", 90);
        map.put("Science", 85);
        map.put("History", 75);
        map.put("Geography", 80);

        System.out.println("Unsorted Map: " + map);

        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare (Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }

        });

        HashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println("Sorted Map by Values in Descending Order: " + sortedMap);

        System.out.println("JAVA 8 stream API of Java 8 to sort the HashMap  Order");
        Map<String, Integer> sortedMap2 = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("Sorted Map by Values in Descending Order: " + sortedMap2);


    }

    // QuickSort function
    public static void sort(int[] arr, int low, int high) {
        // Check if low is smaller than high, if not the array is already sorted
        if (low < high) {
            // Get the pivot element from the middle of the list
            int pivot = partition(arr, low, high);

            // Sort the elements before pivot
            sort(arr, low, pivot - 1);

            // Sort the elements after pivot
            sort(arr, pivot + 1, high);
        }
    }

    // Partition function
    public static int partition(int[] arr, int low, int high) {
        // Select pivot element
        int pivot = arr[high];
        int i = low - 1;

        // Put elements smaller than pivot on the left
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap arr[i + 1] and arr[high]
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

}
