import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Andrew_Elena on 13.07.2016.
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
