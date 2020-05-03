package ui.gui;

import javafx.beans.property.SimpleStringProperty;

public class Rates {

    private String currency;
    private double rate;

    public Rates(String currency, double rate) {
        this.currency = currency;
        this.rate = rate;
    }

    // EFFECTS: returns the appropriate rate
    public double getRate() {
        return rate;
    }

    // EFFECTS: returns the appropriate currency
    public String getCurrency() {
        return currency;
    }


}
