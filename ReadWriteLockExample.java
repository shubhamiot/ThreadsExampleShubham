import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    void produce(ReadWriteLock readWriteLock){

        try{
            readWriteLock.readLock().lock();
            System.out.println("Acquired shared lock: " + Thread.currentThread().getName());
            Thread.sleep(8000);
        }catch (InterruptedException exception){
            System.out.println();
        }finally {
            readWriteLock.readLock().unlock();
        }

    }

    public void consume(ReadWriteLock readWriteLock){
        try{
            readWriteLock.writeLock().lock();
            System.out.println("Local acquired by exclusive lock: " + Thread.currentThread().getName());
            Thread.sleep(8000);
        }catch (InterruptedException exception){
            System.out.println(exception);
        }
        finally {
            readWriteLock.writeLock().unlock();
        }
    }
    public static void main(String[] args) {

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReadWriteLockExample readWriteLockExample = new ReadWriteLockExample();
        Thread t1 = new Thread(() -> {
            readWriteLockExample.produce(readWriteLock);
        });
        Thread t2 = new Thread(() -> {
            readWriteLockExample.produce(readWriteLock);
        });

        ReadWriteLockExample readWriteLockExample1 = new ReadWriteLockExample();
        Thread t3 = new Thread(() -> {
            readWriteLockExample1.consume(readWriteLock);
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
