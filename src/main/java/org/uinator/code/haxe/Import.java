package org.uinator.code.haxe;

import org.uinator.code.*;
import org.uinator.code.haxe.printers.ImportPrinter;

public class Import extends Statement {
	
	private String _path;
	
	public Import( String path ) {
		this._path = path;
	}
	
	public String getPath() {
		return this._path;
	}
	
	public Printer getPrinter() {
		return new ImportPrinter(this);
	}

	
}
