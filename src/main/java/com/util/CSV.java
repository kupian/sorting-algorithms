package com.util;

import com.algorithms.SortingAlgorithm;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;

public class CSV {

    public static void writeToFile(String fileName, Map<String, Map<String, Long>> content, SortingAlgorithm[] algorithms) {
        File file = new File(fileName);
        try {
            FileWriter fileWriter = new FileWriter(file);
            CSVWriter writer = new CSVWriter(fileWriter);

            // Create header from algorithms argument
            String[] header = new String[algorithms.length + 1];
            header[0] = "dataset";
            for (int i = 0; i < algorithms.length; i++) {
                header[i + 1] = algorithms[i].toString();
            }

            writer.writeNext(header);

            // Iterate through datasets and write rows
            for (String dataset : content.keySet()) {
                String[] row = new String[algorithms.length + 1];
                row[0] = dataset;
                int i = 1;
                for (String algorithm : content.get(dataset).keySet()) {
                    double runtime = content.get(dataset).get(algorithm);
                    row[i] = String.valueOf(runtime);
                    i++;
                }
                writer.writeNext(row);
            }

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
