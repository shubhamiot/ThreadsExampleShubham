import java.util.function.Predicate;

public class Example2 extends Thread{

    @Override
    public void run(){
        System.out.println("Thread-"+ Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Example2 example2 = new Example2();
        example2.start();
    }
}
