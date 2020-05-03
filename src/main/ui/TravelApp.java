package ui;

import exceptions.CantFindToDoItem;

import model.*;
import network.ReadJSonFile;

import java.util.*;
import java.io.*;

// This app will record things you want to do and the date that
// you wish to do these activities. Each activity will be sorted into
// separate categories from sight seeing, places to eat, and activities.
// Things to do will be checked off as they are completed or expired.
// This app will also help record your budgets for the vacation,
// tracking your spending and limits

public class TravelApp implements Saveable, Loadable {
    private Scanner scanner;
    private ThingsToDoBehaviour sightSeeingPlaces;
    private ThingsToDoBehaviour placesToEat;
    private ThingsToDoBehaviour listOfActivities;
    private String destination;
    private String todo;
    private int day;
    private int month;
    private int year;
    private String details;
    private ItemDetail itemDetails;
    private ReadJSonFile readJSonFile = new ReadJSonFile();
    private ToDoItem toDoItems = new SightSeeingPlaces("List Starts Here: ", 0,0,0);

    public TravelApp() {
        this.scanner = new Scanner(System.in);
        this.sightSeeingPlaces = new ThingsToDo();
        this.placesToEat = new ThingsToDo();
        this.listOfActivities = new ThingsToDo();
    }

    // EFFECTS: returns this.placesToEat
    public ThingsToDoBehaviour getPlacesToEat() {
        return this.placesToEat;
    }

    // MODIFIES: operation, destination, sightSeeingPlaces, placesToEat, listOfActivities, scanner, todoItem, day,
    // month, year, details, toDoItems, readJSonFile
    // EFFECTS: setup the main menu in console for the application
    private void menu() throws IOException {
        System.out.println("Please enter your desired destination.");
        destination = scanner.nextLine();
        System.out.println("You selected " + destination + " as your destination!");
        readJSonFile.readJSonFile();
        while (true) {
            String operation = printOptions(destination);
            System.out.println("You selected " + operation);
            if (operation.equals("1")) {
                addItem();
            } else if (operation.equals("2")) {
                removeToDoItem();
            } else if (operation.equals("3")) {
                loadAllActivities();
            } else if (operation.equals("4")) {
                save();
                break;
            }
        }
    }

    // MODIFIES: ssNewItems, pteNewItems, loaNewItems, sumNewItems
    // EFFECTS: returns sum of new items added
    private int sumNewItems() {
        int ssNewItems = sightSeeingPlaces.getNewItems();
        int pteNewItems = placesToEat.getNewItems();
        int loaNewItems = listOfActivities.getNewItems();
        int sumNewItems = ssNewItems + pteNewItems + loaNewItems;
        return sumNewItems;
    }

    // MODIFIES: operation
    // EFFECTS: prints options for application
    private String printOptions(String destination) {
        System.out.println("What would you like to do? [1] add things to do in " + destination + ", "
                + "[2] remove an activity, [3] load existing list, or [4] save and quit.");
        String operation = scanner.nextLine();
        return operation;
    }

    // MODIFIES: operation
    // EFFECTS: prints options of which list the user would like to add an item to
    private void addItem() {
        System.out.println("Please select a category [1] sightseeing, [2] places to eat, or [3] activities!");
        String operation = scanner.nextLine();
        if (operation.equals("1")) {
            addSightSeeing();
        } else if (operation.equals("2")) {
            addPlacesToEat();
        } else if (operation.equals("3")) {
            addActivity();
        }
    }

    // MODIFIES: todoOperation, thingsToDo, day, month, year
    // EFFECTS: prompts user with filling out adding information
    private void addToDoItem(ThingsToDoBehaviour thingsToDo) {
        System.out.println("Please enter the activity you would like to add!");
        todo = scanner.nextLine();
        thingsToDo.insert(todo);
        System.out.println("Please enter the day you would like to schedule " + todo);
        day = scanner.nextInt();
        System.out.println("Please enter the month you would like to schedule " + todo);
        month = scanner.nextInt();
        System.out.println("Please enter the year you would like to schedule " + todo);
        year = scanner.nextInt();
    }

    // MODIFIES: sightSeeing, toDoItems, details, itemDetails
    // EFFECTS: adds the todoItem to the sightSeeing list and creates a new SightSeeing and ItemDetail object
    private void addSightSeeing() {
        addToDoItem(sightSeeingPlaces);
        SightSeeingPlaces sightSeeing = new SightSeeingPlaces(todo,day,month,year);
        toDoItems.addActivityGroup(sightSeeing);
        scanner.nextLine();
        System.out.println("Please enter a sight seeing description if applicable!");
        details = scanner.nextLine();
        itemDetails = new ItemDetail(details);
        sightSeeing.addActivityGroup(itemDetails);
        System.out.println(sightSeeing.getToDoItemName() + " has been added to the list for " + sightSeeing.getDate());
    }

    // MODIFIES: placesToEat, toDoItems, details, itemDetails
    // EFFECTS: adds the todoItem to the placesToEat list and creates a new PlaceToEat and ItemDetail object
    private void addPlacesToEat() {
        addToDoItem(placesToEat);
        PlacesToEat placeToEat = new PlacesToEat(todo,day,month,year);
        toDoItems.addActivityGroup(placeToEat);
        scanner.nextLine();
        System.out.println("Please enter a dinning description if applicable!");
        details = scanner.nextLine();
        itemDetails = new ItemDetail(details);
        placeToEat.addActivityGroup(itemDetails);
        System.out.println(placeToEat.getToDoItemName() + " has been added to the list for " + placeToEat.getDate());
    }

    // MODIFIES: listOfActivities, toDoItems, details, itemDetails
    // EFFECTS: adds the todoItem to the listOfActivities list and creates a new Activity and ItemDetail object
    private void addActivity() {
        addToDoItem(listOfActivities);
        Activities activity = new Activities(todo,day,month,year);
        toDoItems.addActivityGroup(activity);
        scanner.nextLine();
        System.out.println("Please enter an activity description if applicable!");
        details = scanner.nextLine();
        itemDetails = new ItemDetail(details);
        activity.addActivityGroup(itemDetails);
        System.out.println(activity.getToDoItemName() + " has been added to the list for " + activity.getDate());
    }

    // MODIFIES: operation
    // EFFECTS: prompts user to select which category to remove an item from
    private void removeToDoItem() {
        System.out.println("Which category would you like to remove from [1] Sight Seeing, [2] Places to Eat, or"
                + " [3] Activities?");
        String operation = scanner.nextLine();
        System.out.println("you selected " + operation);
        if (operation.equals("1")) {
            sightSeeingExceptionHandle();
        }
        if (operation.equals("2")) {
            placeToEatExceptionHandle();
        }
        if (operation.equals("3")) {
            activityExceptionHandle();
        }
    }

    // EFFECTS: Handles the sightSeeingException
    private void sightSeeingExceptionHandle() {
        try {
            removeSightSeeingPlace();
        } catch (CantFindToDoItem cantFindToDoItem) {
            System.out.println("Couldn't find sight seeing place with that name, please try again!");
        } finally {
            System.out.println("Your list has been updated!");
        }
    }

    // EFFECTS: Handles the placeToEatException
    private void placeToEatExceptionHandle() {
        try {
            removePlaceToEat();
        } catch (CantFindToDoItem cantFindToDoItem) {
            System.out.println("Couldn't find place to eat with that name, please try again!");
        } finally {
            System.out.println("Your list has been updated!");
        }
    }

    // EFFECTS: Handles the activityException
    private void activityExceptionHandle() {
        try {
            removeActivity();
        } catch (CantFindToDoItem cantFindToDoItem) {
            System.out.println("Couldn't find activity with that name, please try again!");
        } finally {
            System.out.println("Your list has been updated!");
        }
    }

    // MODIFIES: sightSeeingPlaces
    // EFFECTS: removes the appropriate sightSeeingPlace from the list
    private void removeSightSeeingPlace() throws CantFindToDoItem {
        removeItem(sightSeeingPlaces);
    }

    // MODIFIES: placesToEat
    // EFFECTS: removes the appropriate PlaceToEat from the list
    private void removePlaceToEat() throws CantFindToDoItem {
        removeItem(placesToEat);
    }


    // MODIFIES: listOfActivities
    // EFFECTS: removes the appropriate Activity from the list
    private void removeActivity() throws CantFindToDoItem {
        removeItem(listOfActivities);
    }

    // MODIFIES: operation, thingsToDo
    // EFFECTS: removes the specified thingsToDo from the specified List
    private void removeItem(ThingsToDoBehaviour thingsToDo) throws CantFindToDoItem {
        System.out.println("Here is your list!");
        thingsToDo.printThingsToDo();
        System.out.println("Please enter the activity you would like to remove.");
        String operation = scanner.nextLine();
        if (thingsToDo.contains(operation)) {
            thingsToDo.remove(operation);
            System.out.println(operation + " has been removed!");
        } else {
            throw new CantFindToDoItem();
        }
    }

    // EFFECTS: Saves the list of things to do to appropriate save file
    @Override
    public void save() throws IOException {
        FileWriter sightSeeingWriter = new FileWriter("sightseeing.txt");
        FileWriter placesToEatWriter = new FileWriter("placestoeat.txt");
        FileWriter activitiesWriter = new FileWriter("activities.txt");
        for (String item : sightSeeingPlaces.getToDoItems()) {
            sightSeeingWriter.write(item + "\n");
        }
        sightSeeingWriter.close();
        for (String item : placesToEat.getToDoItems()) {
            placesToEatWriter.write(item + "\n");
        }
        placesToEatWriter.close();
        for (String item : listOfActivities.getToDoItems()) {
            activitiesWriter.write(item + "\n");
        }
        activitiesWriter.close();
        sightSeeingPlaces.complete(sumNewItems());
        toDoItems.display("   ");
    }

    // EFFECTS: loads all activities and prints message: " Your existing information has been loaded"
    private void loadAllActivities() {
        load();
        System.out.println("Your existing information has been loaded");
    }

    // EFFECTS: loads all Activities
    @Override
    public void load() {
        sightSeeingLoad();
        placesToEatLoad();
        activitiesLoad();
    }

    // MODIFIES: file, fileReader, sightSeeingPlaces
    // EFFECTS: loads sightSeeingPlaces
    private void sightSeeingLoad() {
        try {
            File file = new File("sightseeing.txt");
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                sightSeeingPlaces.insert(fileReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("");
        }
    }

    // MODIFIES: file, fileReader, placesToEat
    // EFFECTS: loads placesToEat
    private void placesToEatLoad() {
        try {
            File file = new File("placestoeat.txt");
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                placesToEat.insert(fileReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("");
        }
    }

    // MODIFIES: file, fileReader, listOfActivities
    // EFFECTS: loads activities
    private void activitiesLoad() {
        try {
            File file = new File("activities.txt");
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                listOfActivities.insert(fileReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("");
        }
    }

    public static void main(String[] args) throws IOException {
        TravelApp travelApp = new TravelApp();
        travelApp.menu();
    }
}

