package task1;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter extends Thread {
    int count = 1;
    long interval = 17; // 58 звонков в секунду
    private ConcurrentLinkedQueue<String> queue;

    public CallCenter(String name, ConcurrentLinkedQueue<String> queue) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        while(!Main.night) {
            queue.add("звонок № " + count);
            count++;
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
