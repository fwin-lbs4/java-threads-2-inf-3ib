package quest.flo;

public class Main {
    public static void main(String[] args) {
//        exampleOne();
        exampleTwo();
    }

    public static void exampleTwo() {
        WaitThread waitThread = new WaitThread();
    }

    public static void exampleOne() {
        MySynchronized testClass = new MySynchronized();
        MySyncTest first = new MySyncTest(testClass);
        MySyncTest second = new MySyncTest(testClass);
        MySyncTest third = new MySyncTest(testClass);
        first.setName("first");
        second.setName("second");
        third.setName("third");
        first.start();
        second.start();
        try {
            first.join();
            second.join();
        } catch (InterruptedException ignore) {

        }
        third.start();
        testClass.doSomething(Thread.currentThread().getName());
    }
}