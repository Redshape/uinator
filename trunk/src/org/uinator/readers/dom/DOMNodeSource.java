package org.uinator.readers.dom;

import org.w3c.dom.Node;

public class DOMNodeSource implements org.uinator.readers.Source {
	
	private Node _source;
	
	public DOMNodeSource( Node node ) {
		this._source = node;
	}
	
	public Node getRawSource() {
		return this._source;
	}
	
}
