package u8_t1_RecorrXmlSaxDom;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class RecorridoSAX {

    public static void main(String[] args) {

        try {

            //Obtención del ParseSAX
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser saxParser = spf.newSAXParser();

            //Creo nuevo objeto de la clase genérica de SAX para manejar los eventos
            DefaultHandler genericSAX = new GenericXMLSax();

            //Lanzo el parseador del fichero + nuestro manejador
            saxParser.parse(new File("U8_T1_ficheroXML.xml"), genericSAX);

        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
