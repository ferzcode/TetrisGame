package model;

import java.awt.Point;

/**
 * An enum representing the different types of Tetrominoes in Tetris.
 * Each Tetrominoe has a unique shape defined by an array of Point coordinates.
 */
public enum Tetrominoe {
    /** Empty Tetrominoe */
    Empty(new Point[]{new Point(0, 0), new Point(0, 0), new Point(0, 0), new Point(0, 0)}),
    /** Z-shaped Tetrominoe */
    ZShape(new Point[]{
            new Point(0, -1), new Point(0, 0), new Point(-1, 0), new Point(-1, 1)}),
    /** S-shaped Tetrominoe */
    SShape(new Point[]{
            new Point(0, -1), new Point(0, 0), new Point(1, 0), new Point(1, 1)}),
    /** Line-shaped Tetrominoe */
    LineShape(new Point[]{
            new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2)}),
    /** T-shaped Tetrominoe */
    TShape(new Point[]{
            new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(0, 1)}),
    /** Square-shaped Tetrominoe */
    SquareShape(new Point[]{
            new Point(0, 0), new Point(1, 0), new Point(0, 1), new Point(1, 1)}),
    /** L-shaped Tetrominoe */
    LShape(new Point[]{
            new Point(-1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1)}),
    /** Mirrored L-shaped Tetrominoe */
    MirroredLShape(new Point[]{
            new Point(1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1)});

    private final Point[] coordinates;

    /** The total number of Tetrominoes */
    public static final int TETROMINOE_NUMBER = 8;

    /**
     * Constructs a Tetrominoe with the specified coordinates.
     *
     * @param coordinates the coordinates defining the shape of the Tetrominoe
     */
    Tetrominoe(Point[] coordinates) {
        this.coordinates = coordinates;
    }

    /** @return the coordinates defining the shape of the Tetrominoe */
    public Point[] getCoordinates() {
        return coordinates;
    }
}
