package io.zone.functionalProgramming;

import java.util.function.BiFunction;

public class FunctionsAsFirstClassCitizens {
    public static void main(String[] args) {

        //
        // This example illustrates how to create an inline lambda expression and store it in a variable.
        // It can be called directly from the variable.
        BiFunction<String, String, String> concatFunction = (s, t) -> s + t;
        System.out.println(concatFunction.apply("Hello ", "World 1"));

        //
        // This example illustrate how a static method conforms to the method signature of the BiFunction can be stored in a variable
        // and then invoked
        concatFunction = FunctionsAsFirstClassCitizens::concatStrings;
        System.out.println(concatFunction.apply("Hello ", "World 2"));

        //
        // This example illustrates how an instance method that conforms to the method signature of BiFunction can be stored in a variable
        // and then invoked.

        FunctionsAsFirstClassCitizens instance = new FunctionsAsFirstClassCitizens();
        concatFunction = instance::concatString2;
        System.out.println(concatFunction.apply("Hello ", "World 3"));
    }

    private static String concatStrings(String a, String b) {
        return a + b;
    }

    /* package */ String concatString2(String a, String b) {
        return a + b;
    }

}
