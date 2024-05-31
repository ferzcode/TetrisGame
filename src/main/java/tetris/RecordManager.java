package tetris;

import java.io.*;
import java.util.*;

public class RecordManager {
    private final String fileName;

    public RecordManager(String fileName) {
        this.fileName = fileName;
    }

    public void addRecord(String playerName, int score) {
        Map<String, Integer> records = loadRecords();
        records.put(playerName, score);

        // Sort records by score in descending order
        List<Map.Entry<String, Integer>> sortedRecords = new ArrayList<>(records.entrySet());
        sortedRecords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Keep only top 3 records
        if (sortedRecords.size() > 3) {
            sortedRecords = sortedRecords.subList(0, 3);
        }

        // Convert back to a map
        records = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : sortedRecords) {
            records.put(entry.getKey(), entry.getValue());
        }

        saveRecords(records);
    }

    public Map<String, Integer> getRecords() {
        return loadRecords();
    }

    private Map<String, Integer> loadRecords() {
        Map<String, Integer> records = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String playerName = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    records.put(playerName, score);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return records;
    }

    private void saveRecords(Map<String, Integer> records) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, Integer> entry : records.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
                System.out.println("Saved record: " + entry.getKey() + " - " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
