import java.util.concurrent.*;
import java.util.*;
public class executor{
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Callable<String>> tasks = List.of(
            () -> "Task 1 done",
            () -> "Task 2 done",
            () -> "Task 3 done"
        );
        List<Future<String>> futures = executor.invokeAll(tasks);
        for (Future<String> f : futures) {
            System.out.println(f.get());
        }
        executor.shutdown();
    }
}