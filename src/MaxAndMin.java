import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class MaxAndMin {
    static int[] nextSmallestLeft(ArrayList<Integer> arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.size();
        int[] nextSmallest = new int[n + 1];
        int[] tmpArr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            tmpArr[i + 1] = arr.get(i);
        }

        for (int i = n; i >= 1; i--) {
            while (!st.isEmpty() && tmpArr[st.peek()] > tmpArr[i]) {
                nextSmallest[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }

        return nextSmallest;
    }

    static int[] nextSmallestRight(ArrayList<Integer> arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.size();
        int[] nextSmallest = new int[n + 1];
        int[] tmpArr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            tmpArr[i + 1] = arr.get(i);
            nextSmallest[i + 1] = n + 1;
        }

        for (int i = 1; i < tmpArr.length; i++) {
            while (!st.isEmpty() && tmpArr[st.peek()] >= tmpArr[i]) {
                nextSmallest[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }

        return nextSmallest;
    }

    static int[] nextGreatestLeft(ArrayList<Integer> arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.size();
        int[] nextGreatest = new int[n + 1];
        int[] tmpArr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            tmpArr[i + 1] = arr.get(i);
        }

        for (int i = n; i >= 1; i--) {
            while (!st.isEmpty() && tmpArr[st.peek()] < tmpArr[i]) {
                nextGreatest[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }

        return nextGreatest;
    }

    static int[] nextGreatestRight(ArrayList<Integer> arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.size();
        int[] nextGreatest = new int[n + 1];
        int[] tmpArr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            tmpArr[i + 1] = arr.get(i);
            nextGreatest[i + 1] = n + 1;
        }

        for (int i = 1; i < tmpArr.length; i++) {
            while (!st.isEmpty() && tmpArr[st.peek()] <= tmpArr[i]) {
                nextGreatest[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }

        return nextGreatest;
    }

    static int solve(ArrayList<Integer> A) {
        int[] smallestLeft = nextSmallestLeft(A);
        int[] smallestRight = nextSmallestRight(A);
        int[] greatestLeft = nextGreatestLeft(A);
        int[] greatestRight = nextGreatestRight(A);
        final int MOD = 1000000007;
        long res = 0;
        int[] tmpArr = new int[A.size() + 1];

        for (int i = 0; i < A.size(); i++) tmpArr[i + 1] = A.get(i);

        for (int i = 1; i < tmpArr.length; i++) {
            long countMinSubarrs = ((long) (smallestRight[i] - i) * (i - smallestLeft[i])) % MOD;
            long countMaxSubarrs = ((long) (greatestRight[i] - i) * (i - greatestLeft[i])) % MOD;

            res += (tmpArr[i] * countMaxSubarrs) % MOD;
            res %= MOD;
            System.out.println(tmpArr[i] + " " + res + " " +
                    greatestLeft[i] + " " + greatestRight[i] + " " + countMaxSubarrs);
            res -= (tmpArr[i] * countMinSubarrs) % MOD;
            res += MOD;
            res %= MOD;
            System.out.println(tmpArr[i] + " " + res + " " + smallestLeft[i] + " " + smallestRight[i] + " " +
                    countMinSubarrs);
        }

        return (int) res;
    }

    public static void main(String[] args) {
//        int res = solve(new ArrayList<>(Arrays.asList(992387, 932142, 971117, 934674, 988917, 967890, 948508, 970347)));
//        int res = solve(new ArrayList<>(Arrays.asList(4, 7, 3, 8)));
        int res = solve(new ArrayList<>(Arrays.asList(994390,986616,976849,979707,950477,968402,992171,937674,
                933065,960863,980981,937319,951236,959547,991052,991799,992213,941294,978103,997198,960759,988476,
                963517,980366,921767,979757,977912,983761,981869,947454,930202,999086,973538,999798,996446,944001,
                974217,951595,942688,975075,970973,970130,897109,927660,862233,997130,986068,954098,978175,889682,
                988973,996036,969675,985751,977724,881538,988613,924230,906475,915565,986952,975702,994316,964011,
                986848,983699,949076,989673,981788,929094,988310,926471,994763,999736,980762,973560,996622,934475,
                998365,966255,998697,998700,911868,983245,996382,996992,953142,994104,987303,853837,960626,904203,
                998063,977596,977868,996012,946345,949255,988138,996298,954933,965036,886976,998628,990878,953725,
                916744,985233,919661,970903,986066)));

        System.out.println(res);
    }
}
