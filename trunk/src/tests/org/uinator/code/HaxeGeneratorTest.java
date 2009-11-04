package tests.org.uinator.code;

import org.junit.*;
import org.uinator.*;
import org.uinator.widget.*;
import org.uinator.widget.layout.*;
import org.uinator.code.haxe.*;


public class HaxeGeneratorTest {
	
	@Test
	public void main() {
		HaxeGenerator generator = new HaxeGenerator();
		
		try {
			String result = generator.process( this.getTestMoc() );
			
			org.junit.Assert.assertNotNull(result);
			System.out.println(result);
		} catch ( Exception e ) {
			e.printStackTrace();
			org.junit.Assert.fail( e.getMessage() );
		}
	}
	
	protected UI getTestMoc() {
		UI moc = new UI();
		moc.addImport( new org.uinator.Import("core.ui.form.*") ); 
		moc.addImport( new org.uinator.Import("libs.json.*") );
		Widget formWidget = moc.addWidget( new Form() );
		formWidget.setLayout( new Layout() );
		formWidget.addWidget( new TextField() );
		
		return moc;
	}
}
