package ui.gui;

import java.io.Serializable;

public class PlaceToEat {

    private String placeToEat;
    private String date;
    private String details;

    public PlaceToEat() {
        this.placeToEat = "";
        this.date = "";
        this.details = "";
    }

    public PlaceToEat(String placeToEat, String date, String details) {
        this.placeToEat = placeToEat;
        this.date = date;
        this.details = details;
    }

    // EFFECTS: returns the appropriate placeToEat
    public String getPlaceToEat() {
        return placeToEat;
    }

    // EFFECTS: returns the appropriate date
    public String getDate() {
        return date;
    }

    // EFFECTS: returns the appropriate details
    public String getDetails() {
        return details;
    }

    // MODIFIES: this
    // EFFECTS: sets this.placeToEat to the given name
    public void setPlaceToEat(String name) {
        this.placeToEat = name;
    }

    // MODIFIES: this
    // EFFECTS: sets this.date to the given date
    public void setDate(String date) {
        this.date = date;
    }

    // MODIFIES: this
    // EFFECTS: sets this.Details to the given details
    public void setDetails(String details) {
        this.details = details;
    }
}
