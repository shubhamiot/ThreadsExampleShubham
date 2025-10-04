import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    public ProducerConsumer(int bufferSize){
        sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item) throws InterruptedException {

        while (sharedBuffer.size() == bufferSize){
            System.out.println("Buffer is full, Producer is waiting for consumer");
            wait();
        }

        sharedBuffer.add(item);
        notify();
    }

    public synchronized int consume() throws InterruptedException{
        while (sharedBuffer.isEmpty()){
            System.out.println("Buffer is empty, Consumer is waitng for producer");
            wait();
        }
        Integer item = sharedBuffer.poll();
        notify();
        return item;
    }



    public static void main(String[] args) {

        ProducerConsumer producerConsumer = new ProducerConsumer(3);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    producerConsumer.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                int consume = 0;
                try {
                    consume = producerConsumer.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Item" + consume);
            }
        });

        t1.start();
        t2.start();

    }
}
