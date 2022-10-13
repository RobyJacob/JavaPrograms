public class MooreVoting {
    static int voting(int[] arr) {
        int count = 0, candidate = -1;

        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                candidate = arr[i];
                count++;
            } else {
                if (arr[i] == candidate)
                    count++;
                else
                    count--;
            }
        }

        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == candidate)
                count++;
        }

        if (count > arr.length / 2)
            return candidate;

        return -1;
    }

    public static void main(String[] args) {
        int res = voting(new int[] {1, 2, 1, 2, 2, 2, 1});

        System.out.println(res);
    }
}
