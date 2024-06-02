package controller;

import model.BoardController;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * A class that handles keyboard input for the Tetris game.
 * This class extends KeyAdapter to provide keyboard input handling functionality.
 */
public class TetrisKeyAdapter extends KeyAdapter {
    private final BoardController boardController;

    /**
     * Constructs a TetrisKeyAdapter with the specified BoardController.
     *
     * @param boardController the BoardController instance responsible for managing the game board
     */
    public TetrisKeyAdapter(BoardController boardController) {
        this.boardController = boardController;
    }

    /**
     * Invoked when a key has been pressed.
     * Handles various key events to control the Tetris game.
     *
     * @param e the KeyEvent instance representing the key press event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (!boardController.getBoard().isStarted()) {
            return;
        }

        int keycode = e.getKeyCode();
        switch (keycode) {
            case KeyEvent.VK_LEFT:
                if (boardController.ableMove(boardController.getBoard().getCurrentFigure(),
                        new java.awt.Point(boardController.getBoard().getCurX() - 1, boardController.getBoard().getCurY()))) {
                    boardController.move(boardController.getBoard().getCurrentFigure(),
                            new java.awt.Point(boardController.getBoard().getCurX() - 1, boardController.getBoard().getCurY()));
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (boardController.ableMove(boardController.getBoard().getCurrentFigure(),
                        new java.awt.Point(boardController.getBoard().getCurX() + 1, boardController.getBoard().getCurY()))) {
                    boardController.move(boardController.getBoard().getCurrentFigure(),
                            new java.awt.Point(boardController.getBoard().getCurX() + 1, boardController.getBoard().getCurY()));
                }
                break;
            case KeyEvent.VK_DOWN:
                boardController.down();
                break;
            case KeyEvent.VK_UP:
                boardController.rotate(BoardController.Rotation.RIGHT);
                break;
            case KeyEvent.VK_SPACE:
                boardController.dropDown();
                break;
        }
    }
}
