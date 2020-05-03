package placeholder;

import model.Activities;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestActivities {
    Activities activities = new Activities("name",1,1,2019);

    @Test
    public void testActivityComplete() {
        assertEquals("Activity has been completed!" , activities.complete());
    }
}
