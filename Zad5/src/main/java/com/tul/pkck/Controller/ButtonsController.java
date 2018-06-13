package com.tul.pkck.Controller;

import com.tul.pkck.Model.Marka;
import com.tul.pkck.Model.Salon;
import com.tul.pkck.Model.Samochod;
import com.tul.pkck.Parser.XMLParser;
import javafx.beans.property.SimpleStringProperty;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;

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
    ComboBox<String> comboNowy;
    @FXML
    TextField imieWla;
    @FXML
    TextField nazWla;
    @FXML
    TextField nrWla;
    @FXML
    TextField nowaMarka;
    @FXML
    TableView<Samochod> tableView = new TableView<>();

    Salon salon;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        xmlParser = new XMLParser();
    }

    public void loadXML(ActionEvent actionEvent){
        try {
            xmlParser.loadXML("");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Wczytano pomyślnie", ButtonType.OK);
            alert.showAndWait();
        } catch (JAXBException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Błąd przy konwersji", ButtonType.OK);
            alert.showAndWait();
        }
        salon = xmlParser.getSalon();
        comboBox.setItems(getObservableWtihIds(salon));
        comboMarki.setItems(getObservableWtihMarki(salon));
        comboNowy.getItems().addAll("Tak", "Nie");
        fillTableView();
    }

    public void saveToXML(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile != null) {
            try {
                xmlParser.saveToXML(selectedFile.getAbsolutePath());
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Zapisano pomyślnie", ButtonType.OK);
                alert.showAndWait();
            } catch (JAXBException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Bład przy konwersji", ButtonType.OK);
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Nie wybrano pliku", ButtonType.OK);
            alert.showAndWait();
        }

    }

    public void showCarInfo(ActionEvent actionEvent) {
        Samochod samochod = salon.getSamochody().getSamochody().stream().filter(id -> id.getId().equals(comboBox.getValue())).findFirst().get();
        comboMarki.setValue(samochod.getIdRef());
        model.setText(samochod.getModel());
        silnik.setText(valueOf(samochod.getSilnik()));
        dataProd.setText(valueOf(samochod.getDataProdukcji()));
        cena.setText(valueOf(samochod.getCena().getCena()));
        przebieg.setText(valueOf(samochod.getPrzebieg().getPrzebieg()));
        dataOstat.setText(samochod.getDataOstatniegoWłaściciela());
        opis.setText(samochod.getOpis());
        comboNowy.setValue(samochod.getJestNowy());
        imieWla.setText(samochod.getDaneWłaściciela().getImie());
        nazWla.setText(samochod.getDaneWłaściciela().getNazwisko());
        nrWla.setText(samochod.getDaneWłaściciela().getNrTelefonu());
    }

    public void saveCarInfo(ActionEvent actionEvent) {
        Samochod samochod = salon.getSamochody().getSamochody().stream().filter(id -> id.getId().equals(comboBox.getValue())).findFirst().get();
        if(isValidDate(dataOstat.getText())) {
            samochod.setIdRef(comboMarki.getValue());
            samochod.setModel(model.getText());
            samochod.setSilnik(Double.parseDouble(silnik.getText()));
            samochod.setDataProdukcji(Integer.parseInt(dataProd.getText()));
            samochod.getCena().setCena(cena.getText());
            samochod.getPrzebieg().setPrzebieg(przebieg.getText());
            samochod.setDataOstatniegoWłaściciela(dataOstat.getText());
            samochod.setOpis(opis.getText());
            samochod.setJestNowy(comboNowy.getValue());
            samochod.getDaneWłaściciela().setImie(imieWla.getText());
            samochod.getDaneWłaściciela().setNazwisko(nazWla.getText());
            samochod.getDaneWłaściciela().setNrTelefonu(nrWla.getText());
            tableView.refresh();
        }
    }

    public void addCar(ActionEvent actionEvent) {
        Samochod samochod = new Samochod();
        if(isValidDate(dataOstat.getText())) {
            samochod.setIdRef(comboMarki.getValue());
            samochod.setModel(model.getText());
            samochod.setSilnik(Double.parseDouble(silnik.getText()));
            samochod.setDataProdukcji(Integer.parseInt(dataProd.getText()));
            samochod.getCena().setCena(cena.getText());
            samochod.getCena().setWaluta("PLN");
            samochod.getPrzebieg().setPrzebieg(przebieg.getText());
            samochod.getPrzebieg().setJednostka("km");
            samochod.setDataOstatniegoWłaściciela(dataOstat.getText());
            samochod.setOpis(opis.getText());
            samochod.setJestNowy(comboNowy.getValue());
            samochod.getDaneWłaściciela().setImie(imieWla.getText());
            samochod.getDaneWłaściciela().setNazwisko(nazWla.getText());
            samochod.getDaneWłaściciela().setNrTelefonu(nrWla.getText());
            samochod.setId(generateCarId(samochod));
            salon.getSamochody().getSamochody().add(samochod);
            tableView.getItems().clear();
            fillTableView();
            comboBox.setItems(getObservableWtihIds(salon));
        }
    }

    public void deleteCar(ActionEvent actionEvent) {
        int index = 0;
        for (int i = 0; i < salon.getSamochody().getSamochody().size(); i++) {
            if(salon.getSamochody().getSamochody().get(i).getId().equals(comboBox.getValue())) {
                index = i;
            }
        }
        comboMarki.setValue("");
        model.setText("");
        silnik.setText("");
        dataProd.setText("");
        cena.setText("");
        przebieg.setText("");
        dataOstat.setText("");
        opis.setText("");
        comboNowy.setValue("");
        imieWla.setText("");
        nazWla.setText("");
        nrWla.setText("");
        salon.getSamochody().getSamochody().remove(index);
        tableView.getItems().clear();
        fillTableView();
        comboBox.getItems().clear();
        comboBox.setItems(getObservableWtihIds(salon));
    }

    public void addMarka(ActionEvent actionEvent) {
        String nazwa = nowaMarka.getText();
        Marka marka = new Marka();
        if(checkIfMarkaExists(nazwa)) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Ta marka istnieje", ButtonType.OK);
            alert.showAndWait();
        } else {
            marka.setIdAuta(nazwa);
            marka.setMarka(nazwa);
            salon.getMarki().getMarki().add(marka);
            comboMarki.setItems(getObservableWtihMarki(salon));
        }

    }

    private boolean checkIfMarkaExists(String nazwa) {
        Boolean exists = false;
        for (Marka marka: salon.getMarki().getMarki()) {
            if(marka.getIdAuta().equals(nazwa)) {
                exists = true;
            }
        }
        return exists;
    }

    private void fillTableView() {
        tableView.getItems().addAll(salon.getSamochody().getSamochody());
        TableColumn<Samochod, String> id = new TableColumn<>();
        id.setText("ID");
        id.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getId()));
        TableColumn<Samochod, String> marka = new TableColumn<>();
        marka.setText("Marka");
        marka.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getIdRef()));
        TableColumn<Samochod, String> model = new TableColumn<>();
        model.setText("Model");
        model.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getModel()));
        TableColumn<Samochod, String> silnik = new TableColumn<>();
        silnik.setText("Silnik");
        silnik.setCellValueFactory(c -> new SimpleStringProperty(valueOf(c.getValue().getSilnik())));
        TableColumn<Samochod, String> dataProd = new TableColumn<>();
        dataProd.setText("Data produkcji");
        dataProd.setCellValueFactory(c -> new SimpleStringProperty(valueOf(c.getValue().getDataProdukcji())));
        TableColumn<Samochod, String> cena = new TableColumn<>();
        cena.setText("Cena");
        cena.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCena().getCena() + c.getValue().getCena().getWaluta()));
        TableColumn<Samochod, String> przebieg = new TableColumn<>();
        przebieg.setText("Przebieg");
        przebieg.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPrzebieg().getPrzebieg() + c.getValue().getPrzebieg().getJednostka()));
        TableColumn<Samochod, String> dataOstWla = new TableColumn<>();
        dataOstWla.setText("Data ostatniego właściciela");
        dataOstWla.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDataOstatniegoWłaściciela()));
        TableColumn<Samochod, String> nowy = new TableColumn<>();
        nowy.setText("Czy jest nowy?");
        nowy.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getJestNowy()));
        TableColumn<Samochod, String> imeWl = new TableColumn<>();
        imeWl.setText("Imię byłego właściciela");
        imeWl.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDaneWłaściciela().getImie()));
        TableColumn<Samochod, String> nazwWl = new TableColumn<>();
        nazwWl.setText("Nazwisko byłego właściciela");
        nazwWl.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDaneWłaściciela().getNazwisko()));
        TableColumn<Samochod, String> nrWl = new TableColumn<>();
        nrWl.setText("Numer byłego właściciela");
        nrWl.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDaneWłaściciela().getNrTelefonu()));
        tableView.getColumns().addAll(id, marka, model, silnik, dataProd, cena, przebieg, dataOstWla, nowy, imeWl, nazwWl, nrWl);
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

    private String generateCarId(Samochod samochod) {
        String marka = samochod.getIdRef();
        String model = samochod.getModel();
        StringBuilder idBuilder = new StringBuilder();
        idBuilder.append(marka.substring(0, 1));
        idBuilder.append(model.substring(0, 1));
        int index = 1;
        idBuilder.append(index);
        do {
            idBuilder.deleteCharAt(idBuilder.length()-1);
            idBuilder.append(index);
            index++;
        } while(checkIfIdExists(idBuilder.toString()));
        return idBuilder.toString();
    }

    private boolean checkIfIdExists(String id) {
        //return salon.getSamochody().getSamochody().stream().anyMatch(t -> t.getId().equals(id));
        Boolean idExists = false;
        for (Samochod samochod: salon.getSamochody().getSamochody()) {
            if(samochod.getId().equals(id))
                idExists = true;
        }
        return idExists;
    }

    public boolean isValidDate(String dateString) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            df.parse(dateString);
            return true;
        } catch (ParseException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Zły format daty (YYYY-MM-DD to prawidłowy)", ButtonType.OK);
            alert.showAndWait();
            return false;
        }
    }

}
