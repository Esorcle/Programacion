package u8_t2_ModArbolDOMsaveFichXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.*;

public class DomDsdCero {
    public static void main(String[] args) {

        //Creo objetos del Reino animal
        List<ReinoAnimal> animales = new ArrayList<>();

        animales.add(new Animal(1, "Zoe", "Persa", 2, "año"));
        animales.add(new Animal(2, "Thais", "Labrador", 7, "año"));
        animales.add(new Animal(5, "Pelusa", null));
        animales.add(new Animal(6, "Pollito", "Pipi", 1, "mes"));
        animales.add(new Animal(7, "Babosa", null));
        animales.add(new Persona(3, "Fany", 32, "año"));
        animales.add(new Persona(4, "Antonio", 37, "año"));
        animales.add(new Persona(8, "Esperanza", 63, "año"));
        animales.add(new Persona(9, "Gruñon", 85, "año"));
        animales.add(new Persona(10, "Soñador", 11, "mes"));


        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            //Obtengo un nuevo documento
            Document doc = db.newDocument();

            //Creo elemento raíz y lo añado al doc
            Element root = doc.createElement("animales");
            doc.appendChild(root);

            //Creación de las etiquetas
            Collections.sort(animales);

            //Recorro la lista de animales
            Iterator<ReinoAnimal> it = animales.iterator();
            while (it.hasNext()) {
                //1º Saco los contenidos de los objetos y creo etiquetas
                ReinoAnimal aux = it.next();
                String nombreEtiqueta = aux.getClass().getSimpleName().toLowerCase();
                Element elementEtiq = doc.createElement(nombreEtiqueta);
                elementEtiq.setAttribute("id", Integer.toString(aux.getId()));

                //Para las etiquetas hijas
                //if (aux.getClass().getSimpleName().equals("Animal")) {
                if (aux instanceof Animal) {
                    Animal animal = (Animal) aux;
                    Element raza = doc.createElement("raza");
                    raza.setTextContent(((Animal) aux).getRaza());
                    elementEtiq.appendChild(raza);
                }

                if (aux.getNombre() != null) {
                    Element nombre = doc.createElement("nombre");
                    nombre.setTextContent(aux.getNombre());
                    elementEtiq.appendChild(nombre);
                }

                if (aux.getUnidad() != null) {
                    Element edad = doc.createElement("edad");
                    edad.setAttribute("unidad", aux.getUnidad());
                    edad.setTextContent(Integer.toString(aux.getEdad()));
                    elementEtiq.appendChild(edad);
                }

                //Añado la etiqueta al raíz
                root.appendChild(elementEtiq);
            }

            //Volcamos el árbol al fichero
            //Obtenemos el objeto transformer
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();

            //Configuración del transformer
            //Podéis ver toda la lista de propiedes aquí
            // https://docs.oracle.com/javase/7/docs/api/javax/xml/transform/OutputKeys.html
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty("http://www.oracle.com/xml/is-standalone", "yes");

            //Creación del origen DOMSource
            DOMSource origenDOM = new DOMSource(root);

            //Creación del fichero que va a ser mi destino
            File nuevoAnimales = new File("animalesXML.xml");
            StreamResult destino = new StreamResult(nuevoAnimales);

            //Hacemos la transformación que en nuestro caso es la escritura
            transformer.transform(origenDOM, destino);


        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
