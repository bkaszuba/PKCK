package com.tul.pkck.Model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Samochod {

    @XmlAttribute
    private String id;
    @XmlAttribute(name = "idref")
    private String idRef;
    private String model;
    private double silnik;
    @XmlElement(name="cena")
    private Cena cena;
    private int dataProdukcji;
    @XmlAttribute
    private String jednostka;
    @XmlElement(name="przebieg")
    private Przebieg przebieg;
    private String dataOstatniegoWłaściciela;
    @XmlElement(name="daneOstatniegoWłaściciela")
    private DaneWłaściciela daneWłaściciela;
    private String opis;
    private String jestNowy;

    @XmlAccessorType(XmlAccessType.FIELD)
    static class DaneWłaściciela {
        @XmlAttribute
        private String imie;
        @XmlAttribute
        private String nazwisko;
        @XmlAttribute
        private String nrTelefonu;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    static class Cena {
        @XmlAttribute
        private String waluta;
        @XmlValue
        private String cena;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    static class Przebieg {
        @XmlAttribute
        private String jednostka;
        @XmlValue
        private String przebieg;
    }
}
