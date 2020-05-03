package model;

public class PlacesToEat extends ToDoItem {

    // EFFECTS: creates a new Places to Eat scheduled for a given day, month, year
    public PlacesToEat(String activities, int day, int month, int year) {
        super(activities, day, month, year);
    }

    // EFFECTS: returns a message: "Eaten here!"
    public String complete() {
        return "Eaten here!";
    }
}
