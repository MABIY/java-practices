package org.example.endpoints.object_to_xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class IdentificationToXML {
    private IdentificationToXML() {
    }

    public static void test() throws  Exception {


        JAXBContext contextObj = JAXBContext.newInstance(IdentificationList.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Travel travel1=new Travel("My First Travel");
        Travel travel2=new Travel("My Second Travel");


        Travel travel3=new Travel("My Third Travel");
        Travel travel4=new Travel("My Fourth Travel");


        ArrayList<Travel> list=new ArrayList<>();
        list.add(travel1);
        list.add(travel2);



        ArrayList<Travel> list2=new ArrayList<>();
        list2.add(travel3);
        list2.add(travel4);

        Identification identification1=new Identification(111,'c',"My Name",list);
        Identification identification2=new Identification(222,'d',"My Name",list2);
        ArrayList<Identification> list3=new ArrayList<>();
        list3.add(identification1);
        list3.add(identification2);
        IdentificationList identification=new IdentificationList();
        identification.setCounter(1);
        identification.setIdentifications(list3);

        marshallerObj.marshal(identification, new FileOutputStream("identification.xml"));
    }
}