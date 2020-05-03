package placeholder;

import model.ItemDetail;
import model.ThingsToDo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.TravelApp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TestThingsToDo {
    private ThingsToDo toDoList;
    private ThingsToDo testList;
    Date today = new Date();
    Date myDate = new Date(2000, 7, 20);
    TravelApp travelApp;

    @BeforeEach
    public void runBefore() {
        toDoList = new ThingsToDo();
        testList = new ThingsToDo();
        travelApp = new TravelApp();
    }

    @Test
    public void testInsert() {
        toDoList.insert("hello");

        assertTrue(toDoList.contains("hello"));
        assertEquals(1, toDoList.size());
    }

    @Test
    public void testSizeOne() {
        assertEquals(0, toDoList.size());
        toDoList.insert("hi");
        assertEquals(1, toDoList.size());
    }

    @Test
    public void testSizeLots() {
        assertEquals(0, toDoList.size());

        for (int i = 0; i < 2000; i++) {
            toDoList.insert(Integer.toString(i));
        }

        assertEquals(2000, toDoList.size());
    }

    @Test
    public void testContainsOne() {
        assertFalse(toDoList.contains("hello"));
        toDoList.insert("hello");
        assertTrue(toDoList.contains("hello"));
        assertEquals(1, toDoList.size());
    }

    @Test
    public void testContainsLots() {
        for (int i = 0; i < 100; i++) {
            toDoList.insert("hi");
        }

        for (int i = 0; i < 100; i++) {
            assertTrue(toDoList.contains("hi"));
        }
    }

    @Test
    public void testDuplicated() {
        toDoList.insert("hey");
        toDoList.insert("hey");

        assertTrue(toDoList.contains("hey"));
        assertEquals(1, toDoList.size());
    }

    @Test
    public void testRemoveOne() {
        toDoList.insert("hi");
        toDoList.insert("hello");
        assertTrue(toDoList.contains("hi"));
        assertTrue(toDoList.contains("hello"));
        toDoList.remove("hi");
        assertTrue((!toDoList.contains("hi")));
        assertTrue(toDoList.contains("hello"));
    }

    @Test
    public void testRemoveServeral() {
        toDoList.insert("a");
        toDoList.insert("b");
        toDoList.insert("c");
        toDoList.insert("d");
        toDoList.insert("e");
        toDoList.insert("f");
        toDoList.remove("a");
        toDoList.remove("c");
        toDoList.remove("e");
        assertFalse(toDoList.contains("a"));
        assertTrue(toDoList.contains("b"));
        assertFalse(toDoList.contains("c"));
        assertTrue(toDoList.contains("d"));
        assertFalse(toDoList.contains("e"));
        assertTrue(toDoList.contains("f"));
    }

    @Test
    public void testRemoveDuplicated() {
        toDoList.insert("hi");
        toDoList.insert("hi");
        assertTrue(toDoList.contains("hi"));
        assertEquals(1, toDoList.size());
        toDoList.remove("hi");
        assertFalse((toDoList.contains("hi")));
        assertEquals(0, toDoList.size());
    }

    @Test
    public void testPrintThingsToDo() {
        toDoList.insert("hi");
        assertTrue(toDoList.contains("hi"));
        testList.insert("hi");
        assertTrue(testList.contains("hi"));

        toDoList.printThingsToDo();
        testList.printThingsToDo();
    }

    @Test
    public void testGetNewItems() {
        assertEquals(0, toDoList.getNewItems());
        toDoList.insert("hi");
        assertEquals(1, toDoList.getNewItems());
        toDoList.insert("hey");
        toDoList.insert("hai");
        toDoList.insert("hei");
        assertEquals(4, toDoList.getNewItems());
    }

//    @Test
//    public void testGetList() {
//        toDoList.insert("hi");
//        assertTrue(toDoList.contains("hi"));
//        testList.insert("hi");
//        assertEquals(toDoList.getList(),testList.getList());
//    }

//    @Test
//    public void testInsertDetails() {
//        toDoList.insert("Hiking");
//        toDoList.insertDetails("Hiking", new ItemDetail("Description"));
//        testList.insert("Hiking");
//        testList.insertDetails("Hiking", new ItemDetail("Description"));
//        ItemDetail description = toDoList.getDetails("Hiking");
//        ItemDetail otherDescription = testList.getDetails("Hiking");
//        assertTrue(description.equals(otherDescription));
//    }
//
//    @Test
//    public void testGetDetails() {
//        toDoList.insert("Hiking");
//        toDoList.insertDetails("Hiking", new ItemDetail("Description"));
//        testList.insert("Hiking");
//        testList.insertDetails("Hiking", new ItemDetail("Description"));
//        ItemDetail description = toDoList.getDetails("Hiking");
//        ItemDetail otherDescription = testList.getDetails("Hiking");
//        assertTrue(description.equals(otherDescription));
//    }


}




