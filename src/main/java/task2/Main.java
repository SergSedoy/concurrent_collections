package task2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final int COUNT_ITER = 92000000;

    public static void main(String[] args) {

        ConcurrentHashMap<Integer, String> mapaConcurrent = new ConcurrentHashMap<>();
        Map<Object, Object> mapaSync = Collections.synchronizedMap(new HashMap<>());

        Runnable task1 = new Cunc(mapaConcurrent);
        Runnable task2 = new Cunc(mapaSync);
        ExecutorService service = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 3; i++) {
            service.submit(task1);
            service.submit(task2);
        }
        System.out.println("Идет тестирование на время...");
        service.shutdown();
    }
}
