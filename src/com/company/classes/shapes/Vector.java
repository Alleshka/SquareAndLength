package com.company.classes.shapes;

import com.company.classes.Constants;
import com.company.classes.Utils;

import java.util.Scanner;

public class Vector extends Shape {

    private Point a;
    private Point b;

    public Vector(Scanner scanner) throws BuildShapeException {
        super(scanner);
    }

    @Override
    protected void InitShapeByScanner(Scanner scanner) throws BuildShapeException {
        this.a = new Point(getNextDoubleOrThrow(scanner), getNextDoubleOrThrow(scanner));
        this.b = new Point(getNextDoubleOrThrow(scanner), getNextDoubleOrThrow(scanner));
    }

    @Override
    public String getShapeName() {
        return Constants.VECTOR_SHAPE_NAME;
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
