package tetris;

import java.io.*;
import java.util.*;

/**
 * A class for managing high score records for the Tetris game.
 * It provides methods to add new records, retrieve existing records, and save records to a file.
 */
public class RecordManager {
    private final String fileName;

    /**
     * Constructs a RecordManager with the specified file name.
     *
     * @param fileName the name of the file to store the records
     */
    public RecordManager(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Adds a new record for the specified player with the given score.
     * If the player already has a record, the new score replaces the old one.
     * Records are sorted by score in descending order, and only the top 3 records are kept.
     *
     * @param playerName the name of the player
     * @param score       the score achieved by the player
     */
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

    /**
     * Retrieves the current high score records.
     *
     * @return a map containing player names and their corresponding scores
     */
    public Map<String, Integer> getRecords() {
        return loadRecords();
    }

    /**
     * Loads high score records from the file.
     *
     * @return a map containing player names and their corresponding scores
     */
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

    /**
     * Saves high score records to the file.
     *
     * @param records a map containing player names and their corresponding scores
     */
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
