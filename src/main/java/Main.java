import view.StartMenu;

import java.awt.*;

/**
 * The main entry point for the Tetris game. It initializes and starts the game by displaying the start menu.
 */
public class Main {
    /**
     * The main method that starts the Tetris game.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            final StartMenu startMenu = new StartMenu(); // Display the start menu
        });
    }
}
