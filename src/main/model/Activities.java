package model;

public class Activities extends ToDoItem {

    // EFFECTS: creates a new Activity scheduled for a select day, month, year
    public Activities(String activities, int day, int month, int year) {
        super(activities, day, month, year);
    }

    // EFFECTS: returns a message: "Activity has been completed!"
    public String complete() {
        return "Activity has been completed!";
    }
}
