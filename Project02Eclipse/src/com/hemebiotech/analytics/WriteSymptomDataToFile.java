package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of the ISymptomWriter interface that writes symptoms and their occurrences to a file
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
    /**
     * Logger for the class
     */
    private static final Logger logger = Logger.getLogger(WriteSymptomDataToFile.class.getName());

    /**
     * Filepath of the file to write to
     */
    private final String filepath;

    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            FileWriter writer = new FileWriter(filepath);
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error writing to file: " + filepath, e);
        }
    }
}
