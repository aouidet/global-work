package com.jep.pattern.strategy;

public final class OperationSubStruct implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
