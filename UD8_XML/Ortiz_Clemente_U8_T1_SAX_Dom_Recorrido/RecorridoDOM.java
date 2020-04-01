package u8_t1_RecorrXmlSaxDom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RecorridoDOM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Función \"numNodosHijos\"");
        System.out.println();
        numNodosHijos();

        System.out.println("****************************************");
        System.out.println();
        System.out.println("Función \"mostrarXMLDOM\"");
        System.out.println();
        mostrarXMLDom();

        System.out.println("****************************************");
        System.out.println();

        System.out.println("Función \"mostrarContenidoEtiq\"");
        System.out.println("Dime etiqueta a buscar");
        String etiq = sc.nextLine();

        Element etiqueta = null;
        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            //Creo un elemento de una etiqueta
            etiqueta = db.newDocument().createElement(etiq);


        } catch (ParserConfigurationException e) {
            System.out.println(e.getStackTrace());
        }

        if (etiqueta != null) {
            mostrarContenidoEtiq(etiqueta);
        }
    }


    public static void numNodosHijos() {

        try {
            //Cargo el fichero en memoria
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(Etiquetas.URL));

            // Saco el nodo raíz
            Element root = doc.getDocumentElement();

            // Número de nodos del element root
            System.out.println("Nodos hijos del elemento raíz,  " + root.getTagName() + " son: " + root.getChildNodes().getLength());

            System.out.println("Y son de tipo: ");

            //Obtengo todos los nodos hijos root
            NodeList nl = root.getChildNodes();

            for (int i = 0; i < nl.getLength(); i++) {
                System.out.println("Nodo " + (i + 1) + ": " + "Tipo: " + nl.item(i).getNodeType() + " Nombre tipo: " + nl.item(i).getNodeName());
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public static void mostrarXMLDom() {

        try {
            //Cargo el fichero en memoria
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(Etiquetas.URL));

            // Saco el nodo raíz
            Element root = doc.getDocumentElement();

            // Número de nodos del element root
            System.out.println("Nodos hijos del elemento raíz,  " + root.getTagName() + " son: " + root.getChildNodes().getLength());

            System.out.println("Y son de tipo: ");

            //Obtengo todos los nodos hijos root
            NodeList nl = root.getChildNodes();

            for (int i = 0; i < nl.getLength(); i++) {
                System.out.println("Nodo " + (i + 1) + ": " + "Tipo: " + nl.item(i).getNodeType() + " Nombre tipo: " + nl.item(i).getNodeName());
                if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nl.item(i);
                    System.out.println("Y su contenido es:");
                    System.out.println(element.getTextContent());

                    //Compruebo si tiene atributos
                    mostrarAttr(element);

                } else if (nl.item(i).getNodeType() == Node.TEXT_NODE) {
                    System.out.print("Y contiene: ");

                    //Hago el cast
                    Text texto = (Text) nl.item(i);

                    System.out.println(texto.getTextContent());

                    //He encontrado un nodo comentario
                } else if (nl.item(i).getNodeType() == Node.COMMENT_NODE) {
                    System.out.println("Y contiene: ");

                    //Hago el cast
                    Comment commentario = (Comment) nl.item(i);

                    System.out.println(commentario.getTextContent());
                }
                System.out.println("------------------------------");
            }


        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getStackTrace());
        }

    }

    public static void mostrarContenidoEtiq(Element e) {
        try {
            //Cargo el fichero en memoria
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(Etiquetas.URL));

            NodeList nl = doc.getElementsByTagName(e.getTagName());
            System.out.println("Hay "+ nl.getLength() + " etiquetas con ese nombre");
            System.out.println();

            if(nl != null && nl.getLength()>0 ) {
                //Trato cada una de las etiquetas
                for (int i = 0; i < nl.getLength() ; i++) {

                    //Saco el nodo que estoy recorriendo en este momento
                    Node nodo = nl.item(i);

                    // Recorro el nodo
                    recorrerNodo(nodo);

                    System.out.println("------------------------------");
                }
            } else {
                System.out.println("No se han encontrado etiquetas con este nombre");
            }

        } catch (ParserConfigurationException | IOException | SAXException ex) {
            System.out.println(ex.getStackTrace());
        }
    }

    private static void recorrerNodo(Node nodo) {

        //Si encuentro etiqueta
        if (nodo.getNodeType() == Node.ELEMENT_NODE) {

            //Hago un cast a element
            Element elemento = (Element) nodo;

            //Saco a por pantalla su nombre
            System.out.println("Nodo etiqueta: " + elemento.getTagName());

            mostrarAttr(elemento);

            //Miro si tiene hijos
            if (elemento.hasChildNodes()) {

                    //Los guardo en una lista de nodos
                    NodeList listaInterior = nodo.getChildNodes();

                    //Recorro los nodos hijos
                    for (int j = 0; j < listaInterior.getLength(); j++) {

                        //Tomo nodo por nodo
                        Node nodoHijo = listaInterior.item(j);

                        //Recorro nodoHijo
                        recorrerNodo(nodoHijo);

                        }
                    }

            } else if (nodo.getNodeType() == Node.TEXT_NODE) {
            System.out.println("Nodo TEXTO");
            //Hago el cast
            Text texto = (Text) nodo;

            System.out.println("Contenido: " + texto.getTextContent());

            //He encontrado un nodo comentario
        } else if (nodo.getNodeType() == Node.COMMENT_NODE) {
            System.out.println("Nodo COMENTARIO");

            //Hago el cast
            Comment commentario = (Comment) nodo;

            System.out.println("Contenido: " + commentario.getTextContent());
        }

    }


    private static void mostrarAttr(Element element) {
        if (element.hasAttributes()) {

            //Obtengo mapa de los atributos para mostrarlos
            //Uso de NameNodeMap para recorrer y luego hacer cast a attr
            //Son atributos que siempre están en elementos
            NamedNodeMap nodeMap = element.getAttributes();

            //Recorro el mapa
            for (int j = 0; j < nodeMap.getLength(); j++) {

                //Obtengo cada nodo del mapa
                Node node = nodeMap.item(j);

                //Hago el cast a atributo
                Attr atribute = element.getAttributeNode(node.getNodeName());

                System.out.println("Atributo: " + atribute.getNodeName());
                System.out.println("Valor: " + atribute.getValue());
            }
        }
    }
}
