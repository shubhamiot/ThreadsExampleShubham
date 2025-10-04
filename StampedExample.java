import java.util.concurrent.locks.StampedLock;

public class StampedExample {

    int a = 10;
    StampedLock lock =  new StampedLock();
    public void produce(){

        System.out.println("Lock acquired my read lock: " + Thread.currentThread().getName());
        try {
            long stamp  = lock.tryOptimisticRead();
            a = 11;
            Thread.sleep(6000);
            if(lock.validate(stamp)){
                System.out.println("Stamp validated");
            }else {
                System.out.println("stam rol back");
                a = 10;
            }
        }catch (InterruptedException exception){
            System.out.println(exception);
        }
    }

    public void consume(){
        long stamp = lock.writeLock();
        try {
            System.out.println("write lock acquired by: " + Thread.currentThread().getName());
            a=10;
        }finally {
            lock.unlockWrite(stamp);
        }
    }

    public static void main(String[] args) {
        StampedExample stampedExample = new StampedExample();
        Thread t1 = new Thread(() -> {
            stampedExample.produce();
        });
        Thread t2 = new Thread(() -> {
            stampedExample.consume();
        });
        t1.start();
        t2.start();
    }
}
