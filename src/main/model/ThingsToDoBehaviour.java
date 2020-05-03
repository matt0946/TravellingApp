package model;

import java.util.ArrayList;
import java.util.List;

public interface ThingsToDoBehaviour {

    // MODIFIES: this
    // EFFECTS: thingToDo is added to list if it's not
    // already in the list
    void insert(String todo);

    // EFFECTS: returns the appropriate toDoItems
    ArrayList<String> getToDoItems();

    // EFFECTS: Returns true if Integer i is in the IntegerSet
    // and false otherwise
    boolean contains(String todo);

    // REQUIRES String ss is an element of the list
    // MODIFIES: this
    // EFFECTS: String ss is removed from the list
    void remove(String todo);

    // EFFECTS: returns the number of items in the set
    int size();

    // EFFECTS: prints a list of things to do
    void printThingsToDo();

    // EFFECTS: returns the number of newItems
    int getNewItems();

    // EFFECTS: prints the newItems counter
    void complete(Integer i);
}
