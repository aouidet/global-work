package com.jep.pattern.jep397;

import java.io.File;
import java.util.Scanner;

public class TryWithResource {

    public static void main(String[] args) throws Exception {
        try(Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNext()){
                System.out.println(scanner.hasNext());
            }
        }

        try(AutoCloseableFirsrResource first = new AutoCloseableFirsrResource();
            AutoCloseableSecondResource second = new AutoCloseableSecondResource()) {
            first.doSomeThing();
            second.doSomeThing();
        }
    }
}

class AutoCloseableFirsrResource implements AutoCloseable {

    AutoCloseableFirsrResource() {
        System.out.println("first resource constructor");
    }
    void doSomeThing() {
        System.out.println("inside first resource");
    }
    @Override
    public void close() throws Exception {
        System.out.println("close resource 2");
    }
}

class AutoCloseableSecondResource implements AutoCloseable {

    public AutoCloseableSecondResource() {
        System.out.println("second constructor ");
    }
    void doSomeThing() {
        System.out.println("inside first resource");
    }

    @Override
    public void close() throws Exception {
        System.out.println("close resource 2");
    }
}
