package org.uinator.code;

import org.uinator.utils.*;

abstract public class Printer {
	public static String ALIGNING_CHARACTER = "  ";
	public static String NEW_LINE_CHARACTER = "\n";
	private Statement _context;
	
	
	public Printer( Statement context ) {
		this._context = context;
	}
	
	protected Statement getContext() {
		return this._context;
	}
	
	public String getAlignment() {
		return StringUtils.repeat( String.valueOf( Printer.ALIGNING_CHARACTER ), this.getContext().getHierarhicalDepth() );
	}
	
	abstract public String render() throws GeneratorException;
	
}
