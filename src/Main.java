import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import junit.framework.TestCase;


class MergeSortTest extends TestCase {
    private static int FIRST_ENTRY = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MergeSortTest mergesorttest = new MergeSortTest();
//        Integer[] unsortedInt = {1, 38, 27, 110, 9, 82, 10, 100, 299, 13};
        try {
            System.out.println("How many number you want to sort?");
            int length = scanner.nextInt();
            Integer[] unsortedInt = new Integer[length];
            System.out.println("Enter the numbers: ");
            for (int i = 0; i < length; i++) {
                int number = scanner.nextInt();
                unsortedInt[i] = number;
            }
            List<Integer> unsorted = Arrays.asList(unsortedInt);
            List<Integer> sorted = mergesorttest.mergeSort(unsorted);
            System.out.println("UnSorted List: " +unsorted.toString());
            System.out.println("Sorted List:   " +sorted.toString());
            int answer = mergesorttest.compare (sorted, unsorted);
            System.out.println( answer + " Items has been moved");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception happened");
        }
    }
    private int compare (List<Integer> sorted, List<Integer> unsorted){
        int counter = 0;
        for (int i = 0; i < sorted.size() ; i++) {
            if (sorted.get(i) != unsorted.get(i)) {
                counter++;
            }
        }
        return counter;
    }

    private List<Integer> mergeSort(List<Integer> list) {
        List<Integer> result;
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        int middle;
        int counter;
        if (list.size() <= 1) {
            return list;
        }
        middle = list.size() / 2;
        for (counter = 0; counter < middle; counter++) {
            left.add(list.get(counter));
        }

        for (counter = middle; counter < list.size(); counter++) {
            right.add(list.get(counter));
        }
        left = mergeSort(left);
        right = mergeSort(right);
        result = merge(left, right);
        return result;
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<Integer>();
        while (!left.isEmpty() || !right.isEmpty()) {
            if (!left.isEmpty() && !right.isEmpty()) {
                if (left.get(FIRST_ENTRY) <= right.get(FIRST_ENTRY)) {
                    handle(left, result);
                } else {
                    handle(right, result);
                }
            } else if (!left.isEmpty()) {
                handle(left, result);
            } else if (!right.isEmpty()) {
                handle(right, result);
            }
        }
        return result;
    }

    private void handle(List<Integer> list, List<Integer> result) {
        if (!list.isEmpty()) {
            result.add(list.get(FIRST_ENTRY));
            list.remove(FIRST_ENTRY);
        }
    }
}