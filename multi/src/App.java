public class App {
    public static void main(String[] args) throws Exception {
        Queue qob = new Queue();
        Producer pob = new Producer(qob);
        Consumer cob = new Consumer(qob);
        pob.t.start();
        cob.t.start();

        pob.t.join();
        cob.t.join();

        System.out.println("main thread terminating.....");

    }
}
