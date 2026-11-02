package DSA.Practice.Nov22026;

import java.util.Arrays;

class MergeSort {

    public static void mergeSort(int[] arr, int low, int high) {

        // Base condition
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        // Divide into two halves
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        // Merge both sorted halves
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        // Compare elements from both halves
        while (i <= mid && j <= high) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements from left half
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from right half
        while (j <= high) {
            temp[k++] = arr[j++];
        }

        // Copy sorted elements back into original array
        for (int x = 0; x < temp.length; x++) {
            arr[low + x] = temp[x];
        }
    }

    public static void main(String[] args) {

        int[] arr = {38, 12, 27, 43, 9, 31, 18, 25};

        mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}

