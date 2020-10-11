package com.company.classes.shapes;

import com.company.classes.Constants;
import com.company.classes.Utils;

import java.util.Comparator;
import java.util.Scanner;

// Точка
public class Point extends Shape implements Comparator<Point>, Comparable<Point> {

    private double x;
    private double y;

    public Point(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }

    public Point(Scanner scanner) throws BuildShapeException {
        super(scanner);
    }

    @Override
    public String getShapeName() {
        return Constants.POINT_SHAPE_NAME;
    }

    @Override
    public double calcS() {
        return 0;
    }

    @Override
    public double calcL() {
        return 0;
    }

    @Override
    protected void InitShapeByScanner(Scanner scanner) throws BuildShapeException {
        this.x = getNextDoubleOrThrow(scanner);
        this.y = getNextDoubleOrThrow(scanner);
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public int compare(Point o1, Point o2) {
        if (!Utils.isDoubleEquals(o1.getX(), o2.getY())) {
            return Double.compare(o1.getX(), o2.getX());
        } else {
            if (!Utils.isDoubleEquals(o1.getY(), o2.getY())) {
                return Double.compare(o1.getY(), o2.getY());
            } else {
                return 0;
            }
        }
    }

    @Override
    public int compareTo(Point o) {
        return compare(this, o);
    }

    @Override
    public String toString() {
        return " (" + this.getX() + "; " + this.getY() + ")";
    }
}
