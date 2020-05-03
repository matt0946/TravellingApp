
package ui.gui;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URISyntaxException;
import java.security.CodeSource;

public class Main extends Application {

    private Stage window;
    private Scene scene;

    @Override
    // MODIFIES: window, root, scene
    // EFFECTS: setup the application
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        window.setTitle("TravelApp");

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    // MODIFIES: this, answer
    // EFFECTS: if the answer from CloseBox.display is true, close the window, otherwise stay open and resume using
    public void closeProgram() {
        Boolean answer = CloseBox.display("Title", "Are you sure you want to quit");
        if (answer) {
            window.close();
        }
    }

    public static void main(String[] args) throws URISyntaxException {
        launch(args);
    }
}
