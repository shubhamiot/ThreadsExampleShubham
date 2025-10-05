import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerEx {


    AtomicInteger a = new AtomicInteger(0);
    void counter(){
        a.incrementAndGet();
    }

    void get(){
        a.get();
    }

    public static void main(String[] args) {
        AtomicIntegerEx atomicIntegerEx = new AtomicIntegerEx();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                atomicIntegerEx.counter();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                atomicIntegerEx.counter();
            }
        });
        t1.start();
        t2.start();
        atomicIntegerEx.get();
        try{
            t1.join();
            t2.join();
        }catch (InterruptedException exception){
            System.out.println(exception);
        }
    }
}
