/** 
 *
 * @author Supreet Totagi; sutotagi@in.ibm.com;
 * Copyright (C) 2014
 */
package com.alien.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ServiceLoader;
import java.util.Set;

import com.service.factory.Alien;
import com.service.API.Exporter;

/**
 * The Class AlienDemo.
 */
public class AlienDemo {
	
	   /**
   	 * Gets the export services available.
   	 *
   	 * @return the key-value pair of available services
   	 */
   	public static HashMap<Integer, String> getServices() { 
		   
		   HashMap<Integer, String> services = new HashMap<Integer, String>();
		   int index = 1;
		   
		   ServiceLoader<Exporter> serviceLoader = ServiceLoader.load(Exporter.class);

		   for (Exporter provider : serviceLoader) {
			   services.put(index++, provider.getTitle());			  
		   }
		   
		   if(index == 0) {
			   throw new Error("Export plugins cannot be found");
		   }
		   
		   return services;

	   }
	   
	   /**
   	 * Register alien.
   	 *
   	 * @return the registered alien object
   	 * @throws IOException Signals that an I/O exception has occurred.
   	 */
   	public static Alien registerAlien() throws IOException {
		   
		   String codeName, bloodColor, homePlanet;
		   int numAntennas = 0, numLegs = 0;
		   
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		   
		   System.out.println("Alien Registration");
		   System.out.println("---------------------------");
		   
		   System.out.println("Code Name: ");
		   codeName = br.readLine();
		   
		   System.out.println("Blood Color: ");
		   bloodColor = br.readLine();
		   
		   System.out.println("No of Antennas: ");		   
		   try {
			   numAntennas = Integer.parseInt(br.readLine());
		   } catch (NumberFormatException e) {
			   System.out.println("Invalid input");
			   return null;
		   }
		   
		   System.out.println("No of Legs: ");
		   try {
			   numLegs = Integer.parseInt(br.readLine());
		   } catch (NumberFormatException e) {
			   System.out.println("Invalid input");
			   return null;
		   }	
		   
		   System.out.println("Home Planet: ");
		   homePlanet = br.readLine();	
		   
		   return Alien.getInstance(codeName, bloodColor, numAntennas, numLegs, homePlanet);
	   }
	   
	   /**
   	 * Export details of the registered alien.
   	 *
   	 * @param choice the export choice
   	 * @param alien the alien object
   	 * @throws FileNotFoundException the file not found exception
   	 */
   	public static void exportDetails(String choice, Alien alien) throws FileNotFoundException { 		   
		   
		   ServiceLoader<Exporter> serviceLoader = ServiceLoader.load(Exporter.class);

		   for (Exporter provider : serviceLoader) {
			  if(provider.getTitle().equals(choice)) {
				  String result = provider.export(alien);
				  System.out.println();
				  System.out.println("Data exported successfully: " + result);
				  break;
			  }
		   }

	   }	   

	   /**
   	 * The main method.
   	 *
   	 * @param ignored the default arguments
   	 * @throws IOException Signals that an I/O exception has occurred.
   	 */
   	public static void main(String[] ignored) throws IOException {
		   
		   Alien alien = AlienDemo.registerAlien();
		   
		   if(alien == null) {
			   System.out.println();
			   throw new Error("Failed to register the alien");
		   }
		   
		   System.out.println();
		   System.out.println("Alien registered successfully");
		   System.out.println();
		   
		   while(true) {
			   
			   System.out.println("Avalaible formats to export:");
	 		   
			   HashMap<Integer, String> services = AlienDemo.getServices();
			   
			   Set<Entry<Integer, String>> set = services.entrySet();
			   Iterator<Entry<Integer, String>> i = set.iterator();
		   
			   while(i.hasNext()) {
			      @SuppressWarnings("rawtypes")
			      Map.Entry me = (Map.Entry)i.next();
			      System.out.print(me.getKey() + ": ");
			      System.out.println(me.getValue());
			   }   
			   
			   System.out.println();
			   System.out.println("Please select the serial no. or 0 to cancel");
			   
			   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			   int choice = Integer.parseInt(br.readLine());
			   
			   if(choice == 0) {
				   System.out.println();
				   System.out.println("Export cancelled");	
				   break;
			   }
			   else if(!services.containsKey(choice)) {
				   System.out.println();
				   System.out.println("Invalid choice");
				   System.out.println();
			   }
			   else {
				   AlienDemo.exportDetails(services.get(choice), alien);
				   break;
			   }
		   }
	   }
	   
}
