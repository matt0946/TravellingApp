package placeholder;

import model.PlacesToEat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPlacesToEat {

    PlacesToEat placesToEat = new PlacesToEat("name",1,1,2019);

    @Test
    public void testPlaceToEatComplete() {
        assertEquals("Eaten here!" ,placesToEat.complete());
    }
}
