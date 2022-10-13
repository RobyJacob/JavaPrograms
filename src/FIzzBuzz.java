public class FIzzBuzz {
    /*
    Given number N
    print "fizz" for numbers divisible by 3, print "buzz" for numbers divisible by 5,
    print "fizzbuzz" for numbers divisible by 3 and 5 else the number itself for all
    numbers in the range [1,N]
    Eg:-
        Input = 5
        Output = 1 2 fizz 4 buzz
     */

    static void fizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                System.out.println("FizzBuzz");
            else if (i % 3 == 0)
                System.out.println("Fizz");
            else if (i % 5 == 0)
                System.out.println("Buzz");
            else
                System.out.println(i);
        }
    }

    public static void main(String[] args) {
        fizzBuzz();
    }
}
