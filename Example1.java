public class Example1 implements Runnable{


    @Override
    public void run() {
        System.out.println("Thread-"+ Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        Example1 example1 = new Example1();
        Thread thread = new Thread(example1);
        thread.start();
        System.out.println("Thread-" + Thread.currentThread().getName());
    }
}
