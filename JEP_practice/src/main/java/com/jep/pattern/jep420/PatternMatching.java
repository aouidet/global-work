package com.jep.pattern.jep420;

public class PatternMatching {

    public static void main(String[] args) {

        Point point = new Point(1, 2);
        Color color = Color.GREEN;
        typeTester(point);
        typeTester("null");
        typeTester(color);


    }

    static void typeTester(Object object) {

        switch (object) {
            case null -> System.out.println("null");
            case String str -> System.out.println("this is string with value : %s".formatted(str));
            case Color c -> {
                System.out.println("Color with " + Color.values().length + " values");
                System.out.println("print color "+ c);
            }
            case Point p -> System.out.println("record : "+ p);
            default -> System.out.println("something else");
        }
    }
    record Point(int i, int b){

    }
    enum Color {RED, GREEN;};

    static int coverage(Object o) {
        return switch (o) {         // Error - incomplete
            case String s  -> s.length();
            case Integer i -> i;
            default -> 0;
        };
    }
}
