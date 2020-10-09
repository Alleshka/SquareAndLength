package com.company;

import com.company.classes.Constants;
import com.company.classes.ListReader;
import com.company.classes.chainResponsibility.*;

public class Main {

    public static void main(String[] args) {
        var listReader = new ListReader();
        var chain = InitChain();

        try {
            var result = listReader.readFromFile("input.txt", chain);

            var list = result.getResult();
            var errors = result.getErrors();

            System.out.println("Список: " + System.lineSeparator() + list);
            System.out.println("Суммарная площадь: " + list.getSumS());
            System.out.println("Суммарный периметр: " + list.getSumL());
            System.out.println();
            System.out.println("Ошибки при считывании: ");
            System.out.println(String.join(System.lineSeparator(), errors));

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    // Инициализирует цепочку обязанностей
    private static IShapeHandler InitChain() {
        // Паттерн цепочка обязанностей
        // https://metanit.com/sharp/patterns/3.7.php
        // Будет обходиться по порядку каждый из обработчиков, пока один их них не обработает строку с аргументами
        var chain = new ShapeHandlerBuilder();

        chain.add(new PointShapeHandler(Constants.POINT_SHAPE_NAME));
        chain.add(new VectorShapeHandler(Constants.VECTOR_SHAPE_NAME));
        chain.add(new TriangleShapeHandler(Constants.TRIANGLE_SHAPE_NAME));
        chain.add(new SquareShapeHandler(Constants.SQUARE_SHAPE_NAME));
        chain.add(new CircleShapeHandler(Constants.CIRCLE_SHAPE_NAME));
        chain.add(new TetragonShapeHandler(Constants.TETRAGON_SHAPE_NAME));

        return chain.getFirst();
    }
}
