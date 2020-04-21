package U8_T3_UsoStax;

import u8_t2_ModArbolDOMsaveFichXML.Animal;
import u8_t2_ModArbolDOMsaveFichXML.Persona;
import u8_t2_ModArbolDOMsaveFichXML.ReinoAnimal;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MostrarStax {
    public static void main(String[] args) {

        //Creo una lista para introducir los datos del fichero XMl
        List<ReinoAnimal> animals = new ArrayList<>();

        ReinoAnimal objetoTagActual = null;
        String tagActual = "";

        try {

            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream("U8_T1_ficheroXML.xml"));

            while (xmlEventReader.hasNext()) {

                XMLEvent xmlEvent = xmlEventReader.nextEvent();

                //Las posibilidades de tipos de eventos que puedo encontrar
                if (xmlEvent.isStartDocument()) {
                    System.out.println("Comienzo del parseado del documento");
                    System.out.println();

                } else if (xmlEvent.isEndDocument()) {
                    System.out.println("Fin del pardeado del documento");
                    System.out.println();

                } else if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    //Guardo el nombre del evento para ver que hacer en cada caso
                    String tagName = startElement.getName().getLocalPart();
                    if(tagName.equals("raza") || tagName.equals("nombre") || tagName.equals("edad")) {
                        System.out.print("\t");
                    }
                    System.out.print("<" + startElement.getName().getLocalPart());


                    switch (tagName) {
                        case "animales":
                            System.out.println(">");
                            break;
                        case "animal":
                            objetoTagActual = new Animal();
                            tagActual = "animal";
                        case "persona":
                            if (objetoTagActual == null) {
                                objetoTagActual = new Persona();
                            }
                            if (tagActual == null) {
                                tagActual = "persona";
                            }

                            Attribute id = startElement.getAttributeByName(new QName("id"));
                            objetoTagActual.setId(Integer.valueOf(id.getValue()));
                            System.out.println(" " + id.getName() + "=\"" + id.getValue() + "\"" + ">");
                            break;

                        case "raza":
                            tagActual = "raza";
                            System.out.print(">");
                            break;

                        case "nombre":
                            tagActual = "nombre";
                            System.out.print(">");
                            break;

                        case "edad":
                            tagActual = "edad";

                            Attribute unidad = startElement.getAttributeByName(new QName("unidad"));

                            objetoTagActual.setUnidad(unidad.getValue());
                            System.out.print(" " + unidad.getName() + "=\"" + unidad.getValue() + "\"" + ">" );
                            break;
                    }

                    //Cierro las etiquetas de apertura
                   // System.out.print(">");

                } else if (xmlEvent.isEndElement()) {
                    EndElement endTag = xmlEvent.asEndElement();
                    System.out.println("<\\" + endTag.getName().getLocalPart() + ">");

                    //Si tengo el cierre del objeto
                    if (endTag.getName().getLocalPart().equals("animal") ||
                            (endTag.getName().getLocalPart().equals("persona"))) {
                        animals.add(objetoTagActual);
                        objetoTagActual = null;
                    }

                    //Vuelvo a poner a null la etiq actual
                    tagActual = "";


                } else if (xmlEvent.isCharacters()) {
                    //Creo nodo de texto
                    Characters texto = xmlEvent.asCharacters();

                    //Si no es salto de línea
                    if (!texto.getData().contains("\n")) {
                        System.out.print(texto.getData());
                    }

                    //Añado el texto al objeto actual
                    if (!tagActual.equals("")) {
                        switch (tagActual) {
                            case "raza":
                                ((Animal) objetoTagActual).setRaza(texto.getData());
                                break;

                            case "nombre":
                                objetoTagActual.setNombre(texto.getData());
                                break;

                            case "edad":
                                objetoTagActual.setEdad(Integer.valueOf(texto.getData()));
                                break;
                        }
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            System.out.println(e.getMessage());
        }

        //Muestro el contenido del array
        System.out.println(animals);
    }
}
