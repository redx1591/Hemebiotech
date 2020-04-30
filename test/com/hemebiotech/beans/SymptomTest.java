package com.hemebiotech.beans;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.hemebiotech.analytics.beans.Symptom;

class SymptomTest {

	@Test
	void SymptomConstructor() {

		Symptom symptom = new Symptom("fever", 10);

		// Check that the object is created
		assertNotNull(symptom);

		// Check that the object returns the correct values
		assertEquals("fever", symptom.getName());
		assertEquals(10, symptom.getNumberOfOccurences());
	}

	@Test
	void SymptomComparator() {
		Symptom symptom_1 = new Symptom("inflamation", 10);
		Symptom symptom_2 = new Symptom("insomnia", 3);
		Symptom symptom_3 = new Symptom("headache", 5);
		Symptom symptom_4 = new Symptom("headache", 7);

		// Check if the comparator works correctly
		assertEquals(-13, symptom_1.compareTo(symptom_2));
		assertEquals(0, symptom_3.compareTo(symptom_4));
		assertEquals(13, symptom_2.compareTo(symptom_1));

	}

}
