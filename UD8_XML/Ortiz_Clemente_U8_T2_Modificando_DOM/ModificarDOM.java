package u8_t2_ModArbolDOMsaveFichXML;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.Console;
import java.io.File;
import java.io.IOException;

public class ModificarDOM {
    public static void main(String[] args) {

        try {
            //Objeto Documento
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            //1º //Parseamos el XML para cargarlo en memoria
            Document doc = db.parse(new File("U8_T1_ficheroXML.xml"));

            //Obtenemos nodo raíz
            Node root = doc.getDocumentElement();

            //Creamos nodo comentario
            Comment comment = doc.createComment("COMENTARIO AÑADIDO DESDE DOM");

            //Obtengo lista de hijos de root
            NodeList nl = doc.getElementsByTagName("persona");
            NodeList nl2 = doc.getElementsByTagName("animal");
            //root.getChildNodes();

            //2º //Uso de insertBefore() para insertar comment antes de los nodos hijos de root
            for (int i = 0; i < nl.getLength() ; i++) {
              // if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
               //     Element nodoHijo = (Element) nl.item(i);
                    root.insertBefore(comment.cloneNode(false), nl.item(i));
              //  }
            }

            for (int i = 0; i < nl2.getLength() ; i++) {
               // if (nl2.item(i).getNodeType() == Node.ELEMENT_NODE) {
                 //   Element nodoHijo = (Element) nl2.item(i);
                    root.insertBefore(comment.cloneNode(false), nl2.item(i));
                    //false = no contenido ni hijos del clonado
              //  }
            }

            //3º //Insertar etiqueta hija como último hijo
            //Creo nodo Element
            Element animal = doc.createElement("animal");
            //Con atributo
            animal.setAttribute("id", "7");
            //Con etiq hija nombre
            Element nombre = doc.createElement("nombre");
            nombre.setTextContent("Pollito");

            //Construimos la estructura
            animal.appendChild(nombre);

            //Añadimos al root
            root.appendChild(animal);

            //4º //Crear etiqueta hija y sustituir 1º hijo
            //Creo nodo Element
            Element animal2 = doc.createElement("animal");
            //Con atributo
            animal2.setAttribute("id", "8");
            //Con etiq hija nombre
            Element nombre2 = doc.createElement("nombre");
            nombre2.setTextContent("Babosa");
            //Construimos la estructura de la etiq
            animal2.appendChild(nombre2);

            //Buscamos la etiq a reemplazar
            Node node = nl2.item(0);

            //Remplazo
            root.replaceChild(animal2, node);


            //Volcamos todas las mod del árbol al fichero

            //Obtenemos el objeto transformer
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();

            //Configuración del transformer para que maquet bonito - toda la lista de propiedades aquí
            // https://docs.oracle.com/javase/7/docs/api/javax/xml/transform/OutputKeys.html
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty("http://www.oracle.com/xml/is-standalone", "yes");

            //Creación del origen DOMSource. Root que ya lo he mod con el comment
            DOMSource origenDOM = new DOMSource(root);

            //Creación fichero destino
            File nuevoPersona = new File("dom_modificado.xml");
            StreamResult destino = new StreamResult(nuevoPersona);

            //Transformamos
            transformer.transform(origenDOM, destino);


        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            System.out.println(e.getStackTrace());
        }

    }
}
