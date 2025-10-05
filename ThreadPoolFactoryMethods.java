import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolFactoryMethods {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService fxThreadP = Executors.newFixedThreadPool(2);
        Future<Integer> future = fxThreadP.submit(() -> {
            int i = 2;
            System.out.println(i);
            return i;
        });
        System.out.println(future.get());


        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        Future<?> submit = newCachedThreadPool.submit(() -> System.out.println("new Catch Thread pool"));
        System.out.println(submit.get());

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> submit1 = executorService.submit(() -> System.out.println("new single thread executor"));
        System.out.println(submit1);
    }
}
