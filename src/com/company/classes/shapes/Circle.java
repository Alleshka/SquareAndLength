package com.company.classes.shapes;

import com.company.classes.Constants;

// Круг
public class Circle extends Shape {

    private Point center;
    private Double r;

    public Circle(String[] args) throws BuildShapeException {
        super(args);
    }

    @Override
    public String getShapeName() {
        return Constants.CIRCLE_SHAPE_NAME;
    }

    @Override
    protected int NeedArgumentsToBuild() {
        return 3;
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
    protected void InitShapeByArgs(String[] args) throws BuildShapeException {
        this.center = new Point(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
        this.setR(Double.parseDouble(args[3]));
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
