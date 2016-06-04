package org.sourceit.dom;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.sourceit.BookReadable;
import org.sourceit.entites.Book;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

// hometask
public class DParser implements BookReadable {

    private DOMParser parser;

    public DParser() {
        parser = new DOMParser();
    }

    public DOMParser getParser() {
        return parser;
    }

    public List<Book> getBooks() {
        return null;
    }
}
