package ui.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

// sources: https://www.youtube.com/watch?v=SpL3EToqaXA&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG&index=5
//          https://www.youtube.com/watch?v=ZuHcl5MmRck&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG&index=7
class CloseBox {

    private static boolean result;

    //EFFECTS: creates a new window that displays the options to close the window if the yesButton is pressed,
    // or stay open if the noButton is pressed
    static boolean display(String title, String message) {
        Stage window = new Stage(); // creates a blank window
        window.initModality(Modality.APPLICATION_MODAL); // block input events with other windows until this is handled
        window.setTitle("Exit");
        window.setMinWidth(250);
        Label promptLabel = new Label();
        promptLabel.setText("Are you sure you want to quit :(");

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        buttonActionSetup(window,yesButton,noButton);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(promptLabel,yesButton, noButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return result;
    }

    // MODIFIES: window, yesButton, noButton, result
    // EFFECTS: yesButton sets result to true and closes window, noButton sets result to false and closes window
    private static void buttonActionSetup(Stage window, Button yesButton, Button noButton) {
        yesButton.setOnAction(e -> {
            result = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            result = false;
            window.close();
        });
    }
}
