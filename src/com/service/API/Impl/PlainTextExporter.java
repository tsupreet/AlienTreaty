/** 
 *
 * @author Supreet Totagi; sutotagi@in.ibm.com;
 * Copyright (C) 2014
 */
package com.service.API.Impl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import com.service.API.Exporter;
import com.service.factory.Alien;

/**
 * The Class PlainTextExporter. Exports the alien details into a plain text file.
 */
public class PlainTextExporter implements Exporter {
	
	/** The title of the export format. */
	private final String TITLE = "Plain Text";
	
	/**
	 * Instantiates a new plain text exporter.
	 */
	public PlainTextExporter() {};
	
	/* (non-Javadoc)
	 * @see com.service.API.Exporter#getTitle()
	 */
	@Override
	public String getTitle() {
		return TITLE;
	}

	/* (non-Javadoc)
	 * @see com.service.API.Exporter#export(com.service.factory.Alien)
	 */
	@Override
	public String export(Alien alien) throws FileNotFoundException {
		
		BufferedWriter writer = null;
		String fileName = "exports/alien_report.txt";
		File textFile = new File(fileName);
		
		try {
            writer = new BufferedWriter(new FileWriter(textFile));
            writer.write(alien.getDetails());			
		}catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            	
            }
        }
		return fileName;
	}
	
}