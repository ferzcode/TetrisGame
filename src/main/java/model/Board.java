package model;

import java.awt.Point;

public class Board {
    public static final int BOARD_WIDTH = 10;
    public static final int BOARD_HEIGHT = 20;

    private int numberLinesRemoved = 0;

    private int curX;
    private int curY;
    private boolean isStarted;
    private boolean fellStatus;
    private Figure currentFigure;
    private final Tetrominoe[] boardField;

    public Board() {
        boardField = new Tetrominoe[BOARD_WIDTH * BOARD_HEIGHT];
        fellStatus = false;
    }

    public int getCurX() {
        return curX;
    }

    public void setCurX(int curX) {
        this.curX = curX;
    }

    public int getCurY() {
        return curY;
    }

    public void setCurY(int curY) {
        this.curY = curY;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean isStarted) {
        this.isStarted = isStarted;
    }

    public boolean isFellStatus() {
        return fellStatus;
    }

    public void setFellStatus(boolean fellStatus) {
        this.fellStatus = fellStatus;
    }

    public Figure getCurrentFigure() {
        return currentFigure;
    }

    public void setCurrentFigure(Figure currentFigure) {
        this.currentFigure = currentFigure;
    }

    public Tetrominoe[] getBoardField() {
        return boardField;
    }

    public int getNumberLinesRemoved() {
        return numberLinesRemoved;
    }

    public void setNumberLinesRemoved(int numberLinesRemoved) {
        this.numberLinesRemoved = numberLinesRemoved;
    }

    public void setFigure(final int index, final Tetrominoe figure) {
        boardField[index] = figure;
    }

    public Tetrominoe getFigure(final Point point) {
        if (point.y * BOARD_WIDTH + point.x < BOARD_WIDTH * BOARD_HEIGHT - 1) {
            return boardField[(point.y * BOARD_WIDTH) + point.x];
        }
        return Tetrominoe.Empty;
    }

    public void addNumberLinesRemoved(final int lines) {
        numberLinesRemoved += lines;
    }

    public int getScore() {
        // Предположим, что количество убранных линий равно очкам игрока
        return numberLinesRemoved;
    }
}
