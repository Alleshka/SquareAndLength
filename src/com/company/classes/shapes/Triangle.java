package com.company.classes.shapes;

import com.company.classes.Constants;
import com.company.classes.Utils;

import java.util.Scanner;

public class Triangle extends Shape {

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Scanner scanner) throws BuildShapeException {
        super(scanner);
    }

    @Override
    protected void InitShapeByScanner(Scanner scanner) throws BuildShapeException {
        var p1 = new Point(getNextDoubleOrThrow(scanner), getNextDoubleOrThrow(scanner));
        var p2 = new Point(getNextDoubleOrThrow(scanner), getNextDoubleOrThrow(scanner));
        var p3 = new Point(getNextDoubleOrThrow(scanner), getNextDoubleOrThrow(scanner));

        if (!Utils.isPointsOnLine(p1, p2, p3)) {
            this.a = p1;
            this.b = p2;
            this.c = p3;
        } else {
            ThrowIfCannotBuild("Указанные точки не составляют треугольник", p1.toString(), p2.toString(), p3.toString());
        }
    }

    @Override
    public String getShapeName() {
        return Constants.TRIANGLE_SHAPE_NAME;
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
