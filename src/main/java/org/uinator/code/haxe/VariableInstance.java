package org.uinator.code.haxe;

import java.util.List;
import org.uinator.code.*;
import org.uinator.code.haxe.printers.VariablePrinter;

public class VariableInstance extends Variable {

	public VariableInstance(String name, String type, String value,
			List<Variable> constructionArgs) {
		super(name, type, value, constructionArgs);
	}


	@Override
	public Printer getPrinter() {
		return new VariablePrinter( this, VariablePrinter.TYPE_INSTANCE );
	}

	
}
