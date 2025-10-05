import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ShutDoneExample {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 20, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2));
        threadPoolExecutor.submit(()-> {
            System.out.println("Submitted task");
            try {
                Thread.sleep(5000);
                System.out.println("Task completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadPoolExecutor.shutdown();
        boolean b = threadPoolExecutor.awaitTermination(7000, TimeUnit.MILLISECONDS);
        System.out.println("termination result: "+ b);
        System.out.println("Completed main thread");

    }
}
