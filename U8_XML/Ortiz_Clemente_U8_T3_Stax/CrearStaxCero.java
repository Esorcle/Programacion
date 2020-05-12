package U8_T3_UsoStax;

import u8_t2_ModArbolDOMsaveFichXML.Animal;
import u8_t2_ModArbolDOMsaveFichXML.Persona;
import u8_t2_ModArbolDOMsaveFichXML.ReinoAnimal;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CrearStaxCero {
    public static void main(String[] args) {

        List<ReinoAnimal> animals = new ArrayList<>();

        //Creo objetos y añado al array
        animals.add(new Animal(1, "Zoe", "Persa", 2, "año"));
        animals.add(new Animal(2, "Thais", "Labrador", 7, "año"));
        animals.add(new Animal(5, "Pelusa", null));
        animals.add(new Animal(6, "Pollito", "Pipi", 1, "mes"));
        animals.add(new Animal(7, "Babosa", ""));
        animals.add(new Persona(3, "Fany", 32, "año"));
        animals.add(new Persona(4, "Antonio", 37, "año"));
        animals.add(new Persona(8, "Esperanza", 63, "año"));
        animals.add(new Persona(9, "Gruñon", 85, "año"));
        animals.add(new Persona(10, "Soñador", 11, "mes"));

        Collections.sort(animals);

        try {
            //Objeto para escribir XML
            XMLOutputFactory xof = XMLOutputFactory.newInstance();
            XMLEventWriter xEWriter = xof.createXMLEventWriter(new FileOutputStream("animalesSTAX.xml"));

            //Objeto para crear eventos
            XMLEventFactory xEFactory = XMLEventFactory.newInstance();

            //Creo evento inicio documento
            StartDocument startDocument = xEFactory.createStartDocument();
            xEWriter.add(startDocument);

            //Creo eventos para maquetar y añado el salto de linea
            Characters saltoLinea = xEFactory.createCharacters("\n");
            Characters saltoLineaTab = xEFactory.createCharacters("\n\t");
            Characters tabulador = xEFactory.createCharacters("\t");

            xEWriter.add(saltoLinea);

            //Creo evento para etiq raíz y su maquetación
            StartElement startElement = xEFactory.createStartElement("", "", "animales");
            xEWriter.add(startElement);
            xEWriter.add(saltoLineaTab);

            //Creo var para longitud del array
            int longitud = 0;

            for (ReinoAnimal ra : animals) {

                //Creo etq
                StartElement nombreStart = xEFactory.createStartElement("", "", "nombre");
                Attribute id = xEFactory.createAttribute("id", Integer.toString(ra.getId()));
                Characters nombre = xEFactory.createCharacters(ra.getNombre());
                EndElement nombreEnd = xEFactory.createEndElement("", "", "nombre");

                //Añado los elementos en el orden correcto
                if (ra instanceof Animal) {
                    StartElement animalStart = xEFactory.createStartElement("", "", "animal");
                    xEWriter.add(animalStart);
                }
                if (ra instanceof Persona) {
                    StartElement personaStart = xEFactory.createStartElement("", "", "persona");
                    xEWriter.add(personaStart);
                }

                xEWriter.add(id);

                xEWriter.add(saltoLineaTab);
                xEWriter.add(tabulador);

                if (ra instanceof Animal && (((Animal) ra).getRaza()!= null)) {
                    StartElement razaStart = xEFactory.createStartElement("", "", "raza");
                    Characters raza = xEFactory.createCharacters(((Animal) ra).getRaza());
                    EndElement razaEnd = xEFactory.createEndElement("", "", "raza");
                    xEWriter.add(razaStart);
                    xEWriter.add(raza);
                    xEWriter.add(razaEnd);
                    xEWriter.add(saltoLineaTab);
                    xEWriter.add(tabulador);
                }

                xEWriter.add(nombreStart);
                xEWriter.add(nombre);
                xEWriter.add(nombreEnd);

                if(ra.getUnidad() != null) {
                    StartElement edadStart = xEFactory.createStartElement("", "", "edad");
                    xEWriter.add(saltoLineaTab);
                    xEWriter.add(tabulador);
                    xEWriter.add(edadStart);
                    Attribute unidadAttr = xEFactory.createAttribute("unidad", ra.getUnidad());
                    xEWriter.add(unidadAttr);
                    Characters edad = xEFactory.createCharacters(Integer.toString(ra.getEdad()));
                    xEWriter.add(edad);
                    EndElement edadEnd = xEFactory.createEndElement("", "", "edad");
                    xEWriter.add(edadEnd);
                }

                xEWriter.add(saltoLineaTab);

                if (ra instanceof Animal) {
                    EndElement animalEnd = xEFactory.createEndElement("", "", "animal");
                    xEWriter.add(animalEnd);
                }
                if (ra instanceof Persona) {
                    EndElement personaEnd = xEFactory.createEndElement("", "", "persona");
                    xEWriter.add(personaEnd);
                }

                //En el último la tab es diferente
                if (longitud == animals.size() - 1) {
                    xEWriter.add(saltoLinea);
                } else {
                    xEWriter.add(saltoLineaTab);
                }
                longitud++;
            }

            //Evento de cierre de etiq raíz
            EndElement endElement = xEFactory.createEndElement("", "", "animales");
            xEWriter.add(endElement);
            xEWriter.add(saltoLinea);

            //Evento de fin de documento
            EndDocument endDocument = xEFactory.createEndDocument();
            xEWriter.add(endDocument);


        } catch (FileNotFoundException | XMLStreamException ex) {
            System.out.println(ex.getStackTrace());
        }
    }
}
