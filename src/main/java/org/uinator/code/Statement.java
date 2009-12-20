package org.uinator.code;

abstract public class Statement {
	
	private Statement _parent;
	
	public int getHierarhicalDepth() {
		int depth = 0;
		if ( this.getParent() != null ) {
			depth = 1 + this.getParent().getHierarhicalDepth();
		}
		
		return depth;
	}
	
	public Statement setParent( Statement stm ) {
		this._parent = stm;
		return this;
	}
	
	abstract public Printer getPrinter();
	
	public Statement getParent() {
		return this._parent;
	}
}
