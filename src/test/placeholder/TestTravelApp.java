package placeholder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.TravelApp;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestTravelApp {
    TravelApp travelApp;

    @BeforeEach
    public void setUp() {
        this.travelApp = new TravelApp();
    }

    @Test
    public void testSave() throws IOException {
        travelApp.getPlacesToEat().insert("McDonald's");
        travelApp.getPlacesToEat().insert("Burger King");
        travelApp.getPlacesToEat().insert("KFC");
        travelApp.save();
        TravelApp newTravelApp = new TravelApp();
        newTravelApp.load();
        assertTrue(newTravelApp.getPlacesToEat().contains("McDonald's"));
        assertTrue(newTravelApp.getPlacesToEat().contains("Burger King"));
        assertTrue(newTravelApp.getPlacesToEat().contains("KFC"));
    }

    @Test
    public void testLoad() throws IOException {
        travelApp.getPlacesToEat().insert("McDonald's");
        travelApp.getPlacesToEat().insert("Burger King");
        travelApp.getPlacesToEat().insert("KFC");
        travelApp.save();
        TravelApp newTravelApp = new TravelApp();
        newTravelApp.load();
        assertTrue(newTravelApp.getPlacesToEat().contains("McDonald's"));
        assertTrue(newTravelApp.getPlacesToEat().contains("Burger King"));
        assertTrue(newTravelApp.getPlacesToEat().contains("KFC"));
    }
}