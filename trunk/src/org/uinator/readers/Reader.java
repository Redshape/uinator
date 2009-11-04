package org.uinator.readers;

public interface Reader {
	
	public Node process( Source source ) throws ReadException;

}
