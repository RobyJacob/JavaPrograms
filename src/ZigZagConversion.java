import java.util.ArrayList;

public class ZigZagConversion {
    static String zigZagConvert(String str, int numRows) {
        if (numRows == 1) return str;

        ArrayList<StringBuilder> arr = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) arr.add(new StringBuilder());

        int arrPointer = -1, strPointer = 0, step = 1;

        while (strPointer < str.length()) {
            if (arrPointer == numRows - 1) step = -1;
            else if (arrPointer == 0) step = 1;

            arrPointer += step;

            arr.set(arrPointer, arr.get(arrPointer).append(str.charAt(strPointer)));

            strPointer++;
        }

        StringBuilder res = new StringBuilder();

        for (StringBuilder sb : arr) {
            res.append(sb.toString());
        }

        return res.toString();
    }

    public static void main(String[] args){
      String res = zigZagConvert("abcde", 2);

      System.out.println(res);
    }
}
