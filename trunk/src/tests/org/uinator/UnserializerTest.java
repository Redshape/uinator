package tests.org.uinator;

import org.junit.*;
import org.uinator.*;
import org.uinator.readers.*;
import org.uinator.reflection.*;

public class UnserializerTest {
	
	
	@Test
	public void main() {
		Unserializer processor = new Unserializer( this.getReflectionProvider() );
		
		try {
			Node tObject = this.getTestObject();
			TestClassA result = (TestClassA) processor.process( TestClassA.class, tObject );
			
			Assert.assertEquals( result._x, Integer.parseInt( (String)tObject.getAttribute("_x").getValue() ) );
			Assert.assertEquals( result._y, Integer.parseInt( (String)tObject.getAttribute("_y").getValue() ) );
			Assert.assertEquals( result._z, Integer.parseInt( (String)tObject.getAttribute("_z").getValue() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			org.junit.Assume.assumeNoException(e);
		}
	}
	
	protected ReflectionProvider getReflectionProvider() {
		return new BaseReflectionProvider();
	}
	
	public Node getTestObject() {
		Node tObject = new Node("ui", null);
		tObject.registerNamespace( new Namespace("uinator", "tests.org.uinator") );
		tObject.addAttribute("_x", "22", null);
		tObject.addAttribute("_y", "33", null);
		tObject.addAttribute("_z", "3444", null);
		
		Node widgetB = tObject.addChild( new Node("test_class_a", null, "uinator") );
		widgetB.addAttribute("_a", "22", null);
		
		Node widgetC = tObject.addChild( new Node("test_class_a", null, "uinator" ) );
		widgetC.addAttribute("_a", "33", null);
		
		return tObject;
	}
	
}
