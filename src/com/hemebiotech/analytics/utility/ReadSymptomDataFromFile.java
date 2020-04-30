package com.hemebiotech.analytics.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;

import com.hemebiotech.analytics.beans.Symptom;
import com.hemebiotech.analytics.interfaces.ISymptomReader;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	private HashMap<String, Symptom> symptomsList = new HashMap<String, Symptom>();

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void loadSymptoms() {

		if (filepath != null) {

			if (checkFileValidity()) {

				try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {

					String line = reader.readLine();

					while (line != null) {

						if (symptomsList.get(line) != null) {

							symptomsList.get(line).incrementOccurences();
						} else {
							symptomsList.put(line, new Symptom(line, 1));
						}
						line = reader.readLine();
					}

				} catch (FileNotFoundException e) {
					System.out.println("Sorry but the file was not found please check the filepath");

				} catch (IOException e) {
					System.out.println("Sorry but an error occur we cannont read the file`");
				}
			}

		}

	}

	/**
	 * Return a Hashmap of Symptoms object.
	 * 
	 * @return symptomsList a list of Symptoms object
	 */

	public HashMap<String, Symptom> getSymptomsList() {
		return symptomsList;
	}

	/**
	 * Return the list of Symptoms sorted by name
	 * 
	 * @return a list of Symptoms object sorted by name
	 */

	public ArrayList<Symptom> getSymptomsSorted() {

		// We create a List of symptoms object
		ArrayList<Symptom> symptomsSetList = new ArrayList<Symptom>(this.symptomsList.values());

		// We sort Symptoms by name using a comparator
		symptomsSetList.sort(Symptom.BY_NAME);

		return symptomsSetList;

	}

	/**
	 * The function check if the file is a valid using different steps: 1 - Check if
	 * the file path exist 2 - Check if the file is not empty 3 - Check if the file
	 * format is a text
	 * 
	 * If the file pass all the test so it's a valid file otherwise it will print
	 * the error into console
	 * 
	 * @return boolean true means the format and the file is correct otherwise it
	 *         return false
	 * 
	 */
	private boolean checkFileValidity() {

		boolean validity = false;
		if (filepath != null) {

			File file;

			try {
				file = new File(filepath);
				// Check if the file does not exist
				if (!file.exists()) {
					System.out.println("Sorry but the file you try to read does not exist");
				}
				// Check if the file is empty
				if (file.length() == 0) {
					System.out.println("Sorry but the file you try to read is empty");
				}
				validity = true;
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
				return false;
			}

			// Check if the file format is correct
			try {
				String type = Files.probeContentType(file.toPath());
				if (type == null) {
					// type couldn't be determined, assume binary
					System.out.println("Sorry but this file can't be read because it's a binary file");
				} else if (type.startsWith("text")) {
					validity = true;
				} else {
					// type isn't text
					System.out.println("Sorry but thie file format is not correct");
				}
			} catch (IOException error) {
				System.out.println(error.getMessage());
				return false;
			}

		}
		return validity;

	}

}
