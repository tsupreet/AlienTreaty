/** 
 *
 * @author Supreet Totagi; sutotagi@in.ibm.com;
 * Copyright (C) 2014
 */
package com.service.API;

import java.io.FileNotFoundException;

import com.service.factory.Alien;

/**
 * The Interface Exporter. Acts as a service provider for exporting alien details.
 */
public interface Exporter {
	
	/**
	 * Gets the title of export format.
	 *
	 * @return the title
	 */
	String getTitle();
	
	/**
	 * Exports the alien details into particular format.
	 *
	 * @param alien the alien object
	 * @return the path of the exported file
	 * @throws FileNotFoundException the file not found exception
	 */
	String export(Alien alien) throws FileNotFoundException;
}
