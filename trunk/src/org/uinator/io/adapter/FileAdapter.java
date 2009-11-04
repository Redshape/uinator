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
public class FileAdapter implements Adapter {

    public static final int TYPE_APPEND = 1;
    public static final int TYPE_REWRITE = 2;

    private String _path;

    public FileAdapter( String path ) {
        this._path = path;
    }

    public void setPath( String path ) {
        this._path = path;
    }

    public String getPath() {
        return this._path;
    }

    public String read() throws IOException {
        String result = new String();

        int res = 0;
        FileReader reader = new FileReader( new File( this.getPath() ) );
        do {
            char buff[] = new char[2048];
            res = reader.read(buff, res, 1024);
            result = result.concat(String.valueOf(buff));
        } while (res != -1);

        return result;
    }

    @Override
    public void write( Object message ) throws IOException {
        this.write( message, TYPE_APPEND );
    }

    /**
     * Write message to file using writeType-method
     * 
     * @param Object message All objects which have public method toString()
     * @param int writeType
     */
    public void write( Object message, int writeType ) throws IOException {
        FileWriter f = new FileWriter( new File( this.getPath() ) );
        switch( writeType ) {
            case TYPE_APPEND:
                f.append(message.toString());
            break;
            case TYPE_REWRITE:
                f.write( message.toString() );
            break;
            default:
                throw new IOException("writeType has unhandlable value");
        }
        f.close();
    }

}
