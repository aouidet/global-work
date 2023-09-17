package com.jep.pattern.strategy;

import java.util.function.Supplier;

public class Context {

    private final Strategy strategyOperation;

    public Context(Strategy strategy) {
        this.strategyOperation = strategy;
    }

    public int executeStrategyOperation(final int num1, final int num2) {
        return strategyOperation.doOperation(num1, num2);
    }
}
