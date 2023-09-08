package de.tum.in.ase.eist.view;

import de.tum.in.ase.eist.L10PB01ClientApplication;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class HomeScene extends Scene {
    public HomeScene(L10PB01ClientApplication application) {
        super(new VBox(), 640, 500);

        var personButton = new Button("Persons");
        personButton.setOnAction(event -> application.showPersonScene());

        var vBox = new VBox(10, personButton);
        vBox.setAlignment(Pos.CENTER);
        setRoot(vBox);
    }
}
