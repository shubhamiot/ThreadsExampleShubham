public class JoinExample {

    public void produce(){
        try{
            System.out.println("Lock acquired");
            Thread.sleep(10000);
            System.out.println("Lock released");
        }catch (InterruptedException e){
            System.out.println("exception: " + e);
        }
    }

    public static void main(String[] args) {
        JoinExample joinExample = new JoinExample();
        System.out.println("inside main method");
        Thread thread = new Thread(() -> {
            System.out.println("wating main method to complet");
            joinExample.produce();
        });
        thread.start();
        try{
            thread.join();
        }catch (InterruptedException e){
            System.out.println(e);
        }

        System.out.println("main method completed execution");
    }
}
