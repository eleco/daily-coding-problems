package problem105;

import java.util.concurrent.*;

import static java.util.concurrent.Executors.newSingleThreadScheduledExecutor;

public class Main {

    //Given a function f, and N return a debounced f of N milliseconds.
    //That is, as long as the debounced f continues to be invoked, f itself will not be called for N milliseconds.

    public static void main(String args[]) throws Exception {

        Debounce d = new Debounce(5);
        for (int i=0;i<100;i++) {
            d.debounce(() -> System.out.print("x"));
            Thread.sleep(1000);
        }
    }
}

class Debounce {

    private final ScheduledExecutorService executorService = newSingleThreadScheduledExecutor();
    private final int wait;
    private boolean debouncing;

    Debounce(int wait) {
        this.wait = wait;
    }

   void debounce (Runnable r) {
        System.out.print(".");
        if (!debouncing) {
            r.run();
            debouncing = true;
            executorService.schedule(()->{debouncing=false;},wait, TimeUnit.SECONDS);
        }
    }

}
