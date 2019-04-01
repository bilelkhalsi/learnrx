package io.zone.functionalProgramming;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class HighOrderFunctions {

    public static void main(String[] args) {

        Supplier<String> xformOperation = createCombineAndTransform("Hello ", "World", String::toUpperCase);
        System.out.println(xformOperation.get());

    }

    //
    // This is an example of High Order Function :
    // A function that take a function and return a composite function.
    private static Supplier<String> createCombineAndTransform(
            final String a, final String b,
            final Function<String, String> transformer
    ) {
        return () -> {
            String aa = a;
            String bb = b;
            return Optional.ofNullable(transformer).map(tr -> tr.apply(aa) + tr.apply(bb)).orElse(aa + bb);
        };
    }
}
