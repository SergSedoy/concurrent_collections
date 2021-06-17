package task1;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static boolean night = false;
    final static long LENGTH_DAY = 4000;
    final static long COFFEE_BREAK = 500;
    final static long INTERVAL = 17; // 58 звонков в секунду


    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        new CallCenter("ATC", queue).start();

        try {
            Thread.sleep(COFFEE_BREAK);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("в очереди " + queue.size() + " звонков");
        new Specialist("первый", queue).start();
        new Specialist("второй", queue).start();
        new Specialist("третий", queue).start();
        new Specialist("четвертый", queue).start();
        new Specialist("пятый", queue).start();
        new Specialist("шестой", queue).start();

        try {
            Thread.sleep(LENGTH_DAY);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        night = true;
        System.out.println("звонки закончились, в очереди " + queue.size() + " звонков");
    }
}

// в задаче 1 выбрана потокобезопасная очередь ConcurrentLinkedQueue, потому что работает не на массиве, соответственно - быстро, также отсутствует блокировка потоков.