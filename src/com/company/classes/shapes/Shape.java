package com.company.classes.shapes;

import java.util.Scanner;

public abstract class Shape {

    public abstract double calcS();

    public abstract double calcL();

    protected Shape() {

    }

    public Shape(Scanner scanner) throws BuildShapeException {
        InitShapeByScanner(scanner);
    }

    private void InitShape(Scanner scanner) throws BuildShapeException {
        InitShapeByScanner(scanner);
    }

    protected abstract void InitShapeByScanner(Scanner scanner) throws BuildShapeException;

    public abstract String getShapeName();

    protected void ThrowIfCannotBuild(String message, String... args) throws BuildShapeException {
        var builder = new StringBuilder();
        builder.append("Невозможно построить фигуру ").append(getShapeName()).append(" (" + message + ") ");
        if (args.length > 0) {
            builder.append("Args: [" + String.join("; ", args) + "]").append("; ");
        }
        throw new BuildShapeException(builder.toString());
    }

    protected double getNextDoubleOrThrow(Scanner scanner) throws BuildShapeException {
        if (scanner.hasNextDouble()) return scanner.nextDouble();
        else throw new BuildShapeException("Недостаточно аргументов для построения фигуры " + this.getShapeName());
    }
}
