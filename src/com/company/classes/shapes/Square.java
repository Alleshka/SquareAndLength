package com.company.classes.shapes;

import com.company.classes.Constants;
import com.company.classes.Utils;

import java.util.Scanner;

public class Square extends Shape {

    private Point a;
    private Point b;
    private Point c;
    private Point d;

    private double size;

    public Square(Scanner scanner) throws BuildShapeException {
        super(scanner);
    }

    @Override
    public String getShapeName() {
        return Constants.SQUARE_SHAPE_NAME;
    }

    @Override
    public double calcS() {
        return Math.pow(this.size, 2);
    }

    @Override
    public double calcL() {
        return 4 * this.size;
    }

    @Override
    protected void InitShapeByScanner(Scanner scanner) throws BuildShapeException {
        var a = new Point(getNextDoubleOrThrow(scanner), getNextDoubleOrThrow(scanner));
        var b = new Point(getNextDoubleOrThrow(scanner), getNextDoubleOrThrow(scanner));
        var c = new Point(getNextDoubleOrThrow(scanner), getNextDoubleOrThrow(scanner));
        var d = new Point(getNextDoubleOrThrow(scanner), getNextDoubleOrThrow(scanner));
        InitSquare(a, b, c, d);
    }

    protected void InitSquare(Point a, Point b, Point c, Point d) throws BuildShapeException {
        double s1, s2, s3, s4, s5, s6;

        s1 = Utils.calculateDistanceSq(a, b);
        s2 = Utils.calculateDistanceSq(a, c);
        s3 = Utils.calculateDistanceSq(a, d);
        s4 = Utils.calculateDistanceSq(b, c);
        s5 = Utils.calculateDistanceSq(b, d);
        s6 = Utils.calculateDistanceSq(c, d);

        if (Utils.isDoubleEquals(s1, s3, s4, s6) && Utils.isDoubleEquals(s2, s5, 2 * s1)) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        } else if (Utils.isDoubleEquals(s1, s2, s5, s6) && Utils.isDoubleEquals(s3, s4, 2 * s1)) {
            this.a = a;
            this.b = b;
            this.c = d;
            this.d = c;
        } else if (Utils.isDoubleEquals(s2, s3, s4, s5) && Utils.isDoubleEquals(s1, s6, 2 * s2)) {
            this.a = a;
            this.b = c;
            this.c = b;
            this.d = d;
        } else {
            ThrowIfCannotBuild("Указанные точки не образуют квадрат", a.toString(), b.toString(), c.toString(), d.toString());
        }

        this.size = Utils.calculateDistance(a, b);
    }

    @Override
    public String toString() {
        return "Square [" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ']';
    }
}
