package com.jep.pattern.strategy;

public  sealed interface Strategy permits OperationAdd, OperationDivision, OperationSubStruct {

    int doOperation(int num1, int num2);
}
