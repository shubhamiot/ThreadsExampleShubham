import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        Future<?> futureObj = scheduledExecutorService.scheduleAtFixedRate(()-> System.out.println("hello"), 3, 5, TimeUnit.MILLISECONDS);

        try{
            Thread.sleep(10000);
        }catch (InterruptedException exception){
            System.out.println(exception);
        }
        futureObj.cancel(true);
    }
}
