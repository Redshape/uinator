package org.uinator;

public class Import {
	
	public String _path;
	public String _as;
	
	public Import() {
		
	}
	
	public Import(String path) {
		this();
		
		this._path = path;
	}
	
	public void setPath( String value ) {
		this._path = value;
	}
	
	public String getPath() {
		return this._path;
	}
}
