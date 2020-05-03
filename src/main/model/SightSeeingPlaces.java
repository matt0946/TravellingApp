package model;

public class SightSeeingPlaces extends ToDoItem {

    // EFFECTS: creates a new Sight Seeing Places scheduled for a given day, month, year
    public SightSeeingPlaces(String activities, int day, int month, int year) {
        super(activities, day, month, year);
    }

    // EFFECTS: returns a message: "Place has been visited!"
    public String complete() {
        return "Place has been visited!";
    }
}
