import java.util.Arrays;

public class FindRangeInSortedArr {
    static int findFirst(int[] arr, int ele) {
        int l = 0, h = arr.length - 1, res = -1;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (arr[mid] >= ele) {
                h = mid - 1;
                if (arr[mid] == ele) res = mid;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }

    static int findSecond(int[] arr, int ele) {
        int l = 0, h = arr.length - 1, res = -1;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (arr[mid] <= ele) {
                l = mid + 1;
                if (arr[mid] == ele) res = mid;
            } else {
                h = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,3,4};
        int first = findFirst(arr, 3);
        int second = findSecond(arr, 3);

        System.out.println(Arrays.asList(first, second));
    }
}
