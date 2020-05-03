package ui.gui;

public class SightSeeingPlace {

    private String sightSeeingPlace;
    private String date;
    private String details;

    public SightSeeingPlace() {
        this.sightSeeingPlace = "";
        this.date = "";
        this.details = "";
    }

    public SightSeeingPlace(String placeToEat, String date, String details) {
        this.sightSeeingPlace = placeToEat;
        this.date = date;
        this.details = details;
    }

    // EFFECTS: returns the appropriate sightSeeingPlace
    public String getSightSeeingPlace() {
        return sightSeeingPlace;
    }

    //EFFECTS: returns the appropriate date
    public String getDate() {
        return date;
    }

    //EFFECTS: returns the appropriate details
    public String getDetails() {
        return details;
    }

    // MODIFIES: this
    // EFFECTS: sets the sightSeeingPlace to the given name
    public void setSightSeeingPlace(String name) {
        this.sightSeeingPlace = name;
    }

    // MODIFIES: this
    // EFFECTS: sets the date to the given date
    public void setDate(String date) {
        this.date = date;
    }

    // MODIFIES: this
    // EFFECTS: sets the details to the given details
    public void setDetails(String details) {
        this.details = details;
    }
}
