public class Consumer implements Runnable {
    Thread t;
    Queue q;

    Consumer(Queue q) {
        this.q = q;
        t = new Thread(this, "Consumer");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            q.get();
        }
    }

}
