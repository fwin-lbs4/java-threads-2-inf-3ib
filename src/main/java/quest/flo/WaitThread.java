package quest.flo;

import java.io.IOException;

public class WaitThread {
    private final Object lock = new Object();
    private boolean wait = true;

    public WaitThread() {
        new Waiter().start();
        new Notifier().start();
    }

    public class Notifier extends Thread {
        public void run() {
            System.out.println("Notifier: Weiter mit RETURN");
            try {
                System.in.read();
            } catch (IOException ignore) {
            }
            synchronized (lock) {
                wait = false;
                lock.notify();
            }
        }
    }

    class Waiter extends Thread {
        public void run() {
            synchronized (lock) {
                while (wait) {
                    System.out.println("Waiter: wait = " + wait);
                    System.out.println("Waiter wartet");
                    try {
                        lock.wait();
                        System.out.println("Waiter: wait = " + wait + "\n Programm kann weiterlaufen");
                        System.out.println("Notifier hat Objekt entsperrt");
                    } catch (InterruptedException ignored) {
                    }
                }
            }
        }
    }
}
