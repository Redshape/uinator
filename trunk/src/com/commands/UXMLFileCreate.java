package com.commands;

import com.ui.EditWindow;

/**
 * @author nikelin
 */
public class UXMLFileCreate implements Command {
	private static EditWindow editWindow;
	
	public static void play( Commander commander ) {
		if ( editWindow == null) {
			editWindow = new EditWindow();
		}
		
		editWindow.setVisible(true);
		
		commander.processCommand(CommandType.UXML_FILE_CREATE, null);
	}
	
}
