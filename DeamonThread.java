public class DeamonThread {

    public void task(){
        try{
            System.out.println("lock acquired");
            Thread.sleep(8000);
            System.out.println("Lock released");
        }catch (InterruptedException exception){
            System.out.println(exception.getStackTrace());
        }
    }

    public static void main(String[] args) {
        DeamonThread deamonThread = new DeamonThread();
        Thread thread = new Thread(() -> {
            System.out.println("main thread is wating to complete");
            deamonThread.task();
        });
        thread.setDaemon(true);
        thread.start();
        System.out.println("main thread completed execution");
    }
}
