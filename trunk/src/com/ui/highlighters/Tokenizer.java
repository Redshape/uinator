package com.ui.highlighters;

import java.util.HashMap;

public interface Tokenizer {

	public void process( String data );
	public Token[] getTokens();
	
}
