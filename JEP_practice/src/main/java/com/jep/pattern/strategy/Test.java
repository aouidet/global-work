package com.jep.pattern.strategy;

import java.time.LocalDateTime;

public class Test {

    private final DateTimeProvider dateTimeProvider;

    public Test(DateTimeProvider dateTimeProvider) {
        this.dateTimeProvider = dateTimeProvider;
    }

    public static void main(String[] args) {
        LocalDateTime expectedDateTime = LocalDateTime.of(2023, 5, 16, 10, 30);
        Test myTest = new Test(new MockDateTimeProvider(expectedDateTime));
        //Test myTest = new Test(new LocalDateTimeProvider());

        LocalDateTime actualDateTime = myTest.dateTimeProvider.now();
        System.out.println(expectedDateTime == actualDateTime);
        System.out.println(expectedDateTime);
        System.out.println(actualDateTime);
    }
}

interface DateTimeProvider {
    LocalDateTime now();
    
}

class LocalDateTimeProvider implements DateTimeProvider {

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}

record MockDateTimeProvider(LocalDateTime mockDateTime) implements DateTimeProvider {

    @Override
    public LocalDateTime now() {
        return mockDateTime;
    }
}
