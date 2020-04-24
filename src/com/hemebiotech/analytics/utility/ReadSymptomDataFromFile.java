package com.hemebiotech.analytics.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

import com.hemebiotech.analytics.beans.Symptom;
import com.hemebiotech.analytics.interfaces.ISymptomReader;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (FileNotFoundException e) {
				System.out.println("Sorry but the file was not found please check the filepath");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	@Override
	public List<Symptom> GetSymptomsUniqueObjects(List<String> symptomsList) {

		List<String> symptomsListOrginial = new ArrayList<String>(symptomsList);
		List<Symptom> symptomsListObjectList = new ArrayList<Symptom>();
		LinkedHashSet<String> hashSet = new LinkedHashSet<>(symptomsList);

		symptomsList = new ArrayList<>(hashSet);

		for (String symptom : symptomsList) {

			symptomsListObjectList.add(new Symptom(symptomsList.indexOf(symptom), symptom,
					Collections.frequency(symptomsListOrginial, symptom)));
		}

		return symptomsListObjectList;
	}

	@Override
	public HashMap<Integer, Symptom> GetSymptomsMapList(List<Symptom> symptomsListObject) {

		HashMap<Integer, Symptom> symptomsMapList = new HashMap<Integer, Symptom>();

		if (!symptomsListObject.isEmpty()) {
			for (Symptom symptom : symptomsListObject) {

				symptomsMapList.put(symptomsListObject.indexOf(symptom), symptom);
			}

			return symptomsMapList;
		}

		return null;
	}

}
