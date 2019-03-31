package io.zone.functionalProgramming;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Functional programming :: what's a pure function?")
class PureFunctionsTest {

    PureFunctions pf = new PureFunctions();

    @RepeatedTest(value = 5, name = "should be a pure method")
    void f1() {
        assertEquals(10, pf.f1(5));
    }

    @Test
    @DisplayName("should be an impure method")
    void f2() {
        int result1 = pf.f2(2), result2 = pf.f2(2);
        assertNotEquals(result1, result2);
    }
}