/** 
 *
 * @author Supreet Totagi; sutotagi@in.ibm.com;
 * Copyright (C) 2014
 */
package com.service.API.Impl;
import java.io.FileNotFoundException;

import com.service.API.Exporter;
import com.service.factory.Alien;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * The Class PdfExporter. Exports the alien details into a PDF file.
 */
public class PdfExporter implements Exporter{

	/** The title of the export format. */
	private final String TITLE = "PDF";
	
	/**
	 * Instantiates a new pdf exporter.
	 */
	public PdfExporter() {};
	
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
		
        Document document = new Document();
        String fileName = "exports/alien_report.pdf"; 
        try {
                PdfWriter.getInstance(document, new FileOutputStream(fileName));
                document.open();
                String text = alien.getDetails();
                document.add(new Paragraph(text));
        } catch (DocumentException e) {
                System.err.println(e.getMessage());
        } catch (IOException ex) {
                System.err.println(ex.getMessage());
        }
        document.close();
				
		return fileName;
	}
	
}
