package org.uinator.components;

import java.util.*;


abstract public class Widget {

	List<Widget> widgets = new ArrayList<Widget>();
	Layout layout;
	
	public Widget setLayout( Layout layout ) {
		this.layout = layout;
		return this;
	}
	
	public Layout getLayout() {
		return this.layout;
	}
	
	public List<Widget> getWidgets() {
		return this.widgets;
	}
	
	public Widget addWidget( Widget widget ) {
		this.widgets.add(widget);
		return this;
	}
}
