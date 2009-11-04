package org.uinator.code.haxe;

import java.util.*;
import org.uinator.code.*;
import org.uinator.code.haxe.printers.MethodPrinter;

public class Method extends Statement {

	private Boolean _static;
	private String _name;
	// @todo В дальнейшем переделать на Decorator
	private String _access;
	private String _type;
	private List<Variable> _args;
	private Block _statementsBlock;
	
	public Method() {
		this._args = new ArrayList<Variable>();
		this._statementsBlock = new Block();
		this._statementsBlock.setParent(this);
	}
	
	public Method( String name, String access, String type, Boolean is_static ) {
		this();
		
		this._name = name;
		this._access = access;
		this._type = type;
		this._static = is_static;
	}
	
	public Variable addArgument( Variable v ) {
		this._args.add( v );
		return v;
	}
	
	public Boolean isStatic() {
		return this._static;
	}
	
	public String getAccess() {
		return this._access;
	}
	
	public String getName() {
		return this._name;
	}
	
	public String getType() {
		return this._type;
	}
	
	public List<Variable> getArgs() {
		return this._args;
	}
	
	public Block getStatementsBlock() {
		return this._statementsBlock;
	}
	
	public List<Statement> getStatements() {
		return this._statementsBlock.getStatements();
	}
	
	public Statement addStatement( Statement stm ) {
		return this._statementsBlock.addStatement(stm);
	}
	
	public Printer getPrinter() {
		return new MethodPrinter(this);
	}
	
}
