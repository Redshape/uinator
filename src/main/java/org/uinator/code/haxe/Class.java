package org.uinator.code.haxe;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.uinator.code.*;
import org.uinator.code.haxe.printers.ClassPrinter;

public class Class extends Statement {
	
	public static final String ACCESS_PUBLIC = "public";
	public static final String ACCESS_PRIVATE = "private";
	
	private String _name;
	private String _parentCls;
	private List<String> _implementsList;
	private List<Method> _methods;
	private List<Field> _fields;
	
	public Class() {
		this._implementsList = new ArrayList<String>();
		this._methods = new ArrayList<Method>();
		this._fields = new ArrayList<Field>();
	}
	
	public Class( String name, String parentCls, String [] implementsList ) {
		this();
		
		this._name = name;
		this._parentCls = parentCls;
		
		if ( implementsList != null ) {
			this._implementsList = Arrays.asList(implementsList);
		}
	}
	
	public Method addMethod( Method method ) {	
		this._methods.add( method );
		method.setParent(this);

		return method;
	}
	
	public Field addField( Field field ) {
		this._fields.add( field );
		field.setParent(this);
		
		return field;
	}
	
	public void addImplements( String interfaceName ) {
		this._implementsList.add(interfaceName);
	}
	
	public List<String> getImplementsList() {
		return this._implementsList;
	}
	
	public Class setParentCls( String name ) {
		this._parentCls = name;
		return this;
	}
	
	public String getParentCls() {
		return this._parentCls;
	}
	
	public Class setName( String value ) {
		this._name = value;
		return this;
	}
	
	public String getName() {
		return this._name;
	}
	
	public List<Method> getMethods() {
		return this._methods;
	}
	
	public List<Field> getFields() {
		return this._fields;
	}
	
	public Printer getPrinter() {
		return new ClassPrinter(this);
	}

}
