package org.uinator.readers;

/**
 *
 * @author nikelin
 */
public class Namespace {

    private String _name;
    private String _path;

    public Namespace( String name, String path ) {
        this._name = name;
        this._path = path;
    }

    public String getName() {
        return this._name;
    }

    public String getPath() {
        return this._path;
    }

}
