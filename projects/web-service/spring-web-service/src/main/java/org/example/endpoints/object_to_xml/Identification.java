package org.example.endpoints.object_to_xml;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Identification {

    @XmlAttribute
    private int number;

    @XmlAttribute
    private char letter;

    @XmlAttribute
    private String name;

    @XmlElementWrapper(name = "TravelList")
    @XmlElement(name = "Travel")
    private List<Travel> travels;

    // getters and setters

    public int getNumber() {
        return number;
    }

    public Identification setNumber(int number) {
        this.number = number;
        return this;
    }

    public Identification(int number, char letter, String name, List<Travel> travels) {
        this.number = number;
        this.letter = letter;
        this.name = name;
        this.travels = travels;
    }
}