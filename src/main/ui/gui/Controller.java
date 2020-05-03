package ui.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

// sources: https://www.youtube.com/watch?v=uz2sWCnTq6E&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG&index=20
//          https://www.youtube.com/watch?v=gJYXctDSIl8
public class Controller implements Initializable {

    private List<SightSeeingPlace> ssevents;
    private List<Activity> acevents;
    private List<PlaceToEat> pteevents;

    @FXML
    private Button currencyExchangeButton;

    @FXML
    private Button placesToEatButton;

    @FXML
    private Button activitiesButton;

    @FXML
    private Button sightSeeingButton;

    @FXML
    private Button powerButton;

    @FXML
    private AnchorPane currencyExchange;

    @FXML
    private AnchorPane home;

    @FXML
    private AnchorPane placesToEat;

    @FXML
    private AnchorPane activities;

    @FXML
    private AnchorPane sightSeeing;

    @FXML
    private AnchorPane power;

    @FXML
    private Button submitButton;

    @FXML
    private TableView<Rates> ratesTable;

    @FXML
    private TableColumn<Rates, String> currencyColumn;

    @FXML
    private TableColumn<Rates, Double> ratesColumn;

    @FXML
    private TableView<PlaceToEat> pteTable;

    @FXML
    private TableColumn<PlaceToEat, String> ptePlaceColumn;

    @FXML
    private TableColumn<PlaceToEat, String> pteDateColumn;

    @FXML
    private TableColumn<PlaceToEat, String> pteDetailColumn;

    @FXML
    private TextField pteText;

    @FXML
    private TextField pteDateText;

    @FXML
    private TextField pteDetailText;

    @FXML
    private TableView<Activity> acTable;

    @FXML
    private TableColumn<Activity, String> acActivityColumn;

    @FXML
    private TableColumn<Activity, String> acDateColumn;

    @FXML
    private TableColumn<Activity, String> acDetailColumn;

    @FXML
    private TextField acText;

    @FXML
    private TextField acDateText;

    @FXML
    private TextField acDetailText;

    @FXML
    private TableView<SightSeeingPlace> ssTable;

    @FXML
    private TableColumn<SightSeeingPlace, String> ssPlaceColumn;

    @FXML
    private TableColumn<SightSeeingPlace, String> ssDateColumn;

    @FXML
    private TableColumn<SightSeeingPlace, String> ssDetailColumn;

    @FXML
    private TextField ssText;

    @FXML
    private TextField ssDateText;

    @FXML
    private TextField ssDetailText;

    @FXML
    private Button pteAddButton;

    @FXML
    private Button pteRemoveButton;

    @FXML
    private Button acAddButton;

    @FXML
    private Button acRemoveButton;

    @FXML
    private Button ssAddButton;

    @FXML
    private Button ssRemoveButton;

    // MODIFIES: placesToEat
    // EFFECTS: Creates a new ObservableList that contains all the values in pteevents, returns the new ObservableList
    private ObservableList<PlaceToEat> getPlacesToEat() {
        pteevents = new ArrayList<>();
        ObservableList<PlaceToEat> placesToEat = FXCollections.observableArrayList();
        placesToEat.addAll(pteevents);
        return placesToEat;
    }

    // MODIFIES: activities
    // EFFECTS: Creates a new ObservableList that contains all the values in acevents, returns the new ObservableList
    private ObservableList<Activity> getActivities() {
        acevents = new ArrayList<>();
        ObservableList<Activity> activities = FXCollections.observableArrayList();
        activities.addAll(acevents);
        return activities;
    }

    // MODIFIES: sightSeeingPlaces
    // EFFECTS: Creates a new ObservableList that contains all the values in ssevents, returns the new ObservableList
    private ObservableList<SightSeeingPlace> getSightSeeingPlaces() {
        ssevents = new ArrayList<>();
        ObservableList<SightSeeingPlace> sightSeeingPlaces = FXCollections.observableArrayList();
        sightSeeingPlaces.addAll(ssevents);
        return sightSeeingPlaces;
    }

    // MODIFIES: rates
    // EFFECTS: Creates a new ObservableList that contains all of the rates, returns the new ObservableList
    private ObservableList<Rates> getRates() {
        ObservableList<Rates> rates = FXCollections.observableArrayList();
        addAllRatesOne(rates);
        addAllRatesTwo(rates);
        addAllRatesThree(rates);
        return rates;
    }

    // MODIFIES: rates
    // EFFECTS: adds the given rates to the ObservableList "rates"
    private void addAllRatesThree(ObservableList<Rates> rates) {
        rates.add(new Rates("PKR",116.93047));
        rates.add(new Rates("PLN",2.928795));
        rates.add(new Rates("PYG",4764.916667));
        rates.add(new Rates("RON",3.262163));
        rates.add(new Rates("RUB",48.340562));
        rates.add(new Rates("SAR",2.836282));
        rates.add(new Rates("SEK",7.33675));
        rates.add(new Rates("SGD",1.028467));
        rates.add(new Rates("THB",22.925525));
        rates.add(new Rates("TRY",4.363072));
        rates.add(new Rates("TWD",23.014952));
        rates.add(new Rates("UAH",18.441556));
        rates.add(new Rates("USD",0.755551));
        rates.add(new Rates("UYU",28.320456));
        rates.add(new Rates("VND",17543.859649));
        rates.add(new Rates("ZAR",11.236391));
    }

    // MODIFIES: rates
    // EFFECTS: adds the given rates to the ObservableList "rates"
    private void addAllRatesTwo(ObservableList<Rates> rates) {
        rates.add(new Rates("GTQ",5.825081));
        rates.add(new Rates("HKD",5.913331));
        rates.add(new Rates("HRK",5.097116));
        rates.add(new Rates("HUF",228.967359));
        rates.add(new Rates("IDR",10769.015446));
        rates.add(new Rates("ILS",2.646312));
        rates.add(new Rates("INR",54.124408));
        rates.add(new Rates("ISK",94.2868));
        rates.add(new Rates("JPY",82.431576));
        rates.add(new Rates("KRW",879.394109));
        rates.add(new Rates("KZT",294.737113));
        rates.add(new Rates("MXN",14.497558));
        rates.add(new Rates("MYR",3.130327));
        rates.add(new Rates("NOK",6.913214));
        rates.add(new Rates("NZD",1.191329));
        rates.add(new Rates("PAB",0.756256));
        rates.add(new Rates("PEN",2.548679));
        rates.add(new Rates("PHP",38.37636));
    }

    // MODIFIES: rates
    // EFFECTS: adds the given rates to the ObservableList "rates"
    private void addAllRatesOne(ObservableList<Rates> rates) {
        rates.add(new Rates("CAD",1));
        rates.add(new Rates("AED",2.777028));
        rates.add(new Rates("ARS",45.272367));
        rates.add(new Rates("AUD",1.103692));
        rates.add(new Rates("BGN",1.339561));
        rates.add(new Rates("BRL",3.141982));
        rates.add(new Rates("BSD",0.756256));
        rates.add(new Rates("CHF",0.751171));
        rates.add(new Rates("CLP",572.30259));
        rates.add(new Rates("CNY",5.294848));
        rates.add(new Rates("COP",2486.043478));
        rates.add(new Rates("CZK",17.475015));
        rates.add(new Rates("DKK",5.119416));
        rates.add(new Rates("DOP",39.845993));
        rates.add(new Rates("EGP",12.176107));
        rates.add(new Rates("EUR",0.685454));
        rates.add(new Rates("FJD",1.652668));
        rates.add(new Rates("GBP",0.588056));
    }


    // MODIFIES: pteTable, ptePlaceColumn, pteDateColumn, pteDetailColumn
    // EFFECTS: setup the placeToEat Table
    private void pteTableSetup() {
        ptePlaceColumn.setCellValueFactory(new PropertyValueFactory<>("placeToEat"));
        pteDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        pteDetailColumn.setCellValueFactory(new PropertyValueFactory<>("details"));
        pteTable.setItems(getPlacesToEat());
    }

    // MODIFIES: acTable, acActivityColumn, acDateColumn, acDetailColumn
    // EFFECTS: setup the activity Table
    private void acTableSetup() {
        acActivityColumn.setCellValueFactory(new PropertyValueFactory<>("activity"));
        acDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        acDetailColumn.setCellValueFactory(new PropertyValueFactory<>("details"));
        acTable.setItems(getActivities());
    }

    // MODIFIES: sTable, ssPlaceColumn, ssDateColumn, ssDetailColumn
    // EFFECTS: setup the sightSeeing Table
    private void ssTableSetup() {
        ssPlaceColumn.setCellValueFactory(new PropertyValueFactory<>("sightSeeingPlace"));
        ssDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        ssDetailColumn.setCellValueFactory(new PropertyValueFactory<>("details"));
        ssTable.setItems(getSightSeeingPlaces());
    }

    // MODIFIES: placeToEat, pteTable, pteText, pteDateText, pteDetailText
    // EFFECTS: adds the filled in text fields into the pteTable and then clears the text fields
    private void pteAddButtonClicked() {
        PlaceToEat placeToEat = new PlaceToEat();
        placeToEat.setPlaceToEat(pteText.getText());
        placeToEat.setDate(pteDateText.getText());
        placeToEat.setDetails(pteDetailText.getText());
        pteTable.getItems().add(placeToEat);
        pteText.clear();
        pteDateText.clear();
        pteDetailText.clear();
    }

    // MODIFIES: activity, acTable, acText, acDateText, acDetailText
    // EFFECTS: adds the filled in text fields into the acTable and then clears the text fields
    private void acAddButtonClicked() {
        Activity activity = new Activity();
        activity.setActivity(acText.getText());
        activity.setDate(acDateText.getText());
        activity.setDetails(acDetailText.getText());
        acTable.getItems().add(activity);
        acText.clear();
        acDateText.clear();
        acDetailText.clear();
    }

    // MODIFIES: sightSeeingPlace , ssTable, ssText, ssDateText, ssDetailText
    // EFFECTS: adds the filled in text fields into the ssTable and then clears the text fields
    private void ssAddButtonClicked() {
        SightSeeingPlace sightSeeingPlace = new SightSeeingPlace();
        sightSeeingPlace.setSightSeeingPlace(ssText.getText());
        sightSeeingPlace.setDate(ssDateText.getText());
        sightSeeingPlace.setDetails(ssDetailText.getText());
        ssTable.getItems().add(sightSeeingPlace);
        ssText.clear();
        ssDateText.clear();
        ssDetailText.clear();
    }


    // MODIFIES: placesToEatAll
    // EFFECTS: removes the selected PlaceToEat from the Table
    private void pteRemoveButtonClicked() {
        ObservableList<PlaceToEat> placesToEatSelected;
        ObservableList<PlaceToEat> placesToEatAll;

        placesToEatAll = pteTable.getItems();
        placesToEatSelected = pteTable.getSelectionModel().getSelectedItems();

        placesToEatSelected.forEach(placesToEatAll::remove);
    }

    // MODIFIES: activitiesAll
    // EFFECTS: removes the selected Activity from the Table
    private void acRemoveButtonClicked() {
        ObservableList<Activity> activitiesSelected;
        ObservableList<Activity> activitiesAll;

        activitiesAll = acTable.getItems();
        activitiesSelected = acTable.getSelectionModel().getSelectedItems();

        activitiesSelected.forEach(activitiesAll::remove);
    }

    // MODIFIES: sightSeeingAll
    // EFFECTS: removes the selected sightSeeingPlace from the Table
    private void ssRemoveButtonClicked() {
        ObservableList<SightSeeingPlace> sightSeeingSelected;
        ObservableList<SightSeeingPlace> sightSeeingAll;

        sightSeeingAll = ssTable.getItems();
        sightSeeingSelected = ssTable.getSelectionModel().getSelectedItems();

        sightSeeingSelected.forEach(sightSeeingAll::remove);
    }

    @FXML
    // MODIFIES: home, currencyExchange, placesToEat, activities, sightSeeing, power
    // EFFECTS: changes the visible scene to the one that corresponds to the correct button
    private void handleButtonAction(MouseEvent event) {
        if (event.getSource() == submitButton) {
            showHomePage();
        } else if (event.getSource() == currencyExchangeButton) {
            showHomePage();
        } else if (event.getSource() == placesToEatButton) {
            showPlacesToEatPage();
        } else if (event.getSource() == activitiesButton) {
            showActivitesPages();
        } else if (event.getSource() == sightSeeingButton) {
            showSightSeeingPage();
        } else if (event.getSource() == powerButton) {
            showEndPage();
        }
    }

    // MODIFIES: home, currencyExchange, placesToEat, activities, sightSeeing, power
    // EFFECTS: Displays only the power page
    private void showEndPage() {
        home.setVisible(false);
        currencyExchange.setVisible(false);
        placesToEat.setVisible(false);
        activities.setVisible(false);
        sightSeeing.setVisible(false);
        power.setVisible(true);
    }

    // MODIFIES: home, currencyExchange, placesToEat, activities, sightSeeing, power
    // EFFECTS: Displays only the sightSeeing page
    private void showSightSeeingPage() {
        home.setVisible(false);
        currencyExchange.setVisible(false);
        placesToEat.setVisible(false);
        activities.setVisible(false);
        sightSeeing.setVisible(true);
        power.setVisible(false);
    }

    // MODIFIES: home, currencyExchange, placesToEat, activities, sightSeeing, power
    // EFFECTS: Displays only the activities page
    private void showActivitesPages() {
        home.setVisible(false);
        currencyExchange.setVisible(false);
        placesToEat.setVisible(false);
        activities.setVisible(true);
        sightSeeing.setVisible(false);
        power.setVisible(false);
    }

    // MODIFIES: home, currencyExchange, placesToEat, activities, sightSeeing, power
    // EFFECTS: Displays only the placesToEat page
    private void showPlacesToEatPage() {
        home.setVisible(false);
        currencyExchange.setVisible(false);
        placesToEat.setVisible(true);
        activities.setVisible(false);
        sightSeeing.setVisible(false);
        power.setVisible(false);
    }

    // MODIFIES: home, currencyExchange, placesToEat, activities, sightSeeing, power
    // EFFECTS: Displays only the home page
    private void showHomePage() {
        home.setVisible(false);
        currencyExchange.setVisible(true);
        placesToEat.setVisible(false);
        activities.setVisible(false);
        sightSeeing.setVisible(false);
        power.setVisible(false);
    }

    @Override
    // MODIFIES: currencyColumn, ratesColumn, ratesTable, pteTable, ptePlaceColumn, pteDateColumn, pteDetailColumn,
    // acTable, acActivityColumn, acDateColumn, acDetailColumn, ssTable, ssPlaceColumn, ssDateColumn, ssDetailColumn,
    // pteAddButton, acAddButton, ssAddButton
    // EFFECTS: setup the appropriate table an button functionality
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("TravelApp is now loaded!");
        currencyColumn.setCellValueFactory(new PropertyValueFactory<>("currency"));
        ratesColumn.setCellValueFactory(new PropertyValueFactory<>("rate"));
        ratesTable.setItems(getRates());
        pteTableSetup();
        acTableSetup();
        ssTableSetup();

//        powerButton.setOnAction(e -> closeProgram());

        pteAddButton.setOnAction(e -> pteAddButtonClicked());
        acAddButton.setOnAction(e -> acAddButtonClicked());
        ssAddButton.setOnAction(e -> ssAddButtonClicked());

        pteRemoveButton.setOnAction(e -> pteRemoveButtonClicked());
        acRemoveButton.setOnAction(e -> acRemoveButtonClicked());
        ssRemoveButton.setOnAction(e -> ssRemoveButtonClicked());
    }
}