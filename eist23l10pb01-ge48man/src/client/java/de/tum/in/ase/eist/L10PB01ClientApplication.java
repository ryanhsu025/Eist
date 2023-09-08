package de.tum.in.ase.eist;

import de.tum.in.ase.eist.controller.CustomerController;
import de.tum.in.ase.eist.view.HomeScene;
import de.tum.in.ase.eist.view.CustomerScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class L10PB01ClientApplication extends Application {
    private final CustomerController customerController = new CustomerController();
    private Stage stage;

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;

        primaryStage.setScene(new HomeScene(this));
        primaryStage.show();
    }

    public void showHomeScene() {
        stage.setScene(new HomeScene(this));
    }

    public void showPersonScene() {
        stage.setScene(new CustomerScene(customerController, this));
    }

    public Stage getStage() {
        return stage;
    }
}
