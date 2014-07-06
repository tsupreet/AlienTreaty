/** 
 *
 * @author Supreet Totagi; sutotagi@in.ibm.com;
 * Copyright (C) 2014
 */
package com.service.factory;

/**
 * The Class Alien.
 */
public class Alien {
	
	/** The code name. */
	private String codeName;
	
	/** The blood color. */
	private String bloodColor;
	
	/** The number of antennas. */
	private int numAntennas;
	
	/** The number of legs. */
	private int numLegs;
	
	/** The home planet. */
	private String homePlanet;
	
	/**
	 * Instantiates a new alien.
	 *
	 * @param codeName the code name
	 * @param bloodColor the blood color
	 * @param numAntennas the number of antennas
	 * @param numLegs the number of legs
	 * @param homePlanet the home planet
	 */
	Alien(String codeName, String bloodColor, int numAntennas, int numLegs, String homePlanet) {
		this.codeName = codeName;
		this.bloodColor = bloodColor;
		this.numAntennas = numAntennas;
		this.numLegs = numLegs;
		this.homePlanet = homePlanet; 
	}
	
	/**
	 * Gets the single instance of Alien.
	 *
	 * @param codeName the code name
	 * @param bloodColor the blood color
	 * @param numAntennas the number antennas
	 * @param numLegs the number legs
	 * @param homePlanet the home planet
	 * @return single instance of Alien
	 */
	public static Alien getInstance(String codeName, String bloodColor, int numAntennas, int numLegs, String homePlanet) {
		Alien alien = new Alien(codeName, bloodColor, numAntennas, numLegs, homePlanet);
		return alien;
	}
	
	/**
	 * Gets the details.
	 *
	 * @return the details
	 */
	public String getDetails() {
		String alienDetails = "Code Name: " + codeName +'\n' +
							  "Blood Color: " + bloodColor +'\n' +
							  "No of Antennas: " + numAntennas +'\n' +
							  "No of Legs: " + numLegs +'\n' +
							  "Home Planet: " + homePlanet;
		
		return alienDetails;
	}
	
}
