package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainWindow extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindowInterface.fxml")); // Loads the FXML file

        Scene scene = new Scene(loader.load()); // Loads the FXML file and creates a scene from it
        scene.setFill(Color.TRANSPARENT); // Makes the background of the window transparent (so that the shadow is visible)

        stage.setScene(scene); // Sets the scene to the stage
        stage.initStyle(StageStyle.TRANSPARENT); // Makes the window borderless
        stage.setResizable(false); // Makes the window not resizable
        stage.setTitle("Calculator");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/icon.png")));
        ((MainWindowController)loader.getController()).init(stage); // Initializes the controller
        stage.show(); // Shows the window
    }

    public void run() {
        launch();
    }
}
