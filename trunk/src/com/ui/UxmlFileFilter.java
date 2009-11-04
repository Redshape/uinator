package com.ui;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class UxmlFileFilter extends FileFilter {
	@Override
	public boolean accept(File pathname) {
		return pathname.getAbsolutePath().contains(".xml");
	}
	
	public String getDescription() {
		return "Only *.xml files";
	}
}
