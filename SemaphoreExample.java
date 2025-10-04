import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    Semaphore lock = new Semaphore(2);
    public void produce(){
        try{
            lock.acquire();
            System.out.println("Thread acquired: " + Thread.currentThread().getName());
        }catch (InterruptedException exception)
        {
            System.out.println(exception);
        }finally {
            System.out.println("Thread released: " + Thread.currentThread().getName());
            lock.release();
        }
    }

    public static void main(String[] args) {
        SemaphoreExample semaphore = new SemaphoreExample();
        Thread t1 = new Thread(() -> {
            semaphore.produce();
        });
        Thread t2 = new Thread(() -> {
            semaphore.produce();
        });
        Thread t3 = new Thread(() -> {
            semaphore.produce();
        });
        Thread t4 = new Thread(() -> {
            semaphore.produce();
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
