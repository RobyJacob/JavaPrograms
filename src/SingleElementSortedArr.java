public class SingleElementSortedArr {
    static int findSingleElement(int[] arr) {
        int lo = 0, hi = arr.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (mid % 2 == 0) {
                if (mid < arr.length - 1 && arr[mid] == arr[mid + 1]) {
                    lo = mid + 1;
                } else if (mid > 0 && arr[mid] == arr[mid - 1]) {
                    hi = mid;
                } else {
                    return arr[mid];
                }
            } else {
                if (mid < arr.length - 1 && arr[mid] == arr[mid + 1]) {
                    hi = mid;
                } else if (arr[mid] == arr[mid - 1]) {
                    lo = mid + 1;
                } else {
                    return arr[mid];
                }
            }
        }

        return lo;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 2, 2, 3, 5, 5};

        int res = findSingleElement(arr);

        System.out.println(res);
    }
}
