package lesson4.github;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskExecutor {
    private final ExecutorService executor;

    public TaskExecutor() {
        executor = Executors.newFixedThreadPool(5);
    }

    public void executeRunnable(Runnable task) {
        // Executes the given task asynchronously
        executor.execute(task);
    }

    public <T> Future<T> submitCallable(Callable<T> task) {
        // Submits the given callable task for execution and
        // returns a Future representing the pending result of the task
        return executor.submit(task);
    }

    public void shutdown() {
        // Initiates an orderly shutdown of the executor service
        executor.shutdown();
    }

    public static void main(String[] args) {
        TaskExecutor taskExecutor = new TaskExecutor();
        // Executing Runnable tasks
        taskExecutor.executeRunnable(() -> {
            System.out.println("Executing Runnable Task 1");
        });
        taskExecutor.executeRunnable(() -> {
            System.out.println("Executing Runnable Task 2");
            // Task logic...
        });

        // Submitting Callable tasks
        Future<Integer> future1 = taskExecutor.submitCallable(() -> {
            System.out.println("Executing Callable Task 1");
            // Task logic...
            return 1; // Return result
        });

        Future<Integer> future2 = taskExecutor.submitCallable(() -> {
            System.out.println("Executing Callable Task 2");
            //Task logic...
            return 2; // Return result
        });

        // Example of retrieving results from Callable tasks
        try {
            System.out.println("Result of Callable Task 1: "+future1.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
