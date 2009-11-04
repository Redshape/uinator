/**
 * Main class
 * 
 * @author nikelin
 */

import com.Application;
import com.ui.MainWindow;

import org.uinator.utils.*;
import java.io.File;

public class Main {

    public static void main(String args[]) {
        try {
        	Application.start();
            
        } catch ( Exception e ) {
            MainWindow.showException("Unexpected error", e );
        }
    }
}
