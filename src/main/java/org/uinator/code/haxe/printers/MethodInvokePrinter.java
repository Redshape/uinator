package org.uinator.code.haxe.printers;

import org.uinator.code.*;
import org.uinator.code.haxe.Variable;
import org.uinator.code.haxe.MethodInvoke;

public class MethodInvokePrinter extends Printer {

    public MethodInvokePrinter(Statement context) {
        super(context);
    }

    @Override
    public String render() throws GeneratorException {
        String result = new String();
        MethodInvoke context = (MethodInvoke) this.getContext();

        String alignment = this.getAlignment();
        if (context.getMethodName() == null) {
            throw new GeneratorException();
        }

        result = result.concat(alignment);

        if (context.getObjectContext() != null) {
            result = result.concat(context.getObjectContext().getName()).concat(".");
        }

        result = result.concat(context.getMethodName())
                       .concat("(");
        for (Variable arg : context.getArgs()) {
            VariablePrinter printer = (VariablePrinter)arg.getPrinter();
            if ( arg.getConstructionArgs() != null && arg.getConstructionArgs().size() != 0 ) {
                result = result.concat( printer.renderInstance() );
            } else {
                result = result.concat( printer.renderReference() );
            }
   
            if (context.getArgs().indexOf(arg) != context.getArgs().size() - 1) {
                result = result.concat(",");
            }
        }
        result = result.concat(")")
                       .concat(";")
                       .concat( Printer.NEW_LINE_CHARACTER );

        return result;
    }
}
