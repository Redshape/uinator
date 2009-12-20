package org.uinator.code.haxe.printers;

import org.uinator.code.*;
import org.uinator.code.haxe.Import;

public class ImportPrinter extends Printer{

	public ImportPrinter(Statement context) {
		super(context);

	}

	@Override
	public String render() throws GeneratorException {
		String result = new String();
		Import context = (Import) this.getContext();
		
		if ( context.getPath() == null ) {
			throw new GeneratorException();
		}
		
		result = result.concat( this.getAlignment() )
					   .concat("import ")
					   .concat( context.getPath() ) 
					   .concat(";")
					   .concat( String.valueOf( Printer.NEW_LINE_CHARACTER ) );
		
		return result;
	}

}
