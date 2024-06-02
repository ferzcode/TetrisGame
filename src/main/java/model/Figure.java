package model;

import java.awt.Point;
import java.util.Random;

/**
 * A class representing a Tetris game figure.
 * It stores information about the structure of game objects and contains an enum Tetrominoe.
 */
public class Figure {
    /** The size of the figure */
    public static final int FIGURE_SIZE = 4;

    private final Point[] coordinates;
    private final Tetrominoe figureName;

    /**
     * Constructs a new Figure object with the specified Tetrominoe.
     *
     * @param tetrominoe the name of the figure
     */
    public Figure(final Tetrominoe tetrominoe) {
        coordinates = new Point[FIGURE_SIZE];
        for (int i = 0; i < FIGURE_SIZE; i++) {
            coordinates[i] = new Point();
            coordinates[i].setLocation(tetrominoe.getCoordinates()[i]);
        }

        this.figureName = tetrominoe;
    }

    /**
     * Creates a random figure.
     *
     * @return an instance of the Figure class with a random name
     */
    public static Figure getRandomFigure() {
        Random random = new Random();
        Tetrominoe[] values = Tetrominoe.values();
        return new Figure(values[Math.abs(random.nextInt()) % (Tetrominoe.TETROMINOE_NUMBER - 1) + 1]);
    }

    /**
     * Finds the minimum y-value among the figure's points.
     *
     * @return the minimum y-value
     */
    public int getMinY() {
        int minY = (int) coordinates[0].getY();

        for (int i = 1; i < FIGURE_SIZE; i++) {
            minY = Math.min(minY, (int) coordinates[i].getY());
        }

        return minY;
    }

    /**
     * Gets the name of the figure.
     *
     * @return the name of the figure
     */
    public Tetrominoe getFigureName() {
        return this.figureName;
    }

    /**
     * Gets the coordinate at the specified index.
     *
     * @param index the index of the coordinate to retrieve
     * @return the coordinate at the specified index
     */
    public Point getCoordinate(final int index) {
        return coordinates[index];
    }
}
