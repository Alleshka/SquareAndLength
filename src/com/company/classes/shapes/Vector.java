package com.company.classes.shapes;

import com.company.classes.Utils;

public class Vector extends Shape {

    private final Point a;
    private final Point b;

    public Vector(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double calcS() {
        return 0;
    }

    @Override
    public double calcL() {
        return Utils.calculateDistance(a, b);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
