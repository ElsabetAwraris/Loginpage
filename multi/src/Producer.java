
public class Producer implements Runnable {
    Thread t;
    Queue q;

    Producer(Queue q) {
        this.q = q;
        t = new Thread(this, "Producer");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            q.put(i);
        }
    }

}
