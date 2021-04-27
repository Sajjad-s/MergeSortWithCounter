import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Main {



    @Test
    public void positiveTest(){
        int i = 0;
        int[] actual = {3,4,1,2,5};
        int[] expected = {1,2,3,4,5};

        int counter = Main.mergeSort(actual,actual.length);
        assertArrayEquals(expected,actual);
        System.out.println("*******"+counter);
    }

    private static int mergeSort(int[] array, int length) {
        int counter = 0;
        if (length <2) {

            return length;
        }

        int mid = length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[length - mid];

        for (int i = 0; i < mid ; i++) {
            leftArray[i] = array [i] ;
        }

        for (int i = mid; i < length ; i++) {
            rightArray[i - mid] = array [i];
        }

        counter += mergeSort( leftArray, mid);
        counter += mergeSort( rightArray,length-mid);
        counter += merge( array, leftArray, rightArray, mid, length-mid);
        return counter;
    }

    public static int merge(int[] array, int[] leftArray, int[] rightArray, int left, int right){

        int i = 0,  j = 0, k = 0, counter = 0;
        while (i < left && j < right){
            if (leftArray[i] < rightArray [j]) {
                array[k++] = leftArray[i++];
                counter ++;
            }
            else
                array[k++] = rightArray [j++];
        }
        while (i < left){
            array[k++] = leftArray[i++];
        }
        while (j < right){
            array[k++] = rightArray[j++];
        }
        return counter;


    }
}