package org.uinator;

import java.io.*;

import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import org.uinator.Unserializer;
import org.uinator.readers.dom.*;
import org.uinator.widget.UI;

/**
 * UXML parser class
 *
 * @author nikelin
 */
public class Parser {

	/**
	 * Unserializing logic provider for parser
	 * @var Unserializer
	 */
    private Unserializer _unserializer;

    /**
     * Takes file with UXML definitions as input, and
     * give as output generated Java-object.
     * 
     * @param {@link java.io.File} file
     * @return UI
     * @throws ParserException
     */
    public UI parse(File file) throws ParserException {
        try {
            Unserializer processor = new Unserializer( new org.uinator.reflection.BaseReflectionProvider() );
            
            return (UI) processor.process(UI.class, new org.uinator.readers.dom.DOMReader().process( 
        												new DOMNodeSource(this.getXmlDocument(file).getDocumentElement() 
            										) 
            							  ) );
        } catch ( Exception e) {
            throw new ParserException(e);
        }
    }

    /**
     * Returns DOM document as result of processing given file 
     * @param {@link java.io.File} file
     * @return {@link org.w3c.dom.DOMException}Document
     * @throws {@link java.io.IOException}
     * @throws {@link org.xml.sax.SAXException}
     * @throws {@link javax.xml.parsers.ParserConfigurationException}
     */
    protected Document getXmlDocument(File file) throws IOException, SAXException, ParserConfigurationException {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
    }
}

class ParserException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3986689428368743565L;

	public ParserException(Exception e) {
        this.setStackTrace(e.getStackTrace());
    }
}
