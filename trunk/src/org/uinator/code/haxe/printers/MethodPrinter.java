package org.uinator.code.haxe.printers;

import org.uinator.code.*;
import org.uinator.code.haxe.Variable;
import org.uinator.code.haxe.Method;

public class MethodPrinter extends Printer {

	
	public MethodPrinter(Statement context) {
		super(context);
	}

	public String render() throws GeneratorException {
            String result = new String();
            Method context = (Method) this.getContext();

            String alignment = this.getAlignment();

            result = result.concat( alignment );
            if ( context.isStatic() ) {
                result = result.concat( "static " );
            }

            result = result.concat( context.getAccess()
                           .concat(" function ")
                           .concat( context.getName() ) );

            result = result.concat( "(" );
            for( Variable arg:context.getArgs() ) {
                result = result.concat( arg.getPrinter().render() );
            }
            result = result.concat(")");

            if ( context.getType() != null ) {
                result = result.concat( ": " + context.getType() );
            }

            result = result.concat( " { " )
                           .concat( String.valueOf( Printer.NEW_LINE_CHARACTER ) )
                           .concat( context.getStatementsBlock().getPrinter().render() )
                           .concat(alignment)
                           .concat( " } " )
                           .concat( Printer.NEW_LINE_CHARACTER );

            return result;
	}
}
