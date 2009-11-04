package com.ui.highlighters;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;

public class UXMLTokenizer implements Tokenizer {

	private ArrayList<Token> _tokens;
	
	public static final int TOKEN_NONE = 0;
	public static final int TOKEN_NODE_NAME = 1;
	public static final int TOKEN_ATTR_NAME = 2;
	public static final int TOKEN_ATTR_VALUE = 3;
	public static final int TOKEN_NODE_BRACKETS = 4;
	public static final int TOKEN_CDATA_NODE = 5;
	public static final int TOKEN_XMLNS_DECL = 6;
	public static final int TOKEN_XMLNS_CALL = 7;
	public static final int TOKEN_SINGLE_QUOTE = 8;
	public static final int TOKEN_DOUBLE_QUOTE = 9;
	public static final int TOKEN_NODE = 10;
	public static final int TOKEN_NODE_INNER = 11;
	
	public UXMLTokenizer() {
		this._tokens = new ArrayList<Token>();
	}
	
	public void process( String data ) {
		int context = TOKEN_NONE;
		int pos = 0;
		
		String token = new String();
		boolean nextToken = false;
		while( pos < data.length() ) {
			if ( nextToken ) {
				if ( context != TOKEN_NONE ) {
					this._tokens.add( new Token( context, token, pos ) );	
				}
				token = "";
				nextToken = false;
			}
			
			char currChar = data.charAt(pos);
			switch ( currChar ) {
			case '\n':
			case '\r':
			case '\t':
			case ' ':
				if ( context == TOKEN_NODE_NAME || context == TOKEN_NODE ) {
					context = TOKEN_NODE_INNER;
				}
				nextToken = true;
			break;
			case '\'':
				context = TOKEN_SINGLE_QUOTE;
				nextToken = true;
			break;
			case '\"':
				context = TOKEN_DOUBLE_QUOTE;
				nextToken = true;
			break;
			case '<':
				context = TOKEN_NODE_BRACKETS;
				nextToken = true;
			break;
			case '>':
			case '/':
				context = TOKEN_NODE_BRACKETS;
			
				if ( currChar == '>' ) {
					nextToken = true;
				}
			break;
			default:
				if ( context == TOKEN_NODE_BRACKETS ) {
					context = TOKEN_NODE;
					nextToken = true;
					continue;
				}
				
				if ( context == TOKEN_NODE ) {
					context = TOKEN_NODE_NAME;
				}
				
				if ( context == TOKEN_NODE_INNER ) {
					context = TOKEN_ATTR_NAME;
				}
				
				if ( context == TOKEN_DOUBLE_QUOTE || context == TOKEN_SINGLE_QUOTE ) {
					if ( context == TOKEN_ATTR_VALUE ) {
						context = TOKEN_NODE_INNER;
					} else if ( context == TOKEN_ATTR_NAME ) {
						context = TOKEN_ATTR_VALUE;
					}
				}
			}
			
			token = token.concat( String.valueOf( currChar ) );
			
			pos += 1;
		}
	}
	
	public Token[] getTokens() {
		return (Token[])this._tokens.toArray( new Token[this._tokens.size()] );
	}
	
}
