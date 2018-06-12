package com.tul.pkck.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Marka {

    @XmlAttribute
    private String idAuta;

    @XmlValue
    private String marka;

    public String getIdAuta() {
        return idAuta;
    }

    public String getMarka() {
        return marka;
    }
}
