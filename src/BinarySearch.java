public class BinarySearch {
    /*
    Recursive implementation of binary search
     */

    static int binarySearch(int[] arr, int low, int high, int ele) {
        int mid = (low + high) / 2;

        if (arr[mid] == ele)
            return mid;

        if (arr[mid] > ele)
            return binarySearch(arr, low, mid - 1, ele);

        return binarySearch(arr, mid + 1, high, ele);
    }

    public static void main(String[] args) {
        int[] arr = new int[10000000];

        for (int i = 0; i < 10000000; i++)
            arr[i] = i;

        int idx = binarySearch(arr, 0, arr.length - 1, 1);

        System.out.println(idx);
    }
}
