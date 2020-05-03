package model;

import observer.ItemCounter;

import java.util.*;

//represents a list of things to do in destination
public class ThingsToDo extends Observable implements ThingsToDoBehaviour {

    private ArrayList<String> toDoItems;
    private int newItems;

    // EFFECTS: toDoItems is empty list
    public ThingsToDo() {
        toDoItems = new ArrayList<>();
        this.newItems = toDoItems.size();
    }

    // MODIFIES: this
    // EFFECTS: adds toDoItem key into hashMap with given details if it's not
    // already in the list
    @Override
    public void insert(String todo) {
        if (!toDoItems.contains(todo)) {
            toDoItems.add(todo);
            addObserver(new ItemCounter());
            newItems++;
        }
    }

    // MODIFIES: counter
    // EFFECTS: returns the value of counter
    public int getNewItems() {
        return this.newItems;
    }

    @Override
    public void complete(Integer newItems) {
        setChanged();
        notifyObservers(newItems);
    }

    // REQUIRES String ss is an element of the list
    // MODIFIES: this
    // EFFECTS: String ss is removed from the list
    @Override
    public void remove(String todo) {
        toDoItems.remove(todo);
        newItems--;
    }

    //EFFECTS: returns an ArrayList of thingsToDo
    @Override
    public ArrayList<String> getToDoItems() {
        return toDoItems;
    }

    @Override
    // EFFECTS: returns true is toDoItems contains given todoItem, otherwise return false
    public boolean contains(String todo) {
        return toDoItems.contains(todo);
    }

    // EFFECTS: returns the number of items in the set
    @Override
    public int size() {
        return toDoItems.size();
    }

    // EFFECTS: prints a list of things to do
    @Override
    public void printThingsToDo() {
        for (int i = 0; i < toDoItems.size(); i++) {
            System.out.println(toDoItems.get(i));
        }
    }
}