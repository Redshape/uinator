package org.uinator.code.haxe.printers;

import org.uinator.code.*;

public class BlockPrinter extends Printer {
 
	public BlockPrinter( Statement stm ) {
		super(stm);
	}
	
	@Override
	public String render() throws GeneratorException {
		String result = new String();
		
		for ( Statement stm:( (Container)this.getContext() ).getStatements() ) {
			result = result.concat( stm.getPrinter().render() );
		}
		
		return result;
	}

}
