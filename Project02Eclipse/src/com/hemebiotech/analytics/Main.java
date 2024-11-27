package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        AnalyticsCounter counter = new AnalyticsCounter(
                new ReadSymptomDataFromFile("symptoms.txt"),
                new WriteSymptomDataToFile("result.out")
        );

        List<String> rawSymptoms = counter.getSymptoms();

        Map<String, Integer> symptoms = counter.countSymptoms(rawSymptoms);

        Map<String, Integer> sortedSymptoms = counter.sortSymptoms(symptoms);

        counter.writeSymptoms(sortedSymptoms);
    }
}
