package ui.gui;

public class Activity {

    private String activity;
    private String date;
    private String details;

    public Activity() {
        this.activity = "";
        this.date = "";
        this.details = "";
    }

    public Activity(String placeToEat, String date, String details) {
        this.activity = placeToEat;
        this.date = date;
        this.details = details;
    }

    // EFFECTS: returns this.activity
    public String getActivity() {
        return activity;
    }

    // EFFECTS: returns this.date;
    public String getDate() {
        return date;
    }

    // EFFECTS; returns this.details
    public String getDetails() {
        return details;
    }

    // MODIFIES: this
    // EFFECTS: sets this.activity to the given name
    public void setActivity(String name) {
        this.activity = name;
    }

    // MODIFIES: this
    // EFFECTS: sets this.date to the given date
    public void setDate(String date) {
        this.date = date;
    }

    // MODIFIES: this
    // EFFECTS: sets this.details to the given details
    public void setDetails(String details) {
        this.details = details;
    }
}
