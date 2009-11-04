package com.ui;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import com.Application;

import com.commands.*;

import com.ui.highlighters.*;
import com.ui.editors.CodeEditor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import java.io.File;
import java.io.FileReader;

public class EditWindow extends JFrame implements Commander {

	private JPopupMenu contextMenu;
	private CodeEditor codeArea;
	
	public EditWindow() {
		this.setTitle("UXML Editor");
		this.setSize( 500, 600 );
		this.initUI();
	}
	
	public void processCommand( CommandType ct, Object data ) {
		try {
			switch(ct) {
			case UXML_FILE_OPEN:
		        String text = new String();
	
	            int res = 0;
	            FileReader reader = new FileReader( (File)data );
	            do {
	                char buff[] = new char[2048];
	                res = reader.read(buff, res, 1024);
	                text = text.concat( String.valueOf(buff) );
	            } while (res != -1);
		            
		        this.codeArea.setText( text );
			break;
			}
		} catch( Exception e ) {
			MainWindow.showException( "Cannot read file", e );
		}
	}
	
	protected void initUI() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout( new BorderLayout() );
		
		this.codeArea = new CodeEditor();
		mainPanel.add( this.codeArea, BorderLayout.CENTER );
		
		JPanel controlsPanel = new JPanel();
		controlsPanel.setLayout( new GridLayout(2, 1) );
		
		JButton openBtn = new JButton("Open");
		openBtn.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				UXMLFileOpen.play(EditWindow.this);
			}	
		});
		
		JButton saveBtn = new JButton("Save");
		saveBtn.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent arg0 ) {
				Application.getLog().write("Trying to save document");
				//UXMLFileSave.play( EditWindow.this,  );
			}
		});
		
		controlsPanel.add( openBtn );
		controlsPanel.add( saveBtn );
		
		mainPanel.add( controlsPanel, BorderLayout.NORTH );
		
		this.add(mainPanel);
	}
	
	public void setCode( String code ) { 
		this.codeArea.setText(code);
	}
}
