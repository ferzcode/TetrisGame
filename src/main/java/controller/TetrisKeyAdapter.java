package controller;

import model.BoardController;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * A class that handles keyboard input for the Tetris game.
 */
public class TetrisKeyAdapter extends KeyAdapter {
    private final BoardController boardController;

    public TetrisKeyAdapter(BoardController boardController) {
        this.boardController = boardController;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!boardController.getBoard().isStarted())
            return;

        int keycode = e.getKeyCode();
        switch (keycode) {
            case KeyEvent.VK_LEFT: {
                if (boardController.ableMove(boardController.getBoard().getCurrentFigure(),
                        new java.awt.Point(boardController.getBoard().getCurX() - 1, boardController.getBoard().getCurY())))
                    boardController.move(boardController.getBoard().getCurrentFigure(),
                            new java.awt.Point(boardController.getBoard().getCurX() - 1, boardController.getBoard().getCurY()));
                break;
            }
            case KeyEvent.VK_RIGHT: {
                if (boardController.ableMove(boardController.getBoard().getCurrentFigure(),
                        new java.awt.Point(boardController.getBoard().getCurX() + 1, boardController.getBoard().getCurY())))
                    boardController.move(boardController.getBoard().getCurrentFigure(),
                            new java.awt.Point(boardController.getBoard().getCurX() + 1, boardController.getBoard().getCurY()));
                break;
            }
            case KeyEvent.VK_DOWN: {
                boardController.rotate(BoardController.Rotation.LEFT);
                break;
            }
            case KeyEvent.VK_UP: {
                boardController.rotate(BoardController.Rotation.RIGHT);
                break;
            }
            case KeyEvent.VK_SPACE: {
                boardController.dropDown();
                break;
            }
            case KeyEvent.VK_D: {
                boardController.down();
                break;
            }
        }
    }
}
