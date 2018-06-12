package com.tul.pkck.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Autorzy{
    @XmlElement(name="autor")
    private List<Autor> autorzy;

    public List<Autor> getAutorzy() {
        return autorzy;
    }
}
