package com.hemebiotech.analytics.beans;

/**
 * <b>Symptom's class define the structure of a symptom.</b>
 * <p>
 * Symptom is characterized by the following information:
 * <ul>
 * <li>A unique identifier given only once</li>
 * <li>A name that is given to the symptom</li>
 * <li>A number that represent the occurences of the symptom</li>
 * </ul>
 * </p>
 * 
 * 
 * @author Babacar
 * @version 1.0
 */

public class Symptom implements Comparable<Symptom> {

	/**
	 * Symptom ID . This ID is can't change once define
	 * 
	 * @see Symptom(int, String)
	 * @see Symptom#getId()
	 */
	private final int id;

	/**
	 * The number of occurrences
	 * 
	 * @see Symptom#getNumberOfOccurences()
	 * @see Symptom#setNumberOfOccurences(int)
	 */
	private int numberOfOccurences;

	/**
	 * The name given to the Symptom
	 * 
	 * @see Symptom#getName()
	 * @see Symptom#setName(String)
	 * 
	 */
	private String name;

	// ------------------------------------
	// CONSTRUCTORS
	// ------------------------------------

	/**
	 * Symptom's constructor
	 * 
	 * <p>
	 * When we call the constructor, we set a unique id, This id will be the
	 * identifier of a symptom
	 * </p>
	 * 
	 * @param id     Symptom's unique identifier
	 * 
	 * @param name   Symptom's unique name
	 * 
	 * @param number Symptom's occurrences
	 * 
	 */
	public Symptom(int id, String name, int number) {
		this.id = id;
		this.name = name;
		this.numberOfOccurences = number;
	}

	// ------------------------------------
	// FUNCTIONS
	// ------------------------------------

	/**
	 * Override compareTo() method from the interface Comparable
	 * 
	 * @param symptom the symptom object that is compared
	 * 
	 * 
	 * @return a negative integer, zero, or a positive integer as this object is
	 *         less than, equal to, or greater than the specified object.
	 */
	@Override
	public int compareTo(Symptom symptom) {
		// TODO Auto-generated method stub
		return this.name.compareTo(symptom.name);
	}

	// ------------------------------------
	// GETTERS AND SETTERS
	// ------------------------------------

	/**
	 * Return the Symptom's occurences
	 * 
	 * @return number the number of Symptom occurences
	 */

	public int getNumberOfOccurences() {
		return numberOfOccurences;
	}

	/**
	 * Update the number of Symptom's occurences
	 * 
	 * @param number the new value of occurences
	 */

	public void setNumberOfOccurences(int number) {
		this.numberOfOccurences = number;
	}

	/**
	 * Return the name of the Symptom
	 * 
	 * @return the Symptom's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Update the name of the Symptom
	 * 
	 * @param name the new Symptom name
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return the Symptom unique identifier
	 * 
	 * @return Symptom's unique id
	 */

	public int getId() {
		return id;
	}

}
