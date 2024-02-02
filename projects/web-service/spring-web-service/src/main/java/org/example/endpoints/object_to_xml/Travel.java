package org.example.endpoints.object_to_xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Travel {

    @XmlAttribute
    private String travelType;

    public String getTravelType() {
        return travelType;
    }

    public Travel setTravelType(String travelType) {
        this.travelType = travelType;
        return this;
    }

    public Travel(String travelType) {
        this.travelType = travelType;
    }
}