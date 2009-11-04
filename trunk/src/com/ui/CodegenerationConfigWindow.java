package com.ui;

import com.ui.EditWindow;

import javax.swing.*;
import org.uinator.Parser;
import org.uinator.widget.UI;
import org.uinator.code.haxe.HaxeGenerator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import java.io.File;
import java.io.FileReader;

public class CodegenerationConfigWindow extends JFrame {

	private EditWindow editWindow;
	private static final long serialVersionUID = -5262747335759871315L;
	private File _data_file;
	
	public CodegenerationConfigWindow() {
		super();
		
		this.editWindow = new EditWindow();
		
		this.setTitle("Codegeneration options");
		this.setSize( 500, 400 );
		this.setLayout( new BorderLayout() );
		
		this.initUI();
	}
	
	public void setFile( File f ) {
		this._data_file = f;
	}
	
	protected void initUI() {
		this.add( this.getCenterPanel(), BorderLayout.CENTER );
		this.add( this.getSouthPanel(), BorderLayout.SOUTH );
	}
	
	protected JPanel getCenterPanel() {
		JPanel panel = new JPanel();
		panel.setLayout( new GridLayout(8, 1) );
		
		JPanel haxeVersionPanel = new JPanel();
		haxeVersionPanel.add( new JLabel("HaXe compiler version:") );
		haxeVersionPanel.add( new JRadioButton("2.0", true ) );
		haxeVersionPanel.add( new JRadioButton("3.0", false ) );
		panel.add( haxeVersionPanel );
		
		JPanel asVersionPanel = new JPanel();
		asVersionPanel.add( new JLabel("ActionScript version:") );
		asVersionPanel.add( new JRadioButton("3.0", true ) );
		asVersionPanel.add( new JRadioButton("2.0", true ) );
		panel.add( asVersionPanel );
		
		panel.add( new JCheckBox("Compile to SWF?", true ) );
		panel.add( new JFileChooser() );
		
		return panel;
	}
	
	public void processFile() throws Exception {
        Parser parser = new Parser();
        
        UI resultObject = parser.parse(this._data_file);

        // @TODO: configuring codegeneration issues
		

        HaxeGenerator generator = new HaxeGenerator();
        
        this.showGenerated( generator.process(resultObject) );
	}
	
	protected void showGenerated( String data ) {
		this.setVisible(false);
		this.editWindow.setCode(data);
		this.editWindow.setVisible(true);
	}
	
	protected JPanel getSouthPanel() {
		JPanel panel = new JPanel();
		
		JButton processBtn = new JButton("Process");
		processBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					CodegenerationConfigWindow.this.processFile();
				} catch ( Exception e ) {
					MainWindow.showException(e.getMessage(), e);
				}
			}
			
		});
		panel.add( processBtn );
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CodegenerationConfigWindow.this.setVisible(false);
			}
		});
		panel.add( cancelBtn );
		
		return panel;
	}
	
}
