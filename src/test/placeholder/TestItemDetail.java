package placeholder;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestItemDetail {
    private ToDoItem sightSeeingPlace;
    private ItemDetail itemDetail;
    private ItemDetail testItemDetail;


    @BeforeEach
    public void setup() {
        sightSeeingPlace = new SightSeeingPlaces("Eiffel Tower", 1, 1, 2019);
        itemDetail = new ItemDetail("test description");
    }

    @Test
    public void testSetAppropriateToDoItem() {
        itemDetail.setAppropriateToDoItem(sightSeeingPlace);
        assertTrue((itemDetail.getAppropriateToDoItem().equals(sightSeeingPlace)));
    }

    @Test
    public void testRemoveItemDetail() {
        itemDetail.setAppropriateToDoItem(sightSeeingPlace);
        itemDetail.removeItemDetail();
        sightSeeingPlace.setItemDetail(itemDetail);
        testItemDetail = new ItemDetail("");
        assertTrue(sightSeeingPlace.getAppropriateItemDetail().equals(testItemDetail));
    }

    @Test
    public void testDisplay() {
        assertEquals(itemDetail, itemDetail);
    }

}