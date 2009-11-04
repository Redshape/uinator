package com.ui.highlighters;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.Highlighter;
import javax.swing.text.DefaultHighlighter;

import com.ui.highlighters.schemes.Scheme;
import com.ui.highlighters.schemes.uxml.*;


public class UXMLHighlighter {
	private Tokenizer tokenizer;
	private Scheme color_scheme;
	
	public UXMLHighlighter() {
		this.tokenizer = new UXMLTokenizer();
		this.color_scheme = new DefaultScheme();
	}
	
	public Scheme getColorScheme() {
		return this.color_scheme;
	}
	
	/**
	 * @FIXME Not ready
	 * @param cmp
	 * @throws BadLocationException
	 */
	public void highlight( JTextComponent cmp ) throws BadLocationException {
		/**Highlighter hi = cmp.getHighlighter();
		hi.removeAllHighlights();
		
		this.tokenizer.process( cmp.getText() );
		
		for ( Token token:this.tokenizer.getTokens() ) {
			//hi.addHighlight( token.getPos(), token.getString().length(),  this.getPainter(token) );
		}**/
	}
	
	protected Highlighter.HighlightPainter getPainter( Token token ) {
		return new HiPainter( this.getColorScheme().getTokenColor(token) );
	}
	
	protected class HiPainter extends DefaultHighlighter.DefaultHighlightPainter {

		public HiPainter(Color color) {
			super(color);
		}
		
	}
	
}
