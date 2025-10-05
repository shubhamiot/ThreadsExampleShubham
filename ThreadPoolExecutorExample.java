import com.RejectExecutionHandlerExample;
import com.ThreadFactorExample;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {

    public static void main(String[] args) {
        ThreadPoolExecutor th = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2), new ThreadFactorExample(), new RejectExecutionHandlerExample());

        for(int i=0; i<4; i++){
          th.submit(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task processed by: " + Thread.currentThread().getName());
            });

            th.shutdown();
        }
    }
}
