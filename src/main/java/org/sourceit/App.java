package org.sourceit;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xerces.internal.jaxp.SAXParserImpl;
import org.sourceit.dom.DParser;
import org.sourceit.entites.Book;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        String bookJson =
                "{\n" +
                        "  \"bookstore\": [\n" +
                        "    {\n" +
                        "      \"book\": {\n" +
                        "        \"title\": \"Java for Dummies\",\n" +
                        "        \"author\": \"Tah Ah Teck\",\n" +
                        "        \"category\": \"Programming\",\n" +
                        "        \"year\": 2009,\n" +
                        "        \"edition\": 7,\n" +
                        "        \"price\": 19.99\n" +
                        "      }\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"book\": {\n" +
                        "        \"title\": \"More Java for Dummies\",\n" +
                        "        \"author\": \"Tah Ah Teck\",\n" +
                        "        \"category\": \"Programming\",\n" +
                        "        \"year\": 2008,\n" +
                        "        \"price\": 25.99\n" +
                        "      }\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";

        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(bookJson);

        while (!parser.isClosed()) {
//            if (parser.getCurrentName() != null && parser.getValueAsString() != null) {
                System.out.println("curr name -- " + parser.getCurrentName());
                System.out.println("curr value -- " + parser.getValueAsString());
                System.out.println("curr token -- " + parser.getCurrentToken());
//            }
            parser.nextToken();
        }


//        parseDOMMethod();

//        SAXParser saxParser =

//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        SAXParser parser = factory.newSAXParser();
//        parser.parse(new FileInputStream("./target/classes/bookstore.xml"),
//                new SAXXMLParser());


    }

    public static void parseDOMMethod() throws SAXException, IOException {
        DParser parser = new DParser();

        parser.getParser().parse("./target/classes/bookstore.xml");

        Document document = parser.getParser().getDocument();

        NodeList list = document.getElementsByTagName("book");

        List<Book> books = new ArrayList<>();

        for (int i = 0; i < list.getLength(); i++) {
            Node book = list.item(i);

            NodeList children = book.getChildNodes();

            Book book1 = new Book();

            for (int j = 0; j < children.getLength(); j++) {
                switch (children.item(i).getNodeName()) {
                    case "title":
                        book1.setTitle(children.item(i).getTextContent());
                        break;
                    case "author":
                        book1.setAuthor(children.item(i).getTextContent());
                        break;
                    case "year":
                        book1.setYear(Integer.parseInt(children.item(i).getTextContent()));
                        break;
                    case "edition":
                        book1.setEdition(Integer.parseInt(children.item(i).getTextContent()));
                        break;

                    default:
                        break;
                }
            }

            books.add(book1);


        }

        System.out.println(books);
    }
}

class SAXXMLParser extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("start doc");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("start element");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println(new String(ch).substring(start, start + length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("end element");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("end element");
    }
}
