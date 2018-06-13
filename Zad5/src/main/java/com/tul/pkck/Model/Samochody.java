package com.tul.pkck.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by Kaszuba on 12.06.2018.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Samochody {
    @XmlElement(name="samochód")
    private List<Samochod> samochody;

    public List<Samochod> getSamochody() {
        return samochody;
    }
}
