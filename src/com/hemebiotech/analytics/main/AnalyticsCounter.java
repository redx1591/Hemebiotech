package com.hemebiotech.analytics.main;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import com.hemebiotech.analytics.beans.Symptom;
import com.hemebiotech.analytics.utility.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.utility.WriteSymptomDataIntoFile;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("symptoms.txt");

		List<String> symptomsList = readSymptomDataFromFile.GetSymptoms();

		List<Symptom> symptomsListObject = readSymptomDataFromFile.GetSymptomsUniqueObjects(symptomsList);

		HashMap<Integer, Symptom> symptomsMapListHashMap = readSymptomDataFromFile
				.GetSymptomsMapList(symptomsListObject);

		TreeMap<Integer, Symptom> symptomsListSortedMap = new TreeMap<Integer, Symptom>(symptomsMapListHashMap);

		symptomsListObject.sort(Symptom.BY_NAME);

		for (int i = 0; i < symptomsListSortedMap.size(); i++) {
			System.out.println(symptomsListSortedMap.get(i).getName() + ": "
					+ symptomsListSortedMap.get(i).getNumberOfOccurences());
		}

//
//
//		HashMap<Integer, Symptom> symptomsListObject = new HashMap<Integer, Symptom>();
//
//		LinkedHashSet<String> hashSet = new LinkedHashSet<>(symptomsyList);
//
//		ArrayList<String> listWithoutDuplicates = new ArrayList<>(hashSet);
//
//		for (int i = 0; i < listWithoutDuplicates.size(); i++) {
//
//			symptomsListObject.put(i, new Symptom(i, listWithoutDuplicates.get(i),
//					Collections.frequency(symptomsyList, listWithoutDuplicates.get(i))));
//		}
//
//		for (int i = 0; i < symptomsListObject.size(); i++) {
//
//			System.out.println(
//					symptomsListObject.get(i).getName() + ": " + symptomsListObject.get(i).getNumberOfOccurences());
//		}

		// // first get input
//		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
//		String line = reader.readLine();
//
//		int i = 0;	// set i to 0
//		int headCount = 0;	// counts headaches
//		while (line != null) {
//			i++;	// increment i
//			System.out.println("symptom from file: " + line);
//			if (line.equals("headache")) {
//				headCount++;
//				System.out.println("number of headaches: " + headCount);
//			}
//			else if (line.equals("rush")) {
//				rashCount++;
//			}
//			else if (line.contains("pupils")) {
//				pupilCount++;
//			}
//
//			line = reader.readLine();	// get another symptom
//		}
// TODO Decommentez
		// next generate output

		WriteSymptomDataIntoFile writeSymptomDataIntoFile = new WriteSymptomDataIntoFile("result.out");

		writeSymptomDataIntoFile.writeSymptoms(symptomsListObject);
	}
}
