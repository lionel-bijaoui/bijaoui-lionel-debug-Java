package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface for writing symptoms and their occurrences
 */
public interface ISymptomWriter {
    /**
     * Writes a list of symptoms and their occurrences.
     *
     * @param symptoms Map containing symptoms as keys and their count of occurrences as values
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
