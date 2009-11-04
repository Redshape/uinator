package com;

import com.ui.MainWindow;

import org.uinator.utils.Log;
import org.uinator.io.adapter.FileAdapter;

/**
 * Main entry point for different applications interfaces (UI, console, etc.)
 * 
 * @author nikelin
 */
public class Application {
	
	/**
	 * Root path to system 
	 * @FIXME
	 * @var String
	 */
	public static String root_path = "./";
	
	/**
	 * @access Public
	 * @var Log
	 */
	public static Log default_logger;
	/**
	 * @access public
	 * @var Log
	 */
	public static Log errors_logger;
	
	/**
	 * Hingleton for system error log
	 * @return Log
	 */
	public static Log getErrorLog() {
		if ( null == errors_logger ) {
			errors_logger = new Log();
			errors_logger.setAdapter( new FileAdapter( Application.root_path.concat("logs/errors.log") ) );
		}
		
		return errors_logger;
	}
	
	/**
	 * Hingleton for default system log
	 * @return Log
	 */
	public static Log getLog() {
		if ( null == default_logger ) {
			default_logger = new Log();
			default_logger.setAdapter( new FileAdapter( Application.root_path.concat("logs/main.log") ) );
		}
		
		return default_logger;
	}
	
	/**
	 * Entry point of application
	 * 
	 * @return boid
	 */
    public static void start() {
        MainWindow wnd = new MainWindow();
        wnd.setVisible(true);
    }
}
