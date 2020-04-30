package com.hemebiotech.analytics.interfaces;

import java.util.List;

import com.hemebiotech.analytics.beans.Symptom;

/**
 * Anything that will write data into an external file The important part is,
 * there is no return value from the operation.
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomWriter {

	/**
	 * If no data is available, return an empty List
	 * 
	 * @param symptomsListObject list of all object we want to write into file
	 * 
	 */
	void writeSymptoms(List<Symptom> symptomsListObject);
}
