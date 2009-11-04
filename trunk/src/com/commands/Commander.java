package com.commands;

/**
 * Interface which all commands executors must implements
 * @author nikelin
 */
public interface Commander {
	
	/**
	 * Executor callback for commands requests
	 * @param CommandType ct
	 * @param Object data
	 * 
	 * @return void
	 */
	public void processCommand( CommandType ct, Object data );
	
}
