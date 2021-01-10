package mt;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableThreadDemo {

    public static Integer compute() {
        System.out.println(Thread.currentThread().getName());
        return 2;
    }

    public static CompletableFuture<Integer> create(ExecutorService service) {
        return CompletableFuture.supplyAsync(() -> compute(),service);
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println(Thread.currentThread().getName());

        create(service)
        //CompletableFuture.supplyAsync(() -> compute(),service)
                .exceptionally(throwable -> handle(throwable))
                .thenApply(data -> data*2)
                .thenAccept(data -> System.out.println(data));

    }

    private static Integer handle(Throwable throwable) {
        System.out.println(throwable);
        throw new RuntimeException("Went wrong");
    }
}

/*

main
pool-1-thread-1
4

 */
