package view;

import tetris.Tetris;
import tetris.RecordManager;

import javax.swing.*;

/**
 * The dialog box that is displayed at the end of the game.
 * When you click OK, a new game starts (the Tetris class is created anew),
 * when you click on the cross, the StartMenu class opens anew (the StartMenu
 * class is loaded again)
 */
public class FinishDialog {
    public FinishDialog(JFrame parentsFrame, String playerName, int score) {
        // Сохранение рекорда игрока
        RecordManager recordsManager = new RecordManager("src/main/resources/records.txt");
        recordsManager.addRecord(playerName, score);

        int answer = JOptionPane.showOptionDialog(null,
                "Do you want to restart?",
                "GAME OVER",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, new Object[]{"OK", "Cancel"}, "OK");

        if (answer == JOptionPane.OK_OPTION) {
            parentsFrame.dispose();
            new Tetris(playerName); // Передаем никнейм игрока в конструктор Tetris
        } else {
            parentsFrame.dispose();
            new StartMenu(); // Предполагаем, что у вас есть класс StartMenu
        }
    }
}