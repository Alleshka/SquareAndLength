package com.company.classes.shapes;

import com.company.classes.Utils;

public class Tetragon extends Shape {

    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Tetragon(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double calcS() {
        var p = calcL() / 2;
        return Math.sqrt(p * (p - Utils.calculateDistance(a, b)) * (p - Utils.calculateDistance(b, c)) * (p - Utils.calculateDistance(c, d) * (p - Utils.calculateDistance(d, a))));
    }

    @Override
    public double calcL() {
        return Utils.calculateDistance(a, b) + Utils.calculateDistance(b, c) + Utils.calculateDistance(c, d) + Utils.calculateDistance(d, a);
    }

    @Override
    public String toString() {
        return "Tetragon[" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ']';
    }
}
