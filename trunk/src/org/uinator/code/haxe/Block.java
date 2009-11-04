package org.uinator.code.haxe;

import org.uinator.code.*;
import org.uinator.code.haxe.printers.BlockPrinter;

public class Block extends Container {
	
	public Printer getPrinter() {
		return new BlockPrinter(this);
	}
	
}
