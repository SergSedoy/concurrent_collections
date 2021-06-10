package task1;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Specialist extends Thread {
    private long workOnBell = 3000;
    private ConcurrentLinkedQueue<String> queue;

    public Specialist(String name, ConcurrentLinkedQueue<String> queue) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {

        while (!queue.isEmpty()) {

            try {
                System.out.println(Thread.currentThread().getName() + " взял в работу " + queue.remove());
                Thread.sleep(workOnBell);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("в очереди " + queue.size() + " звонков");
        }
        System.out.println("оператор " + Thread.currentThread().getName() + " завершил работу");
    }
}
