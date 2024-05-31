package tetris;

import model.BoardController;
import controller.TetrisKeyAdapter;
import model.Board;
import view.BoardDrawer;
import view.FinishDialog;
import view.StatusBar;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The main class of the game that creates the main
 * components of the window and launches the game
 */
public class Tetris extends JFrame {
    public final static String gameName = "Tetris";

    public static final int DELAY = 100;
    public static final int PERIOD = 700;

    private String playerName; // Никнейм игрока
    private final Board board;
    private final BoardController boardController;
    private final BoardDrawer boardDrawer;
    private final StatusBar statusBar;
    private final Timer timer;

    public Tetris(String playerName) { // Изменённый конструктор для передачи никнейма игрока
        this.playerName = playerName; // Сохраняем переданный никнейм игрока
        board = new Board();
        boardDrawer = new BoardDrawer(board);
        statusBar = new StatusBar();
        statusBar.setStatusBarText("Player: " + playerName); // Устанавливаем никнейм игрока в StatusBar
        boardController = new BoardController(board);
        timer = new Timer();

        init();
        start();
    }

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

    public void start() {
        timer.scheduleAtFixedRate(new CurrentTask(), DELAY, PERIOD);
        board.setStarted(true);
        boardController.clearBoard();
        boardController.createNewFigure();
    }

    private void update() {
        if (board.isFellStatus()) {
            board.setFellStatus(false);
            boardController.createNewFigure();
        } else {
            boardController.down();
        }
    }

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

                // Сохранение рекорда игрока
                FinishDialog finishDialog = new FinishDialog(Tetris.this, playerName, boardController.getBoard().getNumberLinesRemoved());
            }
        }
    }
}
