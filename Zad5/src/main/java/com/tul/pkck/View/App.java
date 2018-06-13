package com.tul.pkck.View;

import com.tul.pkck.Model.Salon;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javax.xml.bind.JAXBException;

public class App extends Application
{
    private static final String FMXL_PATH = "application.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(FMXL_PATH));
        primaryStage.setTitle("XML in practice");
        primaryStage.setScene(new Scene(root, 900, 700));
        primaryStage.show();
    }

    public static void main(String[] args)  throws JAXBException {
        launch(args);

    }


}
