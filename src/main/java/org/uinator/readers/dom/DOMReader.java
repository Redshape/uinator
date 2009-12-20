package org.uinator.readers.dom;

import org.uinator.readers.*;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DOMReader implements Reader {

    public org.uinator.readers.Node process(Source source) throws ReadException {
        return this.convertDOMTree((Element) source.getRawSource());
    }

    public org.uinator.readers.Node convertDOMTree(Element source) {
        org.uinator.readers.Node result;
        if ( source.getNodeName().contains(":") ) {
        	String nodeNameParts [] = this.processNodeName( source.getNodeName() );
        	result = new org.uinator.readers.Node( nodeNameParts[1], source.getNodeValue(), nodeNameParts[0] );
        } else {
        	result = new org.uinator.readers.Node( source.getNodeName(), source.getNodeValue() );
        }
        
        NamedNodeMap attributes = source.getAttributes();
        if (attributes != null) {
            for (int nAttr = 0; nAttr < attributes.getLength(); nAttr++) {
            	Node attr = attributes.item(nAttr);
            	String attrName = attr.getNodeName();
            	String attrNs = null;
            	
            	// Check that attribute name not contains NS prefix
            	if ( attrName.contains(":") ) {
            		String nameParts[] = this.processNodeName( attr.getNodeName() );
            		attrName = nameParts[1];
            		attrNs = nameParts[0]; 
            	}
            	
                if ( attrNs != null && attrNs.equals("xmlns") ) {
                    result.registerNamespace( new Namespace( attrName, attr.getNodeValue() ) );
                } else {
                    result.addAttribute( attrName, attr.getNodeValue(), attrNs );
                }
            }
        }

        for (Node _child = source.getFirstChild(); _child != null; _child = _child.getNextSibling()) {
            if ( _child instanceof Element ) {
                result.addChild(this.convertDOMTree((Element)_child));
            }
        }

        return result;
    }

    protected String[] processNodeName( String nodeName ) {
        String result[] = { nodeName, null };

        if ( nodeName.contains(":") ) {
            result[0] = nodeName.substring( 0, nodeName.indexOf(":") );
            result[1] = nodeName.substring( nodeName.indexOf(":") + 1 );
        }

        return result;
    }
}
