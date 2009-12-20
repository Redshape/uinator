/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.uinator.io.adapter;

import java.io.*;

/**
 *
 * @author nikelin
 */
public class ConsoleAdapter implements Adapter {

    @Override
    public String read() throws IOException {
        String result = new String();

        BufferedReader buffer = new BufferedReader( new InputStreamReader(System.in) );
        result = buffer.readLine();

        return result;
    }

    @Override
    public void write( Object message ) throws IOException {
        System.out.print( message );
    }
}
