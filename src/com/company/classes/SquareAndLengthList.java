package com.company.classes;

import com.company.classes.shapes.Shape;

// Расришернный список с методом подсчёта суммарной площади и периметра
public class SquareAndLengthList extends MyList<Shape> {

    // Функциональный интерфейс
    private interface Calculation {
        double calculation(Shape item);
    }

    // Суммарный периметр
    public double getSumL() {
        return calculateSum(x -> x.calcL());
    }

    // Суммарная площадь
    public double getSumS() {
        return calculateSum(x -> x.calcS());
    }

    // Базовый обход списка и выполнение переданного действия
    private double calculateSum(Calculation calc) {
        double result = 0;
        var cur = this.head;

        do {
            result += calc.calculation(cur.getData());
            cur = cur.getNext();
        } while (cur != null);

        return result;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        var cur = this.head;

        do {
            builder.append(cur.getData());
            cur = cur.getNext();
            if (cur != null) builder.append(" -> ");
        } while (cur != null);

        return builder.toString();
    }
}

