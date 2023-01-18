public class StrangeEquality {
    static int strangeEquality(int num) {
        int bitCount = (int) (Math.floor(Math.log(num) / Math.log(2)) + 1);

        int x = num ^ ((1 << bitCount) - 1);
        int y = 1 << bitCount;

        return x ^ y;
    }
    public static void main(String[] args){
      int res = strangeEquality(5);

      System.out.println(res);
    }
}
