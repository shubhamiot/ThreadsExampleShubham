public class MonitorExample {

    public synchronized void task1(){
        System.out.println("1");
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            System.out.println(e.getStackTrace());
        }
    }

    public void task2(){
        System.out.println("2");
        synchronized (this){
            System.out.println("3");
        }
    }

    public void task3(){
        System.out.println("4");
    }
    public static void main(String[] args) {

        MonitorExample monitorExample = new MonitorExample();
        Thread thread = new Thread(() -> monitorExample.task1());
        Thread thread1 = new Thread(() -> monitorExample.task2());
        Thread thread2 = new Thread(() -> monitorExample.task3());
        thread.start();
        thread1.start();
        thread2.start();

    }
}
