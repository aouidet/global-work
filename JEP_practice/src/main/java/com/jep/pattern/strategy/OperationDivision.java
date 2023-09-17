package com.jep.pattern.strategy;

public final class OperationDivision implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        if(num2 == 0 ) {
            throw new NullPointerException("we can't divide by zero");
        }
        return num1 / num2;
    }
}
