package quest.flo;

public class MySyncTest extends Thread {
    MySynchronized testClass;
    public MySyncTest(MySynchronized testClass) {
        this.testClass = testClass;
    }
    @Override
    public void run() {
        while (true) {
            testClass.doSomething(this.getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
