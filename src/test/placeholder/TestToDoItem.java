package placeholder;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestToDoItem {
    private SightSeeingPlaces sightSeeing1;
    private SightSeeingPlaces sightSeeing2;
    private PlacesToEat placesToEat1;
    private PlacesToEat placesToEat2;
    private Activities activity1;
    private Activities activity2;
    private ToDoItem sightSeeingPlace;
    private ItemDetail itemDetail;
    private ItemDetail testItemDetail;
    private ToDoItem testSightSeeingPlace;



    @BeforeEach
    public void setup() {
        sightSeeing1 = new SightSeeingPlaces("name1",20,1,2019 );
        sightSeeing2 = new SightSeeingPlaces("name2",8,10,2019);
        placesToEat1 = new PlacesToEat("name3", 20,1,2019);
        placesToEat2 = new PlacesToEat("name4",8,10, 2019);
        activity1 = new Activities("name5",20,1,2019);
        activity2 = new Activities("name6",8,10,2019);
        sightSeeingPlace = new SightSeeingPlaces("Eiffel Tower", 1, 1, 2019);
        itemDetail = new ItemDetail("test description");
    }

    @Test
    public void testGetDate() {
        assertEquals("1/20/2019", sightSeeing1.getDate());
        assertEquals("10/8/2019", sightSeeing2.getDate());
        assertEquals("1/20/2019", placesToEat1.getDate());
        assertEquals("10/8/2019", placesToEat2.getDate());
        assertEquals("1/20/2019", activity1.getDate());
        assertEquals("10/8/2019", activity2.getDate());
    }

    @Test
    public void testGetToDoItemName() {
        assertSame("name1", sightSeeing1.getToDoItemName());
        assertSame("name2",sightSeeing2.getToDoItemName());
        assertSame("name3", placesToEat1.getToDoItemName());
        assertSame("name4", placesToEat2.getToDoItemName());
        assertSame("name5", activity1.getToDoItemName());
        assertSame("name6", activity2.getToDoItemName());
    }

    @Test
    public void testSetAppropriateItemDetail() {
        sightSeeingPlace.setItemDetail(itemDetail);
        itemDetail.setAppropriateToDoItem(sightSeeingPlace);
        assertTrue(sightSeeingPlace.getAppropriateItemDetail().equals(itemDetail));
    }

    @Test
    public void testRemoveToDoItem() {
        sightSeeingPlace.setItemDetail(itemDetail);
        sightSeeingPlace.removeToDoItem();
        testItemDetail = new ItemDetail("");
        testSightSeeingPlace = new SightSeeingPlaces("",0,0,0);
        assertTrue(sightSeeingPlace.getToDoItemName().equals(testSightSeeingPlace.getToDoItemName()));
    }

    @Test
    public void testDisplay() {
        assertEquals(sightSeeing1, sightSeeing1);
    }
}
