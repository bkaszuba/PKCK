package com.tul.pkck.Controller;

import com.tul.pkck.Model.Salon;
import com.tul.pkck.Model.Samochod;
import com.tul.pkck.Parser.XMLParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ButtonsController implements Initializable {

    XMLParser xmlParser;
    @FXML
    TextArea xmlTextArea;
    @FXML
    ComboBox<String> comboBox;
    ObservableList<String> ids;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        xmlParser = new XMLParser();
    }

    public void loadXML(ActionEvent actionEvent) throws JAXBException {
        xmlTextArea.setText(xmlParser.loadXML(""));
        Salon salon = xmlParser.getSalon();
        comboBox.setItems(getObservableWtihIds(salon));
    }



    public void chooseFile(ActionEvent actionEvent) throws JAXBException, ParserConfigurationException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File selectedFile = fileChooser.showOpenDialog(null);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        if(selectedFile != null) {
            try {
                builder.parse(new InputSource(selectedFile.getAbsolutePath()));
                xmlTextArea.setText(xmlParser.loadXML(selectedFile.getAbsolutePath()));
            } catch (SAXException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Load XML file", ButtonType.OK);
                alert.showAndWait();
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Load XML file", ButtonType.OK);
                alert.showAndWait();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "No file chosen", ButtonType.OK);
            alert.showAndWait();
        }
    }

    private ObservableList<String> getObservableWtihIds(Salon salon) {
        List<String> id = new ArrayList<>();
        for (Samochod samochod: salon.getSamochody().getSamochody()) {
            id.add(samochod.getId());
        }
        ids = FXCollections.observableArrayList(id);
        return ids;
    }

}
