package org.uinator.code.haxe;

import java.util.*;
import org.uinator.code.*;
import org.uinator.code.haxe.printers.MethodInvokePrinter;

public class MethodInvoke extends Statement {

	private Variable _objectContext;
	private String _methodName;
	private List<Variable> _args;
	
	public MethodInvoke() {
		this._args = new ArrayList<Variable>();
	}
	
	public MethodInvoke( Variable objectContext, String methodName ) {
		this( objectContext, methodName, null );
	}
	
	public MethodInvoke( Variable objectContext, String methodName, Variable... args ) {
            this();
            this._objectContext = objectContext;
            this._methodName = methodName;

            if ( args != null ) {
                this._args = Arrays.asList(args);
            }
	}
	
	public String getMethodName() {
            return this._methodName;
	}
	
	public List<Variable> getArgs() {
            return this._args;
	}
	
	public Variable getObjectContext() {
            return this._objectContext;
	}
	
	public Printer getPrinter() {
            return new MethodInvokePrinter(this);
	}

}
