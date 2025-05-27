class MessagePrinter implements Runnable{
    private String msg;
    private int times;
    public MessagePrinter(String msg, int times){
        this.msg = msg;
        this.times = times;
    }
    @Override
    public void run(){
        for (int i=1;i<=times;i++){
            System.out.println(Thread.currentThread().getName()+":"+msg+"("+i+")");
            try{
                Thread.sleep(500);  // Pause for 500 milliseconds for clearer output
            } catch (InterruptedException e){
                System.out.println("Thread interrupted");
            }
        }
    }
}
public class threadcreation{
    public static void main(String[] args){
        Thread thread1=new Thread(new MessagePrinter("Thread 1", 5), "Thread-1");
        Thread thread2=new Thread(new MessagePrinter("Thread 2", 5), "Thread-2");
        thread1.start();
        thread2.start();
    }
}
