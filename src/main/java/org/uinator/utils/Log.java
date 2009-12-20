/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.uinator.utils;

import org.uinator.io.adapter.Adapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author nikelin
 */
public class Log{

	private static Log instance;
    private Adapter _adapter;
    
    public void setAdapter( Adapter adapter ) {
        this._adapter = adapter;
    }

    public Adapter getAdapter() {
        return this._adapter;
    }

    public void write( Object message ) {
        try {
            this._adapter.write( this.formatMessage( message.toString() ) );
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
    
    protected String formatMessage( String message ) {
    	String result = new String();
    	result = result.concat( java.util.Calendar.getInstance().getTime().toString() );
    	result = result.concat( " - " );
    	result = result.concat( message );
    	result = result.concat( "\n\r" );
    	
    	return result;
    }

    public String read() {
        try {
            return this._adapter.read();
        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
    }

}
