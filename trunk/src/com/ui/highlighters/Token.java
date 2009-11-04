package com.ui.highlighters;

public class Token {

	private int type;
	private int pos;
	private String string;
	
	public Token( int type, String string, int pos ) {
		this.type = type;
		this.string = string;
		this.pos = pos;
	}
	
	public int getType() {
		return this.type;
	}
	
	public String getString() {
		return this.string;
	}
	
	public int getPos() {
		return this.pos;
	}
	
}
