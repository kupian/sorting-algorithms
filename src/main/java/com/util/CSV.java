package com.util;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;

public class CSV {

    public static void writeToFile(String fileName, Map<String, Map<String, Long>> content) {
        File file = new File(fileName);
        try {
            FileWriter fileWriter = new FileWriter(file);
            CSVWriter writer = new CSVWriter(fileWriter);

            String[] header = {"algorithm", "dataset", "runtime"};
            writer.writeNext(header);

            for (String algorithm : content.keySet()) {
                for (String dataset : content.get(algorithm).keySet()) {
                    long runtime = content.get(algorithm).get(dataset);
                    String[] row = {algorithm, dataset, String.valueOf(runtime)};
                    writer.writeNext(row);
                }
            }

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
