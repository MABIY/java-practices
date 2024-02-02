package org.example.endpoints.object_to_xml;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "Identification_List")
@XmlAccessorType(XmlAccessType.FIELD)
public class IdentificationList {

    @XmlAttribute
    private int counter;

    @XmlElement(name = "Identification")
    private List<Identification> identifications;

    public int getCounter() {
        return counter;
    }

    public IdentificationList setCounter(int counter) {
        this.counter = counter;
        return this;
    }

    public List<Identification> getIdentifications() {
        return identifications;
    }

    public IdentificationList setIdentifications(List<Identification> identifications) {
        this.identifications = identifications;
        return this;
    }
}