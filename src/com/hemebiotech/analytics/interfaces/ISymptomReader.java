package com.hemebiotech.analytics.interfaces;

import java.util.HashMap;
import java.util.List;

import com.hemebiotech.analytics.beans.Symptom;

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
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 */
	List<String> GetSymptoms();

	/**
	 * If no data is available, return an empty List
	 * 
	 * @param symptomsList list of all symptoms obtained from a data source
	 * 
	 * @return a raw listing of all Symptoms, without duplicates elements
	 */
	List<Symptom> GetSymptomsUniqueObjects(List<String> symptomsList);

	/**
	 * If no data is available, return an empty List
	 * 
	 * @param symptomsList list of all symptoms obtained from a data source
	 * 
	 * @return a raw listing of all Symptoms, without duplicates elements
	 */
	HashMap<Integer, Symptom> GetSymptomsMapList(List<Symptom> symptomsListObject);

//	/**
//	 * 
//	 * @param symptomsList list of symptoms obtained from data source
//	 * 
//	 * @return a list of all Symptoms sorted by name
//	 */
//
//	List<String> GetSymptomsSortedByName(List<String> symptomsList);
//
//	/**
//	 * 
//	 * @param symptomsList list of symptoms obtained from data source
//	 * 
//	 * @return a HashMap list of all Symptoms Object
//	 */
//
//	HashMap<Integer, Symptom> GetSymptomsListObject(List<String> symptomsList);
//
//	/**
//	 * 
//	 * @param symptomsListObject list of symptoms object obtained from data source
//	 * 
//	 * @return a Map list of Symptoms Object sorted by name
//	 */
//
//	HashMap<Integer, Symptom> GetSymptomsObjectSortedByName(HashMap<Integer, Symptom> symptomsListObject);
//
//	/**
//	 * 
//	 * @param symptomsList list of symptoms obtained from data source
//	 * 
//	 * @return a Map list of Symptoms Object with occurences of each symptoms
//	 */
//
//	HashMap<Integer, Symptom> GetSymptomsObjectOccurences(List<String> symptomsList);

}
