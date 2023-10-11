package main;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindowController {
    @FXML
    private Pane titlePane;
    @FXML
    private ImageView btnClose, btnMinimize;
    @FXML
    private Label lblResult;

    private String operator = ".";
    private double num1 = 0;
    private double x, y;

    public void init(Stage stage) {
        titlePane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        titlePane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });

        btnClose.setOnMouseClicked(mouseEvent -> stage.close());
        btnMinimize.setOnMouseClicked(mouseEvent -> stage.setIconified(true));
    }

    @FXML
    void OnNumberClicked(MouseEvent event) {
        // Gets the number from the ID of the button clicked
        int value = Integer.parseInt(((Pane) event.getSource()).getId().replace("btn", ""));
        // Gets the current result
        Double result = Double.parseDouble(lblResult.getText());
        // If the result is 0, set it to the number clicked, otherwise add the number clicked to the result
        lblResult.setText(result == 0 ? String.valueOf((double) value) : String.valueOf(result * 10 + value));
    }

    @FXML
    void OnSymbalClicked(MouseEvent event) {
        String symbol = ((Pane) event.getSource()).getId().replace("btn", "");
        if (symbol.equals("Equal")) {
            Double num2 = Double.parseDouble(lblResult.getText());
            switch (operator) {
                case "+" -> lblResult.setText(String.valueOf(num1 + num2));
                case "-" -> lblResult.setText(String.valueOf(num1 - num2));
                case "*" -> lblResult.setText(String.valueOf(num1 * num2));
                case "/" -> lblResult.setText(String.valueOf(num1 / num2));
            }
            operator = ".";
        } else if (symbol.equals("Clear")) {
            lblResult.setText(String.valueOf(0.0));
            operator = ".";
        } else {
            switch (symbol) {
                case "Plus" -> operator = "+";
                case "Minus" -> operator = "-";
                case "Multi" -> operator = "*";
                case "Divide" -> operator = "/";
            }
            num1 = Double.parseDouble(lblResult.getText());
            lblResult.setText(String.valueOf(0.0));
        }
    }
}
