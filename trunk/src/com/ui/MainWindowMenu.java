package com.ui;

import java.awt.*;
import java.awt.event.*;
import com.commands.UXMLFileOpen;

public class MainWindowMenu extends MenuBar implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -395938098596373575L;
	private Menu fileMenu;
	private MainWindow parent;
	
	public MainWindowMenu( MainWindow parent ) {
		this.parent = parent;
		
		fileMenu = new Menu("File");
		fileMenu.setName("fileMenu");
		fileMenu.add( new MenuItem("New") );
		fileMenu.add( new MenuItem("Open") );
		fileMenu.add( new MenuItem("Exit") );
		
		fileMenu.addActionListener( this );
		
		this.add( fileMenu );
	}
	
	public void actionPerformed( ActionEvent e ) {
		if ( e.getSource() == this.fileMenu ) {
			if ( e.getActionCommand().equals("New") ) {
				UXMLFileOpen.play(this.parent);
			}
		}	
	}
	
}
