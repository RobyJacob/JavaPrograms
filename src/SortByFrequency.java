import java.util.*;

public class SortByFrequency {
    /*
    Given an array of integers, sort the array according to frequency of elements.
    That is elements that have higher frequency come first.
    If frequencies of two elements are same, then smaller number comes first.

    Input:
N = 5
A[] = {5,5,4,6,4}
Output: 4 4 5 5 6
Explanation: The highest frequency here is
2. Both 5 and 4 have that frequency. Now
since the frequencies are same then
smallerelement comes first. So 4 4 comes
firstthen comes 5 5. Finally comes 6.
The output is 4 4 5 5 6.
tc: O(nlogn)
     */
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(5,5,4,6,4);
        HashMap<Integer, Integer> freqCount = new HashMap<>();
        HashMap<Integer, PriorityQueue<Integer>> freqElements = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            int ele = arr.get(i);

            if (freqCount.containsKey(ele))
                freqCount.put(ele, freqCount.get(ele) + 1);
            else
                freqCount.put(ele, 1);
        }

        for (int ele : freqCount.keySet()) {
            int freq = freqCount.get(ele);

            if (freqElements.containsKey(freq)) {
                PriorityQueue<Integer> queue = freqElements.get(freq);
                queue.add(ele);
                freqElements.put(freq, queue);
            } else {
                PriorityQueue<Integer> queue = new PriorityQueue<>();
                queue.add(ele);
                freqElements.put(freq, queue);
            }
        }

        List<Integer> frequencies = new ArrayList<>(freqCount.values());
        Collections.sort(frequencies, Collections.reverseOrder());

        for (int freq : frequencies) {
            PriorityQueue<Integer> queue = freqElements.get(freq);
            while (!queue.isEmpty()) {
                int num = queue.peek();
                int i = freq;
                while (i > 0) {
                    result.add(num);
                    i--;
                }
                queue.remove();
            }
        }

        System.out.println(result);
    }
}
