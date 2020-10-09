package com.company.classes.shapes;

import com.company.classes.Constants;
import com.company.classes.Utils;

import java.util.Comparator;

// Точка
public class Point extends Shape implements Comparator<Point>, Comparable<Point> {

    private double x;
    private double y;

    public Point(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }

    public Point(String[] args) throws BuildShapeException {
        super(args);
    }

    @Override
    public String getShapeName() {
        return Constants.POINT_SHAPE_NAME;
    }

    @Override
    protected int NeedArgumentsToBuild() {
        return 2;
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
    protected void InitShapeByArgs(String[] args) throws BuildShapeException {
        this.x = Double.parseDouble(args[1]);
        this.y = Double.parseDouble(args[2]);
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
