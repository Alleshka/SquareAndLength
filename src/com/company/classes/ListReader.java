package com.company.classes;

import com.company.classes.chainResponsibility.IShapeHandler;
import com.company.classes.shapes.BuildShapeException;

import java.io.BufferedReader;
import java.io.FileReader;

// Считыватель файла
public class ListReader {

    // Считывает отрезки из файла и возвращает список фигур
    public ListReaderResult readFromFile(String filePath, IShapeHandler handler) throws Exception {
        try (var reader = new BufferedReader(new FileReader(filePath))) {
            var list = new SquareAndLengthList();

            var result = new ListReaderResult();

            String str;
            while ((str = reader.readLine()) != null) {
                try {
                    var item = handler.handle(str.split(" "));
                    list.add(item);
                } catch (BuildShapeException ex) {
                    result.addError(ex.getMessage());
                }
            }

            result.setResult(list);

            return result;
        }
    }
}
