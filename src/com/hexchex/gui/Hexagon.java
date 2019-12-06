package com.hexchex.gui;

import com.hexchex.engine.board.Cell;

import java.awt.*;

public class Hexagon extends Polygon {

    private static final int SIDES = 6;

    private Point[] points = new Point[SIDES];
    private Point center;
    private int radius;
    private int rotation = 0;

    private Color color;
    private Color defaultColor;
    private Color selectedColor = new Color(200, 200, 100);

    private Cell cell;

    public Hexagon(Point center, int radius, Cell cell) {
        npoints = SIDES;
        xpoints = new int[SIDES];
        ypoints = new int[SIDES];

        this.center = center;
        this.radius = radius;
        this.cell = cell;

        updatePoints();
    }

    public Hexagon(int x, int y, int radius, Cell cell) {
        this(new Point(x, y), radius, cell);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setDefaultColor(Color color) {
        this.defaultColor = color;
    }

    public Color getDefaultColor() {
        return defaultColor;
    }

    public void setToDefaultColor() {
        color = defaultColor;
    }

    public void setToSelectedColor() {
        color = selectedColor;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;

        updatePoints();
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;

        updatePoints();
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;

        updatePoints();
    }

    public void setCenter(int x, int y) {
        setCenter(new Point(x, y));
    }

    public Cell getCell() {
        return cell;
    }

    private double findAngle(double fraction) {
        return fraction * Math.PI * 2 + Math.toRadians((rotation + 180) % 360);
    }

    private Point findPoint(double angle) {
        int x = (int) (center.x + Math.cos(angle) * radius);
        int y = (int) (center.y + Math.sin(angle) * radius);

        return new Point(x, y);
    }

    private void updatePoints() {
        for (int p = 0; p < SIDES; p++) {
            double angle = findAngle((double) p / SIDES);
            Point point = findPoint(angle);
            xpoints[p] = point.x;
            ypoints[p] = point.y;
            points[p] = point;
        }
    }

}

