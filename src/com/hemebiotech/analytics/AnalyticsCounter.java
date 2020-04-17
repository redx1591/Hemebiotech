package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

import com.hemebiotech.analytics.beans.Symptom;

public class AnalyticsCounter {
	private static int headacheCount = 0; // initialize to 0
	private static int rashCount = 0; // initialize to 0
	private static int pupilCount = 0; // initialize to 0

	public static void main(String args[]) throws Exception {

		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("symptoms.txt");

		List<String> symptomsyList = readSymptomDataFromFile.GetSymptoms();

		Collections.sort(symptomsyList);

		HashMap<Integer, Symptom> symptomsListObject = new HashMap<Integer, Symptom>();

		LinkedHashSet<String> hashSet = new LinkedHashSet<>(symptomsyList);

		ArrayList<String> listWithoutDuplicates = new ArrayList<>(hashSet);

		for (int i = 0; i < listWithoutDuplicates.size(); i++) {

			symptomsListObject.put(i, new Symptom(i, listWithoutDuplicates.get(i),
					Collections.frequency(symptomsyList, listWithoutDuplicates.get(i))));
		}

		for (int i = 0; i < symptomsListObject.size(); i++) {

			System.out.println(
					symptomsListObject.get(i).getName() + ": " + symptomsListObject.get(i).getNumberOfOccurences());
		}
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

		// next generate output
		FileWriter writer = new FileWriter("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
