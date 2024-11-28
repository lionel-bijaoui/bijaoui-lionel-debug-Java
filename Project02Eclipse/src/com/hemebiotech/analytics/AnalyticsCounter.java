package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * A simple analytics counter that counts the number of each symptom
 */
public class AnalyticsCounter {
    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Reads symptoms  and returns them as a list
     *
     * @return List of symptoms
     */
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    /**
     * Counts the occurrences of each symptom
     *
     * @param symptoms List of symptoms
     * @return Map of symptoms and their occurrences
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCounts = new HashMap<>();
        for (String symptom : symptoms) {
            if (symptomCounts.containsKey(symptom)) {
                symptomCounts.put(symptom, symptomCounts.get(symptom) + 1);
            } else {
                symptomCounts.put(symptom, 1);
            }
        }
        return symptomCounts;
    }

    /**
     * Sorts the symptoms by their occurrences
     *
     * @param symptoms Map of symptoms and their occurrences
     * @return Map of symptoms and their occurrences sorted by occurrences
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }

    /**
     * Writes the symptoms
     *
     * @param symptoms Map of symptoms and their occurrences
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }

}
