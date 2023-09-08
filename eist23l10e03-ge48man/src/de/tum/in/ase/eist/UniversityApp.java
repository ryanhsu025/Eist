package de.tum.in.ase.eist;

import com.sun.glass.ui.Window;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.config.Configurator;

import javax.security.auth.login.Configuration;

public class UniversityApp extends Application {
  
	private static final String TITLE = "University App";
	private static final int SCENE_WIDTH = 300;
	private static final int SCENE_HEIGHT = 250;
  	// TODO 4.1: Initialize the Logger


	@Override
	public void start(Stage primaryStage) {

		StackPane stackPane = new StackPane();
		Scene scene = new Scene(stackPane, SCENE_WIDTH, SCENE_HEIGHT);

		Button button = new Button();
		button.setText(getButtonText());
		button.setOnAction(event -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(TITLE);
			alert.setContentText(button.getText());
			alert.showAndWait();
		});

		stackPane.getChildren().add(button);

		primaryStage.setTitle(TITLE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	public String getButtonText() {
		// TODO 1: Fix the returned String
		return "EIST";
	}

	public static void startApp(String[] args) {
		Configurator.setRootLevel(org.apache.logging.log4j.Level.INFO);
		org.apache.logging.log4j.Logger logger=LogManager.getLogger(UniversityApp.class);
		logger.info(args);
		// TODO 4.2: Log the start of the app at the info level
		launch(args);
	}
}
