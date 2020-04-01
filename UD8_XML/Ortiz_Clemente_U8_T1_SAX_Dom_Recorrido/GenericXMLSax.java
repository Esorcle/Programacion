package u8_t1_RecorrXmlSaxDom;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Clase genérica para recorrer un XML mediante parseador SAX
 * Se implementará los métodos necesarios
 * Se actualizará según se necesite
 * @author Fany
 * @version 1
 * @date 31/03/2020
 */
public class GenericXMLSax extends DefaultHandler {

    /**
     * Constuctor
     */
    public GenericXMLSax() {super();
    }

    // Handler para el evento fin de documento
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("Comienzo del parseado del documento Ej1Persona.xml");
    }

    // Handler para el evento fin de documento
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("Comienzo del parseado del documento Ej1Persona");
    }

    // Handler para el evento etiqueta de apertura
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        // Abro la etiqueta
        System.out.println("<" + qName);

        //Recorro los atributos (si tuviera)
        if(attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println(" " + attributes.getQName(i) + "=\"" + attributes.getValue(i) + "\"" );
            }
        }

        //Cierro la etiqueta
        System.out.println(">");
    }

    // Handler para el evento etiqueta de cierre
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);

        System.out.println("</" + qName + ">");
    }

    //Handler para el evento Nodo de Texto encontrado
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);

        //start = posición inicio       length = posición final
        String content = new String(ch,start,length);
        System.out.println(content);
    }

}
