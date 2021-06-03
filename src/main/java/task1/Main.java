package task1;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static boolean night = false;
    public static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
    final static long lengthDay = 4000;
    final static long coffeeBreak = 500;

    public static void main(String[] args) throws InterruptedException {

        new CallCenter("ATC").start();

        try {
            Thread.sleep(coffeeBreak);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("в очереди " + queue.size() + " звонков");
        new Specialist("первый").start();
        new Specialist("второй").start();
        new Specialist("третий").start();
        new Specialist("четвертый").start();
        new Specialist("пятый").start();
        new Specialist("шестой").start();

        try {
            Thread.sleep(lengthDay);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        night = true;
        System.out.println("звонки закончились, в очереди " + queue.size() + " звонков");
    }
}
