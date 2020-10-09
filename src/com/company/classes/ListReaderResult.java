package com.company.classes;

import java.util.ArrayList;

public class ListReaderResult {
    private SquareAndLengthList result;
    ArrayList<String> _errors;

    public ListReaderResult() {
        _errors = new ArrayList<>();
    }

    public void addError(String error) {
        _errors.add(error);
    }

    public void setResult(SquareAndLengthList result) {
        this.result = result;
    }

    public SquareAndLengthList getResult() {
        return result;
    }

    public ArrayList<String> getErrors() {
        return _errors;
    }
}
