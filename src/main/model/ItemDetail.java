package model;

public class ItemDetail extends ActivityGroup {
    String itemDetail;
    ToDoItem toDoItem;

    public ItemDetail(String details) {
        this.itemDetail = details;
    }

    public void setAppropriateToDoItem(ToDoItem toDoItem) {
        this.toDoItem = toDoItem;
    }

    // MODIFIES: this
    // EFFECTS: sets this.itemDetail to an empty string
    public void removeItemDetail() {
        this.itemDetail = "";
    }

    // EFFECTS: returns this.toDoItem
    public ToDoItem getAppropriateToDoItem() {
        return this.toDoItem;
    }

    @Override
    // EFFECTS: displays the current node in the tree with a specified indentLevel
    public void display(String indentLevel) {
        System.out.println(indentLevel + itemDetail);
    }

    @Override
    // EFFECTS: returns true if two objects are equals, otherwise false
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ItemDetail that = (ItemDetail) o;

        return itemDetail.equals(that.itemDetail);
    }

    @Override
    // EFFECTS: returns the itemDetail's hashcode
    public int hashCode() {
        return itemDetail.hashCode();
    }
}
