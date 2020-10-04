package com.company.classes.shapes;

import com.company.classes.Utils;
import java.util.Comparator;

// Точка
public class Point extends Shape implements Comparator<Point>, Comparable<Point> {

    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double calcS() {
        return 0;
    }

    @Override
    public double calcL() {
        return 0;
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
