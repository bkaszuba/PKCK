package com.tul.pkck.Controller;

import com.tul.pkck.Model.Marka;
import com.tul.pkck.Model.Salon;
import com.tul.pkck.Model.Samochod;
import com.tul.pkck.Parser.XMLParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
import java.util.stream.Collectors;

public class ButtonsController implements Initializable {

    XMLParser xmlParser;
    @FXML
    TextArea xmlTextArea;
    @FXML
    ComboBox<String> comboBox;
    @FXML
    ComboBox<String> comboMarki;
    @FXML
    TextField model;
    @FXML
    TextField silnik;
    @FXML
    TextField dataProd;
    @FXML
    TextField cena;
    @FXML
    TextField przebieg;
    @FXML
    TextField dataOstat;
    @FXML
    TextField opis;
    @FXML
    TextField nowy;
    @FXML
    TextField imieWla;
    @FXML
    TextField nazWla;
    @FXML
    TextField nrWla;

    Salon salon;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        xmlParser = new XMLParser();
    }

    public void loadXML(ActionEvent actionEvent) throws JAXBException {
        xmlParser.loadXML("");
        salon = xmlParser.getSalon();
        comboBox.setItems(getObservableWtihIds(salon));
        comboMarki.setItems(getObservableWtihMarki(salon));
    }

    public void showCarInfo(ActionEvent actionEvent) {
        Samochod samochod = salon.getSamochody().getSamochody().stream().filter(id -> id.getId().equals(comboBox.getValue())).findFirst().get();
        comboMarki.setValue(samochod.getIdRef());
        model.setText(samochod.getModel());
        silnik.setText(String.valueOf(samochod.getSilnik()));
        dataProd.setText(String.valueOf(samochod.getDataProdukcji()));
        cena.setText(String.valueOf(samochod.getCena().getCena()));
        przebieg.setText(String.valueOf(samochod.getPrzebieg().getPrzebieg()));
        dataOstat.setText(samochod.getDataOstatniegoWłaściciela());
        opis.setText(samochod.getOpis());
        nowy.setText(samochod.getJestNowy());
        imieWla.setText(samochod.getDaneWłaściciela().getImie());
        nazWla.setText(samochod.getDaneWłaściciela().getNazwisko());
        nrWla.setText(samochod.getDaneWłaściciela().getNrTelefonu());
    }

    public void saveCarInfo(ActionEvent actionEvent) {
        Samochod samochod = salon.getSamochody().getSamochody().stream().filter(id -> id.getId().equals(comboBox.getValue())).findFirst().get();


    }


    public void chooseFile(ActionEvent actionEvent) throws JAXBException, ParserConfigurationException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File selectedFile = fileChooser.showOpenDialog(null);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        if (selectedFile != null) {
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
        List<String> id =
                salon.getSamochody().getSamochody().stream()
                        .map(Samochod::getId)
                        .collect(Collectors.toList());
        return FXCollections.observableArrayList(id);
    }

    private ObservableList<String> getObservableWtihMarki(Salon salon) {
        List<String> allMarki =
                salon.getMarki().getMarki().stream()
                        .map(Marka::getMarka)
                        .collect(Collectors.toList());
        return FXCollections.observableArrayList(allMarki);
    }

}
