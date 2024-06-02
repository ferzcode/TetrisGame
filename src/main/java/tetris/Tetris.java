package tetris;

import controller.TetrisKeyAdapter;
import model.Board;
import model.BoardController;
import view.BoardDrawer;
import view.FinishDialog;
import view.StatusBar;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The main class of the game that creates the main
 * components of the window and launches the game.
 * Tetris game implementation with GUI.
 */
public class Tetris extends JFrame {
    /** The name of the game */
    public final static String gameName = "Tetris";

    /** Delay between updates */
    public static final int DELAY = 100;
    /** Period for generating new figures */
    public static final int PERIOD = 700;

    /** The name of the player */
    private String playerName;
    /** The game board */
    private final Board board;
    /** Controller for the game board */
    private final BoardController boardController;
    /** Drawer for the game board */
    private final BoardDrawer boardDrawer;
    /** Status bar displaying game information */
    private final StatusBar statusBar;
    /** Timer for managing game updates */
    private final Timer timer;

    /**
     * Constructs a Tetris game with the specified player name.
     *
     * @param playerName the name of the player
     */
    public Tetris(String playerName) {
        this.playerName = playerName;
        board = new Board();
        boardDrawer = new BoardDrawer(board);
        statusBar = new StatusBar();
        statusBar.setStatusBarText("Player: " + playerName);
        boardController = new BoardController(board);
        timer = new Timer();

        init();
        start();
    }

    /**
     * Initializes the game window and components.
     */
    public void init() {
        boardController.addObserver(boardDrawer);
        boardController.addObserver(statusBar);
        boardDrawer.setFocusable(true);
        boardDrawer.addKeyListener(new TetrisKeyAdapter(boardController));

        add(statusBar, BorderLayout.NORTH);
        add(boardDrawer);

        setTitle(gameName);
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Starts the game by scheduling updates and creating the initial figure.
     */
    public void start() {
        timer.scheduleAtFixedRate(new CurrentTask(), DELAY, PERIOD);
        board.setStarted(true);
        boardController.clearBoard();
        boardController.createNewFigure();
    }

    /**
     * Updates the game state.
     */
    private void update() {
        if (board.isFellStatus()) {
            board.setFellStatus(false);
            boardController.createNewFigure();
        } else {
            boardController.down();
        }
    }

    /**
     * A TimerTask to update the game state.
     */
    class CurrentTask extends TimerTask {
        @Override
        public void run() {
            if (board.isStarted()) {
                update();
                boardDrawer.repaint();
            } else {
                timer.cancel();
                timer.purge();
                statusBar.setStatusBarText("Game over");

                // Saving the player's record
                FinishDialog finishDialog = new FinishDialog(Tetris.this, playerName, boardController.getBoard().getNumberLinesRemoved());
            }
        }
    }
}
