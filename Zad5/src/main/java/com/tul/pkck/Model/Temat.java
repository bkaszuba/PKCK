package com.tul.pkck.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Temat {

    @XmlValue
    private String temat;

    public Temat(String temat) {
        this.temat = temat;
    }

    public Temat() {
    }
}
