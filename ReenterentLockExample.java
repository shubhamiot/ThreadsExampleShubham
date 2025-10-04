import java.util.concurrent.locks.ReentrantLock;

public class ReenterentLockExample {

    boolean isAlive = false;
    void produce(ReentrantLock reenterentLock){
        try
        {
            reenterentLock.lock();
            isAlive = true;
            System.out.println("Thread acquired by: " + Thread.currentThread().getName());
            Thread.sleep(8000);
        }catch (InterruptedException e)
        {
            System.out.println("e");
        }finally {
            reenterentLock.unlock();
            System.out.println("Thread released by: " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock();
        ReenterentLockExample reenterentLockExample = new ReenterentLockExample();
        Thread t1 = new Thread(() -> {
            reenterentLockExample.produce(reentrantLock);
        });

        ReenterentLockExample reenterentLockExample1 = new ReenterentLockExample();
        Thread t2 = new Thread(() -> {
            reenterentLockExample1.produce(reentrantLock);
        });

        t1.start();
        t2.start();

    }
}
