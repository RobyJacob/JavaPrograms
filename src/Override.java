import java.io.IOException;

public class Override {

    static class A
    {
        void m1() throws Exception
        {
            System.out.println("In m1 A");
        }
    }
    static class B extends A
    {
        void m1() throws IOException
        {
            System.out.println("In m1 B");
        }
        void m2()
        {
            System.out.println("In m2 B");
        }
    }

    public static void main(String[] args) {
        A a= new B();
        try {
            a.m1();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}