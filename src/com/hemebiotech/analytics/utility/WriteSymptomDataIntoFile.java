package com.hemebiotech.analytics.utility;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.hemebiotech.analytics.beans.Symptom;
import com.hemebiotech.analytics.interfaces.ISymptomWriter;

/**
 * @author Babacar
 *
 */
public class WriteSymptomDataIntoFile implements ISymptomWriter {

	/**
	 * filepath a full or partial path to file with symptom strings in it, one per
	 * line
	 */
	private String filePath;

	/**
	 * @param filePath
	 */
	public WriteSymptomDataIntoFile(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public void writeSymptoms(List<Symptom> symptomsListObject) {

		try {

			FileWriter writeIntoFile = new FileWriter(filePath);

			for (Symptom symptom : symptomsListObject) {

				writeIntoFile.write(symptom.getName() + ": " + symptom.getNumberOfOccurences() + "\n");
			}

			writeIntoFile.close();

		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
