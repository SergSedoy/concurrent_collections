package task2;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class Cunc extends Thread {
    private ConcurrentHashMap<Integer, String> mapaConcurrent;

    public Cunc(ConcurrentHashMap<Integer, String> mapaConcurrent) {
        this.mapaConcurrent = mapaConcurrent;
    }

    @Override
    public void run() {
        Date start = new Date();

        for (int i = 0; i < Main.COUNT_ITER; i++)
            mapaConcurrent.put((int) (Math.random() * 100000), Thread.currentThread().getName());

//        mapaConcurrent.forEach((a, b) -> System.out.println("key " + a + ", value " + b));

        Date finish = new Date();

        long d = (finish.getTime() - start.getTime());

        System.out.println("время записи и чтения ConcurrentHashMap = " + (d / 1000));
    }
}
