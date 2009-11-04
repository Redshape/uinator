package org.uinator.code.haxe;

import java.util.ArrayList;
import java.util.List;

import org.uinator.code.*;
import org.uinator.code.haxe.printers.PackagePrinter;

public class Package extends Statement {
	private String _name;
	private List<Import> _imports;
	private List<Class> _classes;
	
	public Package() {
            this._imports = new ArrayList<Import>();
            this._classes = new ArrayList<Class>();
	}
	
	public Package( String name ) {
            this();
            this._name = name;
	}
	
	public Import addImport( Import imp ) {
		this._imports.add(imp);
		
		return imp;
	}
	
	public String getName() {
		return this._name;
	}
	
	public List<Import> getImports() {
		return this._imports;
	}
	
	public Class addClass( Class cls ) {
		this._classes.add(cls);
		return cls;
	}
	
	public List<Class> getClasses() {
		return this._classes;
	}

	@Override
	public Printer getPrinter() {
		return new PackagePrinter(this);
	}

        public static Package createEmpty() {
            return new Package("");
        }

}
