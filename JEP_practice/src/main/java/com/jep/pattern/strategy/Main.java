package com.jep.pattern.strategy;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.TimeZone;
import java.util.function.Supplier;

public class Main {

    /**
     * Strategy pattern is a behavior pattern that permit to create objects witch represent various strategies
     * and dispose a context object whose behavior varies as per its strategy object,
     * The strategy object changes the executing algorithm of the context object
     * @param args
     */
    public static void main(String[] args) {

        var resultAdd =getStrategy(OperationAdd::new).doOperation(5, 10);
        System.out.printf("5 + 10 = %s %n", resultAdd);

        var resultSous =getStrategy(OperationSubStruct::new).doOperation(5, 10);
        System.out.printf("5 - 10 = %s %n", resultSous);

        var resultDiv =getStrategy(OperationDivision::new).doOperation(10, 2);
        System.out.printf("10 / 2 = %s %n", resultDiv);

    }

    private static Strategy getStrategy(Supplier<? extends Strategy> strategy) {
        return getOperation(strategy.get());
    }

    private static Strategy getOperation(Strategy object) {
        switch (object) {
            case null -> {
                System.out.println("null");

                return null;
            }
            case OperationAdd  add -> {
                System.out.println("---> " +add.doOperation(1,1));
                return add;
            }
            case OperationSubStruct  sub -> {
                return sub;
            }
            case OperationDivision  div -> {
                return div;
            }
            default -> {
                System.out.println("default case");
                return null;
            }
        }
    }
}
