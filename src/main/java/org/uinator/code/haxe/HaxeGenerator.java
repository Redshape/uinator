package org.uinator.code.haxe;

import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

import org.uinator.utils.*;
import org.uinator.code.*;
import org.uinator.components.Widget;
import org.uinator.components.widget.*;


public class HaxeGenerator {

    private int _nextId = 0;
    private Map<Integer, String> _namesIndex;

    public HaxeGenerator() {
        this._namesIndex = new HashMap<Integer, String>();
    }

    public int getNextId() {
        this._nextId += 1;
        return this._nextId;
    }

    public String process(UI object) throws GeneratorException {
        Package mainPkg = Package.createEmpty();
        Class mainCls = mainPkg.addClass(new Class("Main", "MovieClip", null));

        for (org.uinator.components.Import imp : object.getImports()) {
            mainPkg.addImport(new Import(imp.getPath()));
        }
        
        Method entryPointMethod = mainCls.addMethod(new Method("main", Class.ACCESS_PUBLIC, "void", true));
        Variable mainClsContext = (Variable) entryPointMethod.addStatement(new Variable("main", "Main", "getInstance()"));

        Method initMethod = mainCls.addMethod(new Method("init", Class.ACCESS_PRIVATE, "void", false));
        this.processWidget(object, initMethod.getStatementsBlock());

        entryPointMethod.addStatement( new MethodInvoke(mainClsContext, "init") );

        return mainPkg.getPrinter().render();
    }

    /**
     * @param v
     * @return
     */
    protected Variable getObjectInstance(Object v, Variable... constructionArgs ) {
        return new VariableInstance(this.getVariableName(v), this.getClassName(v), null, Arrays.asList( constructionArgs ) );
    }

    protected String getClassName(Object v) {
        String name = v.getClass().getName();
        String[] nameParts = name.split("\\.");
        if (nameParts.length > 0) {
            name = nameParts[nameParts.length - 1];
        }

        return name;
    }

    /**
     * Generate name for object V and remember it to use in future requests
     * 
     * @param Object v
     * @return String
     */
    protected String getVariableName(Object v) {
        if ( !this._namesIndex.containsKey( v.hashCode() ) ) {
            String name = org.uinator.utils.StringUtils.toCamelCase( this.getClassName(v), "_", StringCase.LOWER);

            this._namesIndex.put(v.hashCode(), name.concat( String.valueOf( this.getNextId() ) ) );
        }

        return this._namesIndex.get(v.hashCode());
    }

    /**
     * Process widget object and append generated statements cascade
     * to context:Block
     *
     * @param Widget w
     * @param Block context
     * @return void
     */
    protected HaxeGenerator processWidget(Widget w, Block context) {
        Variable v = (Variable) context.addStatement( this.getObjectInstance(w) );
        for (Widget wC : w.getWidgets()) {
            this.processWidget(wC, context);

            context.addStatement(new MethodInvoke(v, "addWidget", this.getObjectInstance(wC)));
        }

        if (w.getLayout() != null) {
            context.addStatement(new MethodInvoke(v, "setLayout", this.getObjectInstance(w.getLayout())));
        }

        return this;
    }
}

