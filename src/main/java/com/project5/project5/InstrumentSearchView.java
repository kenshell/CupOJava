package com.project5.project5;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InstrumentSearchView extends Application {
    private ComboBox<String> instrumentTypeComboBox;
    private ComboBox<String> brandComboBox;
    private TextField maxCostField;
    private ComboBox<String> warehouseComboBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Instrument Search");

        instrumentTypeComboBox = new ComboBox<>();
        brandComboBox = new ComboBox<>();
        maxCostField = new TextField();
        warehouseComboBox = new ComboBox<>();

        // Set up initial values for instrument types and warehouses
        setInitialValues();

        instrumentTypeComboBox.setOnAction(event -> updateBrandComboBox());

        Button searchButton = new Button("Search");
        searchButton.setOnAction(event -> sendSearchRequest());

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(
                new Label("Instrument Type:"),
                instrumentTypeComboBox,
                new Label("Brand:"),
                brandComboBox,
                new Label("Max Cost:"),
                maxCostField,
                new Label("Warehouse:"),
                warehouseComboBox,
                searchButton
        );

        Scene scene = new Scene(vBox, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setInitialValues() {
        // Set initial values for instrument types and warehouses
        ObservableList<String> instrumentTypes = FXCollections.observableArrayList("all", "guitar", "bass", "drums", "keyboard");
        ObservableList<String> warehouses = FXCollections.observableArrayList("PNS", "CLT", "DFW");

        instrumentTypeComboBox.setItems(instrumentTypes);
        warehouseComboBox.setItems(warehouses);

        // Trigger the initial update of the brandComboBox
        updateBrandComboBox();
    }

    private void updateBrandComboBox() {
        // Implement logic to update brandComboBox based on the selected instrument type
        // For simplicity, I'm providing a static example
        String selectedType = instrumentTypeComboBox.getValue();
        ObservableList<String> brands;

        switch (selectedType) {
            case "guitar":
                brands = FXCollections.observableArrayList("all", "Gibson", "Fender");
                break;
            case "bass":
                brands = FXCollections.observableArrayList("all", "Fender", "Ibanez");
                break;
            case "drums":
                brands = FXCollections.observableArrayList("all", "Ludwig", "Yamaha");
                break;
            case "keyboard":
                brands = FXCollections.observableArrayList("all", "Roland", "Alesis");
                break;
            default:
                brands = FXCollections.observableArrayList("all");
        }

        brandComboBox.setItems(brands);
    }

    private void sendSearchRequest() {
        // Get the selected values from the UI components
        String instrumentType = instrumentTypeComboBox.getValue();
        String brand = brandComboBox.getValue();
        String maxCost = maxCostField.getText();
        String warehouse = warehouseComboBox.getValue();

        // TODO: Send these values to the controller for further processing
        System.out.println("Instrument Type: " + instrumentType);
        System.out.println("Brand: " + brand);
        System.out.println("Max Cost: " + maxCost);
        System.out.println("Warehouse: " + warehouse);

        // For the assignment, you would send these values to the controller
        // The controller will communicate with the model and return the results
    }
}
