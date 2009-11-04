package org.uinator.readers;

import java.util.ArrayList;

public class Node {

    private Object _value;
    private String _name;
    private String _namespace;
    private ArrayList<Node> _attributes;
    private ArrayList<Node> _childs;
    private ArrayList<Namespace> _namespaces;
    private Node _parent;

    public Node() {
        this._attributes = new ArrayList<Node>();
        this._childs = new ArrayList<Node>();
        this._namespaces = new ArrayList<Namespace>();
    }

    public Node(String name, Object value) {
        this();

        this._value = value;
        this._name = name;
    }

    public Node(String name, Object value, String namespace) {
        this(name, value);

        this._namespace = namespace;
    }

    public Node setValue(Object value) {
        this._value = value;
        return this;
    }

    public Node addChild(Node child) {
        this._childs.add(child);
        return this;
    }

    public Node addAttribute(String name, String value, String namespace) {
        this._attributes.add(new Node(name, value, namespace));
        return this;
    }

    public ArrayList<Node> getAttributes() {
        return this._attributes;
    }

    public ArrayList<Node> getChilds() {
        return this._childs;
    }

    public Node setParent(Node parent) {
        this._parent = parent;
        return this;
    }
    
    public Node getParent() {
    	return this._parent;
    }

    public String getName() {
        return this._name;
    }

    public Node setName(String name) {
        this._name = name;
        return this;
    }

    public Object getValue() {
        return this._value;
    }

    public void registerNamespace( Namespace ns ) {
        this._namespaces.add(ns);
    }

    public String getNamespace() {
        return this._namespace;
    }
    
    public Node getAttribute( String name ) {
    	for( Node attr : this.getAttributes() ) {
    		if ( attr.getName().equals(name) ) {
    			return attr;
    		}
    	}
    	
    	return null;
    }

    public Namespace getRegisteredNamespace( String name ) {
        for( Namespace namespace : this._namespaces) {
            if ( namespace.getName().equals(name) ) {
                return namespace;
            }
        }

        return null;
    }
}
