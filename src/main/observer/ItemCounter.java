package observer;

import java.util.Observable;
import java.util.Observer;

public class ItemCounter implements Observer {
    @Override
    // MODIFIES: prints a message to console stating the number of new items added
    public void update(Observable o, Object arg) {
        System.out.println("New Items Added: " + arg);
    }
}
