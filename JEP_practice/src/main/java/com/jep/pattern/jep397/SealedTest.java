package com.jep.pattern.jep397;

public class SealedTest {


    public static void main(String[] args) {

        S s = new A();
        var result  = testSealedCoverage(s);
        System.out.println("Result : "+ result);

    }

    sealed interface S permits A, B {
        void print();
    }

    static final class A implements S {
        @Override
        public void print() {
            System.out.println("I'm a class A");
        }
    }
    static final class B implements S {
        @Override
        public void print() {
            System.out.println("I'm a class B");
        }
    }

    static int testSealedCoverage(S sealed) {
        return switch (sealed) {
            case A a -> 1;
            case B b -> 2;
        };
    }
}
