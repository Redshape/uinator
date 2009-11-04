package org.uinator.code.haxe.printers;

import org.uinator.code.*;
import org.uinator.code.haxe.Field;

public class FieldPrinter extends Printer {
	
	public FieldPrinter(Statement context) {
		super(context);
	}

	@Override
	public String render() throws GeneratorException {
		String result = new String();
		Field context = (Field)this.getContext();

		if ( context.getName() == null ) {
			throw new GeneratorException();
		}
		
		result.concat( this.getAlignment() );
		
		if ( context.isStatic() ) {
			result = result.concat( "static ").concat( result );
		}
		
		if ( context.getAccess() != null ) {
			result = result.concat( context.getAccess() ).concat( " " );
		}
		
		result = result.concat( context.getName() );
		
		if ( context.getType() != null ) {
			result = result.concat( ":" ).concat( context.getType() );
		}
		
		if ( context.getValue() != null ) {
			result = result.concat( " = " ).concat( context.getValue() );
		}
		
		result = result.concat( ";" ).concat( String.valueOf( Printer.NEW_LINE_CHARACTER ) );
		
		return result;
	}
	
}
