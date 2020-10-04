package com.company.classes;

import com.company.classes.chainResponsibility.IShapeHandler;

import java.io.BufferedReader;
import java.io.FileReader;

// Считыватель файла
public class ListReader {

    // Считывает отрезки из файла и возвращает список фигур
    public SquareAndLengthList readFromFile(String filePath, IShapeHandler handler) throws Exception {
        try (var reader = new BufferedReader(new FileReader(filePath))) {
            var list = new SquareAndLengthList();

            String str;
            while ((str = reader.readLine()) != null) {
                var item = handler.handle(str.split(" "));
                list.add(item);
            }

            return list;
        }
    }
}
