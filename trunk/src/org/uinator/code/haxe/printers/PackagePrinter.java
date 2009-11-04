package org.uinator.code.haxe.printers;

import org.uinator.code.*;
import org.uinator.code.haxe.Package;
import org.uinator.code.haxe.Class;
import org.uinator.code.haxe.Import;

public class PackagePrinter extends Printer {

    public PackagePrinter(Statement context) {
        super(context);
    }

    @Override
    public String render() throws GeneratorException {
        String result = new String();
        Package context = (Package) this.getContext();

        result = result.concat(this.getAlignment());
        result = result.concat("package")
                       .concat(" ")
                       .concat(context.getName())
                       .concat(";")
                       .concat(String.valueOf(Printer.NEW_LINE_CHARACTER));

        for (Import imp : context.getImports()) {
            result = result.concat(imp.getPrinter().render());
        }

        for (Class cls : context.getClasses()) {
            result = result.concat(cls.getPrinter().render());
        }

        return result;
    }
}
