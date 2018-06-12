package com.tul.pkck.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Autor {
    private String imię;
    private String nazwisko;
    private String nr_indeksu;

    public Autor(String imie, String nazwisko, String nr_indeksu) {
        this.imię = imie;
        this.nazwisko = nazwisko;
        this.nr_indeksu = nr_indeksu;
    }

    public Autor() {
    }

    public String getImię() {
        return imię;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getNr_indeksu() {
        return nr_indeksu;
    }
}
