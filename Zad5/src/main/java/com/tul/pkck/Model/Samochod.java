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

    public Samochod() {
        this.cena = new Cena();
        this.przebieg = new Przebieg();
        this.daneWłaściciela = new DaneWłaściciela();
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class DaneWłaściciela {
        @XmlAttribute
        private String imie;
        @XmlAttribute
        private String nazwisko;
        @XmlAttribute
        private String nrTelefonu;

        public String getImie() {
            return imie;
        }

        public String getNazwisko() {
            return nazwisko;
        }

        public String getNrTelefonu() {
            return nrTelefonu;
        }

        public void setImie(String imie) {
            this.imie = imie;
        }

        public void setNazwisko(String nazwisko) {
            this.nazwisko = nazwisko;
        }

        public void setNrTelefonu(String nrTelefonu) {
            this.nrTelefonu = nrTelefonu;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Cena {
        @XmlAttribute
        private String waluta;
        @XmlValue
        private   String cena;

        public String getWaluta() {
            return waluta;
        }

        public String getCena() {
            return cena;
        }

        public void setWaluta(String waluta) {
            this.waluta = waluta;
        }

        public void setCena(String cena) {
            this.cena = cena;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Przebieg {
        @XmlAttribute
        private String jednostka;
        @XmlValue
        private String przebieg;

        public String getJednostka() {
            return jednostka;
        }

        public String getPrzebieg() {
            return przebieg;
        }

        public void setJednostka(String jednostka) {
            this.jednostka = jednostka;
        }

        public void setPrzebieg(String przebieg) {
            this.przebieg = przebieg;
        }
    }

    public String getId() {
        return id;
    }

    public String getIdRef() {
        return idRef;
    }

    public String getModel() {
        return model;
    }

    public double getSilnik() {
        return silnik;
    }

    public Cena getCena() {
        return cena;
    }

    public int getDataProdukcji() {
        return dataProdukcji;
    }

    public String getJednostka() {
        return jednostka;
    }

    public Przebieg getPrzebieg() {
        return przebieg;
    }

    public String getDataOstatniegoWłaściciela() {
        return dataOstatniegoWłaściciela;
    }

    public DaneWłaściciela getDaneWłaściciela() {
        return daneWłaściciela;
    }

    public String getOpis() {
        return opis;
    }

    public String getJestNowy() {
        return jestNowy;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdRef(String idRef) {
        this.idRef = idRef;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSilnik(double silnik) {
        this.silnik = silnik;
    }

    public void setCena(Cena cena) {
        this.cena = cena;
    }

    public void setDataProdukcji(int dataProdukcji) {
        this.dataProdukcji = dataProdukcji;
    }

    public void setJednostka(String jednostka) {
        this.jednostka = jednostka;
    }

    public void setPrzebieg(Przebieg przebieg) {
        this.przebieg = przebieg;
    }

    public void setDataOstatniegoWłaściciela(String dataOstatniegoWłaściciela) {
        this.dataOstatniegoWłaściciela = dataOstatniegoWłaściciela;
    }

    public void setDaneWłaściciela(DaneWłaściciela daneWłaściciela) {
        this.daneWłaściciela = daneWłaściciela;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setJestNowy(String jestNowy) {
        this.jestNowy = jestNowy;
    }
}
