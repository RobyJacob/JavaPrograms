import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int first;
    boolean second;

    Pair(int first, boolean second) {
        this.first = first;
        this.second = second;
    }

    @java.lang.Override
    public String toString() {
        return "[" + first + "," + second + "]";
    }
}

public class MaxJumpsToReachHome {
    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        Queue<Pair> queue = new LinkedList<>();
        HashSet<Integer> invalid = new HashSet<>();
        HashSet<String> seen = new HashSet<>();
        int ans = 0, nextPos = 0;

        for (int n : forbidden)
            invalid.add(n);

        Pair curState = new Pair(0, false);
        queue.add(curState);
        seen.add(curState.first + "" + curState.second);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                curState = queue.remove();
                int cur = curState.first;
                boolean isBackward = curState.second;
//                System.out.println("curState=" + curState + " ans=" + ans);

                if (cur == x)
                    return ans;

                nextPos = cur + a;
                Pair nextState = new Pair(nextPos, false);
//                System.out.println("nextStateForward=" + nextState);
                if (!invalid.contains(nextPos) && nextPos <= 10000 &&
                        !seen.contains(nextState.first + "" + nextState.second)) {
                    queue.add(nextState);
                    seen.add(nextState.first + "" + nextState.second);
                }

                nextPos = cur - b;
                nextState = new Pair(nextPos, true);
//                System.out.println("nextStateBackward=" + nextState);
                if (!isBackward) {
                    if (!invalid.contains(nextPos) && nextPos >= 0 &&
                            !seen.contains(nextState.first + "" + nextState.second)) {
                        queue.add(nextState);
                        seen.add(nextState.first + "" + nextState.second);
                    }
                }
            }

            ans++;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minimumJumps(new int[]{1998}, 1999, 2000, 2000));
    }
}
