import java.util.ArrayList;
import java.util.List;

public class MaxChunksToSorted {
    static int findMaxChunks(List<Integer> arr) {
        int maxValue = -1, partitions = 0;

        for (int i = 0; i < arr.size(); i++) {
            maxValue = Math.max(maxValue, arr.get(i));
            if (maxValue == i) partitions++;
        }

        return partitions;
    }

    public static void main(String[] args){
      System.out.println(findMaxChunks(new ArrayList<>(List.of(2,0,1,3))));
    }
}
