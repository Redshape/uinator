package com.uinator;
/**
 * Main class
 * 
 * @author nikelin
 */


import com.uinator.ui.Application;
import com.uinator.ui.MainWindow;

import org.uinator.utils.*;

import java.io.File;

public class Main {

    public static void main(String args[]) {
        try {
        	Application.start();
        } catch ( Throwable e ) {
            MainWindow.showException("Unexpected error", e );
        }
    }
}
