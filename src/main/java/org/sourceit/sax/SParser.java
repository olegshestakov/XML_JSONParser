package org.sourceit.sax;

import org.sourceit.entites.Book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;


// hometask
public class SParser extends DefaultHandler {

    private List<Book> books;

    @Override
    public void startDocument() throws SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

    }

    @Override
    public void endDocument() throws SAXException {

    }

    public List<Book> getBooks() {
        return books;
    }
}
