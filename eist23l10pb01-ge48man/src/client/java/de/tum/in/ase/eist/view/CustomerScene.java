package de.tum.in.ase.eist.view;

import de.tum.in.ase.eist.L10PB01ClientApplication;
import de.tum.in.ase.eist.controller.CustomerController;
import de.tum.in.ase.eist.model.Customer;
import de.tum.in.ase.eist.util.CustomerSortingOptions;
import de.tum.in.ase.eist.util.CustomerSortingOptions.SortField;
import de.tum.in.ase.eist.util.CustomerSortingOptions.SortingOrder;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Popup;

import java.time.LocalDate;
import java.util.List;

public class CustomerScene extends Scene {
    private final CustomerController customerController;
    private final L10PB01ClientApplication application;
    private final CustomerSortingOptions sortingOptions;
    private final ObservableList<Customer> customerList;
    private final TableView<Customer> table;

    public CustomerScene(CustomerController customerController, L10PB01ClientApplication application) {
        super(new VBox(), 640, 500);
        this.customerController = customerController;
        this.application = application;
        this.sortingOptions = new CustomerSortingOptions();
        this.customerList = FXCollections.observableArrayList();

        table = new TableView<>(customerList);
        table.setOnMousePressed(event -> {
            if (event.isPrimaryButtonDown()) {
                showPopup(table.getSelectionModel().getSelectedItem());
            }
        });

        var idColumn = new TableColumn<Customer, String>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.setSortable(false);
        idColumn.setPrefWidth(620 / 4D);
        var firstNameColumn = new TableColumn<Customer, String>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameColumn.setSortable(false);
        firstNameColumn.setPrefWidth(620 / 4D);
        var lastNameColumn = new TableColumn<Customer, String>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameColumn.setSortable(false);
        lastNameColumn.setPrefWidth(620 / 4D);
        var birthdayColumn = new TableColumn<Customer, String>("Birthday");
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        birthdayColumn.setSortable(false);
        birthdayColumn.setPrefWidth(620 / 4D);
        //noinspection unchecked
        table.getColumns().addAll(idColumn, firstNameColumn, lastNameColumn, birthdayColumn);

        var vBox = new VBox(10, createSortOptionBox(), table, createButtonBox());
        vBox.setAlignment(Pos.CENTER);
        setRoot(vBox);

        customerController.getAllPersons(sortingOptions, this::setPeople);
    }

    private HBox createSortOptionBox() {
        var sortFieldChoiceBox = new ChoiceBox<SortField>();
        sortFieldChoiceBox.getItems().addAll(SortField.values());
        sortFieldChoiceBox.setValue(sortingOptions.getSortField());
        sortFieldChoiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            sortingOptions.setSortField(newValue);
            customerController.getAllPersons(sortingOptions, this::setPeople);
        });

        var sortingOrderChoiceBox = new ChoiceBox<SortingOrder>();
        sortingOrderChoiceBox.getItems().addAll(SortingOrder.values());
        sortingOrderChoiceBox.setValue(sortingOptions.getSortingOrder());
        sortingOrderChoiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            sortingOptions.setSortingOrder(newValue);
            customerController.getAllPersons(sortingOptions, this::setPeople);
        });

        var hBox = new HBox(10, sortFieldChoiceBox, sortingOrderChoiceBox);
        hBox.setAlignment(Pos.CENTER);
        return hBox;
    }

    private HBox createButtonBox() {
        var backButton = new Button("Back");
        backButton.setOnAction(event -> application.showHomeScene());

        var addButton = new Button("Add Person");
        addButton.setOnAction(event -> showPopup(null));

        var refreshButton = new Button("Refresh");
        refreshButton.setOnAction(event -> customerController.getAllPersons(sortingOptions, this::setPeople));

        var buttonBox = new HBox(10, backButton, addButton, refreshButton);
        buttonBox.setAlignment(Pos.CENTER);
        return buttonBox;
    }

    private void showPopup(Customer customer) {
        var popup = new Popup();
        var firstNameTextField = new TextField();
        firstNameTextField.setPromptText("First Name");
        firstNameTextField.setText(customer == null ? "" : customer.getFirstName());

        var lastNameTextField = new TextField();
        lastNameTextField.setPromptText("Last Name");
        lastNameTextField.setText(customer == null ? "" : customer.getLastName());

        var birthdayPicker = new DatePicker();
        birthdayPicker.setValue(customer == null ? LocalDate.now() : customer.getBirthday());

        var addButton = new Button("Save");
        addButton.setOnAction(event -> {
            var newPerson = customer != null ? customer : new Customer();
            newPerson.setFirstName(firstNameTextField.getText());
            newPerson.setLastName(lastNameTextField.getText());
            newPerson.setBirthday(birthdayPicker.getValue());
            if (customer == null) {
                customerController.addPerson(newPerson, this::setPeople);
            } else {
                customerController.updatePerson(newPerson, this::setPeople);
            }
            popup.hide();
        });

        var cancelButton = new Button("Cancel");
        cancelButton.setOnAction(event -> popup.hide());

        var deleteButton = new Button("Delete");
        deleteButton.setTextFill(Color.RED);
        deleteButton.setOnAction(event -> {
            customerController.deletePerson(customer, this::setPeople);
            popup.hide();
        });

        var hBox = new HBox(10, addButton, cancelButton);
        hBox.setAlignment(Pos.CENTER);
        if (customer != null) {
            hBox.getChildren().add(deleteButton);
        }

        var vBox = new VBox(10, firstNameTextField, lastNameTextField, birthdayPicker, hBox);
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        vBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        vBox.setPrefWidth(200);
        vBox.setPrefHeight(150);
        vBox.setPadding(new Insets(5));
        popup.getContent().add(vBox);
        popup.show(application.getStage());
        popup.centerOnScreen();
    }

    private void setPeople(List<Customer> people) {
        Platform.runLater(() -> customerList.setAll(people));
    }
}
