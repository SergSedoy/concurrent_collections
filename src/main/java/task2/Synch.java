package task2;

import java.util.Date;
import java.util.Map;

public class Synch extends Thread {
    private Map<Object, Object> mapaSync;

    public Synch(Map<Object, Object> mapaSync) {
        this.mapaSync = mapaSync;
    }

    @Override
    public void run() {
        Date start = new Date();

        for (int i = 0; i < Main.COUNT_ITER; i++)
            mapaSync.put((int) (Math.random() * 100000), Thread.currentThread().getName());

//        mapaSync.forEach((a, b) -> System.out.println("key " + a + ", value " + b));

        Date finish = new Date();

        long d = (finish.getTime() - start.getTime());

        System.out.println("время записи и чтения Collections.synchronizedMap = " + (d / 1000));
    }
}
