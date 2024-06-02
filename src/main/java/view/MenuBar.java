package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * A menu bar for the Tetris game window, providing options for game information, rules, records, and exiting the game.
 */
public class MenuBar extends JMenuBar {
    /**
     * Constructs a MenuBar with the specified parent JFrame.
     *
     * @param parentsFrame the parent JFrame
     */
    public MenuBar(JFrame parentsFrame) {
        JMenu menu = new JMenu("Game");

        JMenuItem infoItem = new JMenuItem("Info");
        JMenuItem rulesItem = new JMenuItem("Rules");
        JMenuItem recordsItem = new JMenuItem("Records");
        JMenuItem exitItem = new JMenuItem("Exit");

        infoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showOptionDialog(null,
                            Files.readString(Paths.get("src/main/resources/info.txt")),
                            "INFO",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null, null, null);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        rulesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showOptionDialog(null,
                            Files.readString(Paths.get("src/main/resources/rules.txt")),
                            "RULES",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null, null, null);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        recordsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showOptionDialog(null,
                            Files.readString(Paths.get("src/main/resources/records.txt")),
                            "RECORDS",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null, null, null);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int answer = JOptionPane.showOptionDialog(null,
                        "Do you want to exit?",
                        "EXIT",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, null, null);

                if (answer == JOptionPane.YES_OPTION) {
                    parentsFrame.dispose();
                }
            }
        });

        menu.add(infoItem);
        menu.add(rulesItem);
        menu.add(recordsItem);
        menu.add(exitItem);
        menu.add(new JSeparator());

        this.add(menu);
        this.setBackground(new Color(12, 12, 12, 124));
    }
}
