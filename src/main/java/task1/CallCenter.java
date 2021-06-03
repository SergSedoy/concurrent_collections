package task1;

public class CallCenter extends Thread {
    int count = 1;
    final long interval = 17; // 58 звонков в секунду

    public CallCenter(String name) {
        super(name);
    }

    @Override
    public void run() {
        while(!Main.night) {
            Main.queue.add("звонок № " + count);
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
