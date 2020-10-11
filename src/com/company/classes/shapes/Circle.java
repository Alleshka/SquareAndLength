package com.company.classes.shapes;

import com.company.classes.Constants;

import java.nio.channels.Pipe;
import java.util.Scanner;

// Круг
public class Circle extends Shape {

    private Point center;
    private Double r;

    public Circle(Scanner scanner) throws BuildShapeException {
        super(scanner);
    }

    @Override
    public String getShapeName() {
        return Constants.CIRCLE_SHAPE_NAME;
    }

    @Override
    public double calcS() {
        return Math.pow(this.getR(), 2) * Math.PI;
    }

    @Override
    public double calcL() {
        return 2 * Math.PI * this.getR();
    }

    @Override
    protected void InitShapeByScanner(Scanner scanner) throws BuildShapeException {
        double x = getNextDoubleOrThrow(scanner);
        double y = getNextDoubleOrThrow(scanner);

        setR(getNextDoubleOrThrow(scanner));
        this.center = new Point(x, y);
    }


    public Double getR() {
        return r;
    }

    protected void setR(double value) throws BuildShapeException {
        if (value > 0) {
            this.r = value;
        } else {
            ThrowIfCannotBuild("Радиус должен быть больше нуля (" + value + ")");
        }
    }

    public Point getCenter() {
        return center;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", r=" + r +
                '}';
    }
}
