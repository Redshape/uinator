package com.uinator.ui.commands;

import javax.swing.*;
import com.uinator.ui.MainWindow;

public class UXMLFileOpen implements Command {

	public void play( Commander context ) {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		//fc.setFileFilter( new UxmlFileFilter() );
		
		int ret = fc.showOpenDialog( (JFrame)context );
		if ( ret == JFileChooser.APPROVE_OPTION ) {
			context.processCommand( CommandType.UXML_FILE_OPEN, fc.getSelectedFile() );
		}	
	}

	
}
