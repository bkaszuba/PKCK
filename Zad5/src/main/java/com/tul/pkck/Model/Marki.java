package com.tul.pkck.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
public class Marki {
    @XmlElement(name="marka")
    private List<Marka> marki;

    public List<Marka> getMarki() {
        return marki;
    }
}
