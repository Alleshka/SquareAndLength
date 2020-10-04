package com.company.classes;

import com.company.classes.shapes.Point;

import java.util.stream.Stream;

// Утилиты для удобства
public class Utils {

    // Считает квадрат расстояния между двумя точками
    public static double calculateDistanceSq(Point a, Point b) {
        return Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2);
    }

    // Считает расстояние между двумя точками
    public static double calculateDistance(Point a, Point b) {
        return Math.sqrt(calculateDistanceSq(a, b));
    }

    // Получает из строки набор чисел
    public static Double[] parseArgs(String line) {
        return parseArgs(line, null);
    }

    // Получает из строки набор чисел и выбирает указанное количество
    public static Double[] parseArgs(String line, Integer count) {
        var args = line.split(" ");
        return Stream.of(args)
                .limit(count == null ? args.length : count)
                .map(x -> Double.parseDouble(x))
                .toArray(Double[]::new);
    }

    // Сравнивает два числа и возвращает true если они равны с заданной точностью
    public static boolean isDoubleEquals(double a, double b) {
        return Math.abs(a - b) < Constants.eps;
    }

    // Сравнивает несколько чисел
    public static boolean isDoubleEquals(double... numbers) {
        if (numbers.length < 2) return true;

        for (int i = 1; i < numbers.length; i++) {
            if (!isDoubleEquals(numbers[i - 1], numbers[i])) return false;
        }

        return true;
    }

    // Определяет лежат ли точки на одной прямой
    public static boolean isPointsOnLine(Point a, Point b, Point c) {
        return Utils.isDoubleEquals((a.getX() - c.getX()) * (b.getY() - c.getY()), (b.getX() - c.getX()) * (a.getY() - c.getY()));
    }
}
