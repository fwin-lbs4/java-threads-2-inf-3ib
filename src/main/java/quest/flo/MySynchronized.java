package quest.flo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MySynchronized {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:mm");
    Date date;
    int number = 0;

    public synchronized void doSomething(String name) {
        date = new Date();
        System.out.println(name + " Wert von Number: " + this.number + ": Start Method doSomething " + formatter.format(
                date));
        try {
            Thread.sleep(3000);
            this.number++;
        } catch (InterruptedException ignored) {

        }
        date = new Date();
        System.out.println(name + " Wert von Number: " + this.number + ": Ende Method doSomething " + formatter.format(
                date));
    }
}
