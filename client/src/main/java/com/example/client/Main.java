package com.example.client;

import com.google.inject.Guice;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static final String APP_TITLE = "PW PAMIW Lab";
    private static final int APP_WIDTH = 320;
    private static final int APP_HEIGHT = 240;
    private static final String APP_VIEW_FXML = "app-view.fxml";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        final var scene = createScene();
        stage.setTitle(APP_TITLE);
        stage.setScene(scene);
        stage.show();
    }

    private Scene createScene() throws IOException {
        final var appViewResource = Main.class.getResource(APP_VIEW_FXML);
        final var fxmlLoader = new FXMLLoader(appViewResource);
        configureDependencyInjection(fxmlLoader);
        return new Scene(fxmlLoader.load(), APP_WIDTH, APP_HEIGHT);
    }

    private void configureDependencyInjection(FXMLLoader fxmlLoader) {
        final var appModule = new AppModule();
        final var injector = Guice.createInjector(appModule);
        fxmlLoader.setControllerFactory(injector::getInstance);
    }

}