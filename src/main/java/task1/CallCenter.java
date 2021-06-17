package task1;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter extends Thread {
    int count = 1;
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
                Thread.sleep(Main.INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
