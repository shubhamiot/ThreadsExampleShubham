public class ConcurrecyIssue {

    int count = 0;
     void counter(){
        count++;
    }

    void get(){
        System.out.println(count);
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrecyIssue concurrecyIssue = new ConcurrecyIssue();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                concurrecyIssue.counter();
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i=0; i<200; i++){
                concurrecyIssue.counter();
            }

        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        concurrecyIssue.get();
    }
}
