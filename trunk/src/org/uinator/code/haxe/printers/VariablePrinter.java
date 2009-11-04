package org.uinator.code.haxe.printers;

import org.uinator.code.*;
import org.uinator.code.GeneratorException;
import org.uinator.code.haxe.Variable;

public class VariablePrinter extends Printer {

	public static final int TYPE_DEFINITION = 1;
	public static final int TYPE_INSTANCE = 2;
	public static final int TYPE_REFERENCE = 3;
	
	private int _type;
	
    public VariablePrinter( Statement context ) {
        super(context);
    }
    
    public VariablePrinter( Statement context, int type ) {
    	super( context );
    	
    	this._type = type;
    }

    @Override
    public String render() throws GeneratorException {
    	String result = new String();
    	
    	switch ( this._type ) {
    		case TYPE_INSTANCE:
    			result = this.renderInstance();
    		break;
    		case TYPE_REFERENCE:
    			result = this.renderReference();
    		break;
    		case TYPE_DEFINITION:
    		default:
    			result = this.renderDefinition();
    		
    	}
    	
    	return result;
    }
    
    public String renderDefinition() throws GeneratorException {
        Variable context = (Variable) this.getContext();

        String result = new String();
        result = result.concat(this.getAlignment())
                       .concat("var ")
                       .concat( context.getName() );

        if (context.getType() != null) {
            result = result.concat(":")
                           .concat(context.getType());
        }

        if (context.getValue() != null) {
            result = result.concat(" = ")
                           .concat(context.getValue());
        }

        result = result.concat(";")
                       .concat( Printer.NEW_LINE_CHARACTER );

        return result;
    }

    public String renderReference() throws GeneratorException {
        Variable context = (Variable) this.getContext();
        if ( context.getName() == null ) {
            throw new GeneratorException();
        }

        String result = new String();
        result = result.concat( context.getName() );

        return result;
    }

    public String renderInstance() throws GeneratorException {
        Variable context = (Variable) this.getContext();
        if ( context.getName() == null ) {
            throw new GeneratorException();
        }

        String result = new String();
        result = result.concat( this.getAlignment() ) 
        			   .concat("var ")
        			   .concat( context.getName() )
        			   .concat( ":" )
        			   .concat( context.getType() )
        			   .concat( " = ")
        			   .concat( "new " )
				       .concat( context.getType() )
				       .concat( "(" );
        
        if ( context.getConstructionArgs() != null ) {
            for ( Variable arg:context.getConstructionArgs() ) {
                result = result.concat( arg.getName() )
                               .concat(",");
            }    
        }
        
        result = result.concat(")")
        			   .concat( Printer.NEW_LINE_CHARACTER );

        return result;
    }
}
