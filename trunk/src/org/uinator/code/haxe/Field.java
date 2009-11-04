package org.uinator.code.haxe;

import org.uinator.code.*;
import org.uinator.code.haxe.printers.FieldPrinter;

public class Field extends Variable {
	
	private Boolean _static;
	private String _access;
	
	public Field( String name, String type, String value, String access, Boolean is_static ) {
		super( name, type, value );
		
		this._access = access;
		this._static = is_static;
	}
	
	public Boolean isStatic() {
		return this._static;
	}
	
	public String getAccess() {
		return this._access;
	}
	
	public Printer getPrinter() {
		return new FieldPrinter(this);
	}
	
}
