package com.uinator.ui.commands;

import com.uinator.ui.EditWindow;

/**
 * @author nikelin
 */
public class UXMLFileCreate implements Command {
	private static EditWindow editWindow;
	
	public void play( Commander commander ) {
		if ( editWindow == null) {
			editWindow = new EditWindow();
		}
		
		editWindow.setVisible(true);
		
		commander.processCommand(CommandType.UXML_FILE_CREATE, null);
	}
	
}
