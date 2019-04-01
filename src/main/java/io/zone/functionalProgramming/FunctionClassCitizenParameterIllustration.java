package io.zone.functionalProgramming;

import java.util.Optional;
import java.util.function.Function;

public class FunctionClassCitizenParameterIllustration {

    public static void main(String[] args) {


        //
        // The concatAndTransform call illustrates how functions can be passed as parameter. Functions (lambdas) can be passed directly or...
        //
        System.out.println(concatAndTransform("Hello ", "World", String::toUpperCase));

        // ... from a variable

        Function<String, String> transformToLower = String::toLowerCase;
        System.out.println(concatAndTransform("Hello ", "World", transformToLower));

    }


    private static String concatAndTransform(String a, String b, Function<String, String> stringTransform) {
        return Optional.ofNullable(stringTransform).map(tr -> tr.apply(a) + tr.apply(b)).orElse(a + b);
    }


}
