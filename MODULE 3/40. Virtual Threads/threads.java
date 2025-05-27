public class threads{
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> System.out.println("Hello from " + Thread.currentThread());
        Thread vThread1 = Thread.startVirtualThread(task);
        Thread vThread2 = Thread.startVirtualThread(task);
        vThread1.join();
        vThread2.join();
        System.out.println("All virtual threads finished.");
    }
}