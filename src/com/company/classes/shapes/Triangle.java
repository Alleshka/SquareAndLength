package com.company.classes.shapes;

import com.company.classes.Utils;

public class Triangle extends Shape {

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calcS() {
        var p = calcL() / 2;
        return Math.sqrt(p * (p - Utils.calculateDistance(a, b)) * (p - Utils.calculateDistance(b, c)) * (p - Utils.calculateDistance(a, c)));
    }

    @Override
    public double calcL() {
        return Utils.calculateDistance(a, b) + Utils.calculateDistance(b, c) + Utils.calculateDistance(a, c);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
