package FactorialFirst;

public class Factorial {
    public static long getFactorial(long f) {
        if (f < 0) {
            throw new IllegalArgumentException("Число не может быть отрицательным.");
        }
        long result = 1;
        for (long i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }


}
