package com.ui.editors;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import com.ui.*;
import com.ui.highlighters.UXMLHighlighter;

public class CodeEditor extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JPopupMenu contextMenu;
	private JTextArea codeArea;
	private UXMLHighlighter highlighter;
	
	
	public CodeEditor() {
		this.highlighter = new UXMLHighlighter();
		this.codeArea = new JTextArea();
		
		this.enableInputMethods(true);
		this.initUI();
		this.initEvents();
	}
	
	protected void initUI() {
		this.setLayout( new BorderLayout() );
		
		/**
		 * 
		 * Other initialization routines
		 *
		 */
		
		this.add( this.codeArea, BorderLayout.CENTER );
	}
	
	public void setText( String text ) {
		this.codeArea.setText(text);
	}
	
	public String getText() {
		return this.codeArea.getText();
	}
	
	protected void initEvents() {
		this.codeArea.addKeyListener( new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					CodeEditor.this.highlighter.highlight( CodeEditor.this.codeArea );
				} catch ( Exception ec ) {
					MainWindow.showException("Highlighting error", ec);
				}
				
				super.keyPressed(e);
			}
		});
		
		this.codeArea.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
				if ( e.getButton() == MouseEvent.BUTTON3 ) {
					CodeEditor.this.showContextMenu( CodeEditor.this.codeArea, e.getX(), e.getY() );
				}
			}
		});
	}
	
	class CutAction extends AbstractAction {
		private JTextComponent tc;
		
		public CutAction( JTextComponent tc ) {
			super("Cut");
			
			this.tc =tc;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			this.tc.copy();
			this.tc.replaceSelection("");
		}
	}
	
	class PasteAction extends AbstractAction {
		private JTextComponent tc;
		
		public PasteAction( JTextComponent tc ) {
			super("Paste");
			
			this.tc =tc;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			this.tc.paste();
		}
	}
	
	class CopyAction extends AbstractAction {
		private JTextComponent tc;
		
		public CopyAction( JTextComponent tc ) {
			super("Copy");
			
			this.tc =tc;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			this.tc.copy();
		}
	}
	
	class FormatAction extends AbstractAction {
		private JTextComponent tc;
		
		public FormatAction( JTextComponent tc ) {
			super("Format");
			
			this.tc =tc;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	protected void showContextMenu( JTextComponent context, int x, int y) {
		if( null == this.contextMenu ) {
			this.contextMenu = new JPopupMenu();
			this.contextMenu.setSize(150, 500);
			
			this.contextMenu.add( new CopyAction(context) );
			this.contextMenu.add( new CutAction(context) );
			this.contextMenu.add( new PasteAction(context) );
			this.contextMenu.addSeparator();
			this.contextMenu.add( new FormatAction(context) );
		}
		
		this.contextMenu.show( context, x, y);
	}
	
}
