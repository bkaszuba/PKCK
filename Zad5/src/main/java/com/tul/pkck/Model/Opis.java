package com.tul.pkck.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Opis {
    @XmlElement(name="temat")
    private Temat temat;

    @XmlElement(name="autorzy")
    private Autorzy autorzy;

    public Temat getTemat() {
        return temat;
    }

    public Autorzy getAutorzy() {
        return autorzy;
    }
}
