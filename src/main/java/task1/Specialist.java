package task1;

public class Specialist extends Thread {
    final long workOnBell = 3000;

    public Specialist(String name) {
        super(name);
    }

    @Override
    public void run() {

        while (!Main.queue.isEmpty()) {
            Main.queue.remove();
            try {
                Thread.sleep(workOnBell);
                System.out.println(Thread.currentThread().getName() + " взял в работу звонок");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("в очереди " + Main.queue.size() + " звонков");
        }
        System.out.println("оператор " + Thread.currentThread().getName() + " завершил работу");
    }
}
