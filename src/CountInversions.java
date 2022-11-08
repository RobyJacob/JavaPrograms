import java.util.Arrays;

public class CountInversions {
    static long merge(long[] arr, int l, int r, int m) {
        int k = 0, i = l, j = m;
        long[] newArr = new long[arr.length];
        long countInversion = 0;

        while (i < m && j <= r) {
            if (arr[i] <= arr[j]) {
                newArr[k++] = arr[i++];
            } else {
                newArr[k++] = arr[j++];
                countInversion = countInversion + ((m + 1) - i);
            }
        }

        while (i < m) newArr[k++] = arr[i++];

        while (j <= r) newArr[k++] = arr[j++];

        if (r + 1 - l >= 0) System.arraycopy(newArr, l, arr, l, r + 1 - l);

        return countInversion;
    }

    static long mergeSort(long[] arr, int l, int r) {
        long countInversion = 0;

        if (l < r) {
            int mid = (l + r) / 2;

            countInversion += mergeSort(arr, l, mid);
            countInversion += mergeSort(arr, mid + 1, r);

            countInversion += merge(arr, l, r, mid);
        }

        return countInversion;
    }

    static long inversionCount(long[] arr, long N) {
        return mergeSort(arr, 0, (int) N - 1);
    }

    public static void main(String[] args) {
        long res = inversionCount(new long[] {468,335,1,170,225,479,359,463,465,206,146,282,328,462,492,496,443,328,437,392,105,403,154,293,383,422,217,219,396,448,227,272,39,370,413,168,300,36,395,204,312,323}, 42);

        System.out.println("\n" + res);
    }
}
