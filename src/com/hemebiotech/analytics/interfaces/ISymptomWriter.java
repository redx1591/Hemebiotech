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

	void writeSymptoms(List<Symptom> symptomsListObject);
}
