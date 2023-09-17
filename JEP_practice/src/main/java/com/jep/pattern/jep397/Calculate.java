package com.jep.pattern.jep397;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public class Calculate {

    public static void main(String[] args) {
        var add = new Add(new Value(2), new Add(new Value(3), new Value(2)));
        System.out.println("test : "+ add.right);

    }

    sealed interface Expression {
        int evl(Map<String, Integer> variableMap);

        static Expression parse(List<String> token) {
            requireNonNull(token);
            return parse(token.iterator());
        }

        private static Expression parse(Iterator<String> iterator) {
            var token = iterator.next();
            return switch (token) {
                case "+" -> new Add(parse(iterator), parse(iterator));
                case "-" -> new Minus(parse(iterator), parse(iterator));
                default -> {
                    try {
                        yield new Value(Integer.parseInt(token));
                    } catch (NumberFormatException exception) {
                        yield new Var(token);
                    }
                }
            };
        }


    }

    record Value(int value) implements Expression {

        @Override
        public int evl(Map<String, Integer> variableMap) {
            return value;
        }
    }

    record Var(String name) implements Expression {

        public Var {
            requireNonNull(name);
        }

        @Override
        public int evl(Map<String, Integer> variableMap) {
            return variableMap.getOrDefault(name, 0);
        }

        @Override
        public String toString() {
            return "name : %s".formatted(name);
        }
    }

    record Add(Expression left, Expression right) implements Expression {
        public Add {
            requireNonNull(left);
            requireNonNull(right);
        }

        @Override
        public int evl(Map<String, Integer> variableMap) {
            return left.evl(variableMap) + right.evl(variableMap);
        }

        @Override
        public String toString() {
            return "( %s ) + ( %s ) ".formatted(left, right);
        }
    }

    record Minus(Expression left, Expression right) implements Expression {
        public Minus {
            requireNonNull(left);
            requireNonNull(right);
        }

        @Override
        public int evl(Map<String, Integer> variableMap) {
            return left.evl(variableMap) - right.evl(variableMap);
        }

        @Override
        public String toString() {
            return "( %s ) - ( %s ) ".formatted(left, right);
        }
    }
}

