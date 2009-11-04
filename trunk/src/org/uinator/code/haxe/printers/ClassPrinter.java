package org.uinator.code.haxe.printers;

import org.uinator.code.*;
import org.uinator.code.haxe.Class;
import org.uinator.code.haxe.*;

public class ClassPrinter extends Printer {
	
	public ClassPrinter(Statement context ) {
		super(context);
	}
	
	@Override
	public String render() throws GeneratorException {
		String result = new String();
		Class context = (Class)this.getContext();
			
		if ( context.getName() == null ) {
			throw new GeneratorException();
		}
		
		String alignment = this.getAlignment();
		
		result = result.concat(alignment).concat("public class ").concat( context.getName() );
		
		if ( context.getParentCls() != null ) {
			result = result.concat( " extends " ).concat( context.getParentCls() );
		}
		
		for ( String interfaceName : context.getImplementsList() ) {
			result = result.concat(" ").concat( interfaceName );
			if ( context.getImplementsList().indexOf(interfaceName) != ( context.getImplementsList().size() - 1 ) ) {
				result = result.concat( "," );
			}
		}
		
		result = result.concat(alignment)
					   .concat("{ ")
					   .concat( String.valueOf( Printer.NEW_LINE_CHARACTER ) );
		
		for ( Field classField:context.getFields() ) {
			result = result.concat( classField.getPrinter().render() );
		}
		
		for ( Method classMethod:context.getMethods() ) {
			result = result.concat( classMethod.getPrinter().render() );
		}
		result = result.concat( String.valueOf( Printer.NEW_LINE_CHARACTER ) )
				 .concat(alignment)
				 .concat("}");
		
		return result;
	}
	
}
