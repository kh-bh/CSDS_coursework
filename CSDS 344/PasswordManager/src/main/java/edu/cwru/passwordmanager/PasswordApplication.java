package edu.cwru.passwordmanager;

import atlantafx.base.theme.PrimerLight;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PasswordApplication extends Application {
    // Give your app a name!
    final private String applicationName = "Bhoomika's Password Vault";
    static Stage primaryStage = null;
    @Override
    public void start(Stage stage) throws IOException {
        // Select Preferred
        Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());

        FXMLLoader fxmlLoader = new FXMLLoader(PasswordApplication.class.getResource("initial-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle(applicationName);
        stage.setScene(scene);
        primaryStage = stage;
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}