package com.hemebiotech.analytics.main;

import java.util.ArrayList;

import com.hemebiotech.analytics.beans.Symptom;
import com.hemebiotech.analytics.utility.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.utility.WriteSymptomDataIntoFile;

public class AnalyticsCounter {

	public static void main(String args[]) {

		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("symptoms.txt");

		readSymptomDataFromFile.loadSymptoms();

		ArrayList<Symptom> symptomsListObject = readSymptomDataFromFile.getSymptomsSorted();

		// Writting into file
		WriteSymptomDataIntoFile writeSymptomDataIntoFile = new WriteSymptomDataIntoFile("result.out");
		writeSymptomDataIntoFile.writeSymptoms(symptomsListObject);

	}
}
