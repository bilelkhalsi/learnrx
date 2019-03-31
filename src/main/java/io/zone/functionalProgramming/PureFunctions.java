package io.zone.functionalProgramming;

public class PureFunctions {

    private int state = 0;

    /**
     * Pure function
     *
     * @param x input
     * @return x*2
     */
    public int f1(int x) {
        return x * 2;
    }

    /**
     * Impure function (has a side effects).
     *
     * @param x input
     * @return result
     */
    public int f2(int x) {
        state = (++state % 3);
        return x * 2 + state;
    }

    public static void main(String[] args) {
        PureFunctions pf = new PureFunctions();

        // I can call the f1 method any number of times, with any number of threads
        // and I will always get the same answer so long as i provide the same
        // parameters because f1's  result is totally determined by the incoming
        // parameters and nothing else.
        for (int i = 0; i < 100; i++) {
            if (pf.f1(5) != 10) {
                throw new IllegalStateException();
            }
        }
        System.out.println("f1(5) = 10 for all calls");

        // If i call the f2 method, I can never be sure of what i'm going to
        // get because there is a side effect that effects the value returned.
        // If another thread or call somewhere else in the code gets to it
        // before i do, then the value will not be what i expect.
        for (int i = 0; i < 100; i++) {
            System.out.println("f2(5) = " + pf.f2(5));
        }
    }
}
