package com.tul.pkck.Model;


import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="salon")
@XmlAccessorType(XmlAccessType.FIELD)
public class Salon {
    @XmlElement(name="opis")
    private Opis opis;

    @XmlElement(name="marki")
    private Marki marki;

    @XmlElement(name = "samochody")
    private Samochody samochody;

    public Opis getOpis() {
        return opis;
    }

    public Marki getMarki() {
        return marki;
    }

    public Samochody getSamochody() {
        return samochody;
    }
}

