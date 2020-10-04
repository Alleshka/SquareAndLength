package com.company;

import com.company.classes.ListReader;
import com.company.classes.chainResponsibility.*;

public class Main {

    public static void main(String[] args) {
        var listReader = new ListReader();
        var chain = InitChain();

        try {
            var list = listReader.readFromFile("input.txt", chain);

            System.out.println(list);
            System.out.println("Суммарная площадь: " + list.getSumS());
            System.out.println("Суммарный периметр: " + list.getSumL());

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

        chain.add(new PointShapeHandler());
        chain.add(new VectorShapeHandler());
        chain.add(new TriangleShapeHandler());
        chain.add(new SquareShapeHandler());
        chain.add(new CircleShapeHandler());

        chain.add(new TetragonShapeHandler()); // TODO: Его обязательно ставить после квадрата или допилить критерии отбора. Сейчас четырёхугольник затригеррится на квадрат. Можно попробовать хранить название фигуры в файле

        return chain.getFirst();
    }
}
