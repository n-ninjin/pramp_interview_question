package questions.backtrack;


import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

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

        /** Permutation of Num */
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = new ArrayList<>();
        helperNum(nums, 0, list);

        for (List<Integer> l : list) {
           System.out.println(Arrays.toString(l.toArray()));
        }

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
        backtrack(str,0, permutations);
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

    public static void backtrack(String s, int idx, List<String> res) {
        if (idx == s.length() - 1) {
            res.add(s);
        } else {
            for (int i = idx; i < s.length(); i++) {
                s = swap(s, idx, i);
                backtrack(s, idx + 1, res);
                s = swap(s, idx, i);
            }
        }
    }

    public static String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return String.valueOf(chars);
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

    public static void helperNum(int[] arr, int idx, List<List<Integer>> res) {
        if (idx == arr.length) {
            List<Integer> cur = new ArrayList<>();
            for (int n : arr) cur.add(n);
            res.add(cur);
        } else {
            for (int i = idx; i < arr.length; i++) {
                swap(arr, idx, i);
                helperNum(arr, idx + 1, res);
                swap(arr, idx, i);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
