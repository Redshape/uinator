package org.uinator.code.haxe;

import java.util.List;
import org.uinator.code.*;
import org.uinator.code.haxe.printers.VariablePrinter;

public class Variable extends Statement {
	
	private String _name;
	private String _type;
	private String _value;
        private List<Variable> _constructionArgs;

        public Variable( String name, String type, String value, List<Variable> constructionArgs ) {
            this( name, type );

            this._constructionArgs = constructionArgs;
            this._value = null;
        }

	public Variable( String name, String type, String value ) {
            this( name, type );
            
            this._value = value;
        }

        public Variable( String name, String type ) {
            this._name = name;
            this._type = type;
        }
	
	public String getName() {
		return this._name;
	}
	
	public String getType() {
		return this._type;
	}
	
	public String getValue() {
		return this._value;
	}

        public List<Variable> getConstructionArgs() {
            return this._constructionArgs;
        }

	public Printer getPrinter() {
		return new VariablePrinter(this);
	}
}
