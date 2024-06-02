package model;

import java.awt.Point;

/**
 * A class representing the game board in Tetris.
 * It manages the state of the game board and provides methods to interact with it.
 */
public class Board {
    /** The width of the game board */
    public static final int BOARD_WIDTH = 10;
    /** The height of the game board */
    public static final int BOARD_HEIGHT = 20;

    private int numberLinesRemoved = 0;
    private int curX;
    private int curY;
    private boolean isStarted;
    private boolean fellStatus;
    private Figure currentFigure;
    private final Tetrominoe[] boardField;

    /**
     * Constructs a new Board object.
     * Initializes the game board with empty cells and sets the fell status to false.
     */
    public Board() {
        boardField = new Tetrominoe[BOARD_WIDTH * BOARD_HEIGHT];
        fellStatus = false;
    }

    /** @return the current x-coordinate of the falling Tetrominoe */
    public int getCurX() {
        return curX;
    }

    /**
     * Sets the current x-coordinate of the falling Tetrominoe.
     *
     * @param curX the x-coordinate to set
     */
    public void setCurX(int curX) {
        this.curX = curX;
    }

    /** @return the current y-coordinate of the falling Tetrominoe */
    public int getCurY() {
        return curY;
    }

    /**
     * Sets the current y-coordinate of the falling Tetrominoe.
     *
     * @param curY the y-coordinate to set
     */
    public void setCurY(int curY) {
        this.curY = curY;
    }

    /** @return true if the game has started, false otherwise */
    public boolean isStarted() {
        return isStarted;
    }

    /**
     * Sets the game started status.
     *
     * @param isStarted true to indicate that the game has started, false otherwise
     */
    public void setStarted(boolean isStarted) {
        this.isStarted = isStarted;
    }

    /** @return true if the Tetrominoe has fallen, false otherwise */
    public boolean isFellStatus() {
        return fellStatus;
    }

    /**
     * Sets the fell status of the Tetrominoe.
     *
     * @param fellStatus true to indicate that the Tetrominoe has fallen, false otherwise
     */
    public void setFellStatus(boolean fellStatus) {
        this.fellStatus = fellStatus;
    }

    /** @return the current falling Tetrominoe */
    public Figure getCurrentFigure() {
        return currentFigure;
    }

    /**
     * Sets the current falling Tetrominoe.
     *
     * @param currentFigure the Tetrominoe to set
     */
    public void setCurrentFigure(Figure currentFigure) {
        this.currentFigure = currentFigure;
    }

    /** @return the array representing the game board */
    public Tetrominoe[] getBoardField() {
        return boardField;
    }

    /** @return the number of lines removed */
    public int getNumberLinesRemoved() {
        return numberLinesRemoved;
    }

    /**
     * Sets the number of lines removed.
     *
     * @param numberLinesRemoved the number of lines removed to set
     */
    public void setNumberLinesRemoved(int numberLinesRemoved) {
        this.numberLinesRemoved = numberLinesRemoved;
    }

    /**
     * Sets the Tetrominoe at the specified index on the game board.
     *
     * @param index the index where the Tetrominoe should be set
     * @param figure the Tetrominoe to set
     */
    public void setFigure(final int index, final Tetrominoe figure) {
        boardField[index] = figure;
    }

    /**
     * Retrieves the Tetrominoe at the specified point on the game board.
     *
     * @param point the point from which to retrieve the Tetrominoe
     * @return the Tetrominoe at the specified point
     */
    public Tetrominoe getFigure(final Point point) {
        if (point.y * BOARD_WIDTH + point.x < BOARD_WIDTH * BOARD_HEIGHT - 1) {
            return boardField[(point.y * BOARD_WIDTH) + point.x];
        }
        return Tetrominoe.Empty;
    }

    /**
     * Adds the specified number of lines to the total lines removed.
     *
     * @param lines the number of lines to add
     */
    public void addNumberLinesRemoved(final int lines) {
        numberLinesRemoved += lines;
    }

    /** @return the score of the game */
    public int getScore() {
        // Assume that the score equals the number of lines removed
        return numberLinesRemoved;
    }
}
