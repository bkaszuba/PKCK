package com.tul.pkck.Controller;

import com.tul.pkck.Model.Salon;
import com.tul.pkck.Parser.XMLParser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ButtonsController {

    XMLParser xmlParser = new XMLParser();
    @FXML
    TextArea xmlTextArea = new TextArea();

    public void loadXML(ActionEvent actionEvent) throws JAXBException {
        xmlTextArea.setText(xmlParser.loadXML(""));
        Salon salon = xmlParser.getSalon();
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
}
