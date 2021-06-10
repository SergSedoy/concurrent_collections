package task2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static final int COUNT_ITER = 9200000;

    public static void main(String[] args) {

        ConcurrentHashMap<Integer, String> mapaConcurrent = new ConcurrentHashMap<>();
        new Cunc(mapaConcurrent).start();
        new Cunc(mapaConcurrent).start();
        new Cunc(mapaConcurrent).start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("далее тест \"Collections.synchronizedMap\"");

         Map<Object, Object> mapaSync = Collections.synchronizedMap(new HashMap<>());
         new Synch(mapaSync).start();
         new Synch(mapaSync).start();
         new Synch(mapaSync).start();
    }
}
