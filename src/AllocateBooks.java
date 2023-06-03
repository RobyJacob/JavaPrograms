import java.util.Arrays;

public class AllocateBooks {
    static int allocateBooks(int[] pages, int numOfStudents) {
        if (pages.length < numOfStudents) return -1;

        int low = Arrays.stream(pages).max().getAsInt(), high = Arrays.stream(pages).sum();

        while (low < high) {
            int mid = (low + high) / 2;

            int sumOfPages = 0;
            int allocatableTo = 1;
            for (int page : pages) {
                sumOfPages += page;
                if (sumOfPages > mid) {
                    allocatableTo += 1;
                    sumOfPages = page;
                }
            }

            if (allocatableTo <= numOfStudents) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] pages = new int[] {12, 34, 67, 90};
        int maxOfMinAllocatableBooks = allocateBooks(pages, 2);

        System.out.println(maxOfMinAllocatableBooks);
    }
}
