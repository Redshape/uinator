package org.uinator.code;

import java.util.ArrayList;
import java.util.List;


abstract public class Container extends Statement {

	private List<Statement> _statements;
	
	public Container() {
		this._statements = new ArrayList<Statement>();
	}
	
	public List<Statement> getStatements() {
		return this._statements;
	}
	
	public Statement addStatement( Statement stm ) { 
		stm.setParent(this);
		this._statements.add( stm );
		return stm;
	}
	
}
