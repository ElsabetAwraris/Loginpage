public class Queue {
    private int n;
    private boolean valueset = false;

    public synchronized int get() {
        while (!valueset) {
            try {
                wait();

            } catch (InterruptedException ex) {
                System.out.println("interrurted");
            }

        }
        valueset = false;
        System.out.println("Got:" + n);
        notify();
        return n;
    }

    public synchronized void put(int n) {
        while (valueset) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.n = n;
        valueset = true;
        System.out.println("put:" + n);
        notify();

    }
}