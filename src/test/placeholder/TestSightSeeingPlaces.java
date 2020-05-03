package placeholder;

import model.SightSeeingPlaces;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSightSeeingPlaces {
    SightSeeingPlaces sightSeeingPlaces = new SightSeeingPlaces("name",1,1, 2000);

    @Test
    public void testSightSeeingComplete() {
        assertEquals("Places has been visited!", sightSeeingPlaces.complete());
    }
}
