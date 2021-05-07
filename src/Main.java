import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int length;
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many number you want to sort?");
        try {
            length = scanner.nextInt();
            System.out.format("Enter %d number\n", length);
            int[] inputArray = new int[length];

            for (int i = 0; i < length; i++) {
                inputArray[i] = scanner.nextInt();
            }
            int steps = Main.mergeSort(inputArray, inputArray.length);
            System.out.println("it's take " + steps + " Steps to sort the Array");
        } catch (NumberFormatException e) {
            System.out.println("Exception happened");
            e.printStackTrace();
        }

    }

    private static int mergeSort(int[] array, int length) {
        int counter = 0;
        if (length < 2) {
            return length;
        }
        int mid = length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[length - mid];
        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }
        for (int i = mid; i < length; i++) {
            rightArray[i - mid] = array[i];
        }
        counter += mergeSort(leftArray, mid);
        counter += mergeSort(rightArray, length - mid);
        counter += merge(array, leftArray, rightArray, mid, length - mid);
        return counter;
    }

    public static int merge(int[] array, int[] leftArray, int[] rightArray, int left, int right) {
        int i = 0, j = 0, k = 0, counter = 0;
        while (i < left && j < right) {
            if (leftArray[i] < rightArray[j]) {
                array[k++] = leftArray[i++];
                counter++;
            } else
                array[k++] = rightArray[j++];
        }
        while (i < left) {
            array[k++] = leftArray[i++];
        }
        while (j < right) {
            array[k++] = rightArray[j++];
        }
        return counter;
    }
}
