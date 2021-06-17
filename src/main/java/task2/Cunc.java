package task2;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cunc extends Thread {
    private ConcurrentHashMap<Integer, String> mapaConcurrent;
    private Map<Object, Object> mapaSync;

    public Cunc(ConcurrentHashMap<Integer, String> mapaConcurrent) {
        this.mapaConcurrent = mapaConcurrent;
    }

    public Cunc(Map<Object, Object> mapaSync) {
        this.mapaSync = mapaSync;
    }

    @Override
    public void run() {
        Date start = new Date();
        String name = null;
        if (mapaConcurrent != null) {
            for (int i = 0; i < Main.COUNT_ITER; i++)
                mapaConcurrent.put((int) (Math.random() * 100000), Thread.currentThread().getName());
//            mapaConcurrent.forEach((a, b) -> System.out.println("key " + a + ", value " + b));
            name = "ConcurrentHashMap";
        }

        if (mapaSync != null) {
            for (int i = 0; i < Main.COUNT_ITER; i++)
                mapaSync.put((int) (Math.random() * 100000), Thread.currentThread().getName());
//            mapaSync.forEach((a, b) -> System.out.println("key " + a + ", value " + b));
            name = "Collections.synchronizedMap";
        }
        Date finish = new Date();

        long d = (finish.getTime() - start.getTime());

        System.out.println("время записи и чтения " + name + " = " + (d / 1000));

    }
}
