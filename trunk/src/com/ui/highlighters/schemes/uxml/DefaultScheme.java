package com.ui.highlighters.schemes.uxml;

import java.awt.Color;
import java.util.HashMap;
import com.ui.highlighters.*;
import com.ui.highlighters.schemes.Scheme;

public class DefaultScheme implements Scheme {
	private HashMap<Integer, Color> colors;
	
	public DefaultScheme() {
		this.colors = new HashMap<Integer, Color>();
		this.colors.put( UXMLTokenizer.TOKEN_ATTR_NAME, Color.blue);
		this.colors.put( UXMLTokenizer.TOKEN_ATTR_VALUE, Color.blue );
		this.colors.put( UXMLTokenizer.TOKEN_DOUBLE_QUOTE, Color.blue );
		this.colors.put( UXMLTokenizer.TOKEN_NODE_NAME, Color.green );
		this.colors.put( UXMLTokenizer.TOKEN_NODE_BRACKETS, Color.green );
	}
	
	public Color getTokenColor( Token tok ) {
		return this.colors.get( tok.getType() );
	}
	
}
