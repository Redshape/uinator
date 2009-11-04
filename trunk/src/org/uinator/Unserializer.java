package org.uinator;

import org.uinator.readers.*;
import org.uinator.readers.dom.DOMReader;
import org.uinator.reflection.*;

class Unserializer<T> {
	
	private Reader reader = new DOMReader();
	private ReflectionProvider reflector;
	
	public Unserializer<T> setReader( Reader reader ) {
		this.reader = reader;
		return this;
	}
	
	protected Reader getReader() {
		return this.reader;
	}
	
	protected ReflectionProvider getReflector() {
		return this.reflector;
	}
	
	public Unserializer setReflector( ReflectionProvider provider) {
		this.reflector = provider;
		return this;
	}
	
	public T process( Class<T> context, Node source ) throws Throwable {
		T instance = (T) this.getReflector().createInstance(context);
		
		
		
		return instance;
	}
	
}

class UnserializerException extends Exception {
	
	public UnserializerException( String message ) {
		
	}
}