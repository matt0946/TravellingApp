package model;

import java.util.ArrayList;
import java.util.List;

public abstract class ToDoItem extends ActivityGroup {
    private String toDoItem;
    private int day;
    private int month;
    private int year;
    private ItemDetail itemDetail;
    private List<ActivityGroup> activities = new ArrayList<>();

    public ToDoItem(String activities,int day, int month, int year) {
        this.toDoItem = activities;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // MODIFIES: this.itemDetail
    // EFFECTS: sets the specified item detail
    public void setItemDetail(ItemDetail itemDetail) {
        this.itemDetail = itemDetail;
    }

    // MODIFIES: this.toDoItem, this.itemDetail
    // EFFECTS: sets this.toDoItem and this.itemDetail to an empty string
    public void removeToDoItem() {
        this.toDoItem = "";
        this.itemDetail = new ItemDetail("");
    }

    // EFFECTS: returns this.itemDetail
    public ItemDetail getAppropriateItemDetail() {
        return this.itemDetail;
    }

    // EFFECTS: returns the date of the scheduled todoitem in the form MM/DD/YYYY
    public String getDate() {
        return (this.month + "/" + this.day + "/" + this.year);
    }

    // EFFECTS: returns the name of the todoitem
    public String getToDoItemName() {
        return this.toDoItem;
    }

    // MODIFIES: this.activities
    // EFFECTS: adds the given a to this.activities
    public void addActivityGroup(ActivityGroup a) {
        activities.add(a);
    }

    @Override
    // EFFECTS: displays a tree of all the toDoItems as the nodes, and activityGroup as the children
    public void display(String indentLevel) {
        System.out.println(indentLevel + toDoItem);
        for (ActivityGroup activityGroup : activities) {
            activityGroup.display(indentLevel + indentLevel);
        }
    }
}
