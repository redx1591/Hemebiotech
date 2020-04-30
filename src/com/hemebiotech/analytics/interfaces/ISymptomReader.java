package com.hemebiotech.analytics.interfaces;

/**
 * Anything that will read symptom data from a source The important part is, the
 * return value from the operation, which is a list of strings, that may contain
 * many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 * It load symptoms from a files and create Symptom object into memory and save
	 * it in a variable that is accessible from the class that implement
	 * 
	 */
	void loadSymptoms();

}
