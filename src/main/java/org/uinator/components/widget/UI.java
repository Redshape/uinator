package org.uinator.components.widget;

import java.util.*;

import org.uinator.components.Import;
import org.uinator.components.Widget;

public class UI extends Widget {

	List<Import> imports = new ArrayList<Import>();
	
	public List<Import> getImports() {
		return this.imports;
	}
	
	public UI addImport( Import imp ) {
		this.imports.add( imp );
		return this;
	}
	
}
