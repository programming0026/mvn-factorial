package com.juniverse.math.algorithms;

/**
 * Factorial iterativo con {@code long}; exacto hasta n = 20 (21! desborda).
 *
 * @author ajuar
 */
public class IterativeFactorial implements FactorialStrategy {

    /**
     * Calcula el factorial de {@code n}.
     * @param n número no negativo
     * @return resultado como texto
     * @throws IllegalArgumentException si {@code n} es negativo o supera el límite de la estrategia
     */
    @Override
    public String calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial no definido para números negativos");
        }
        if (n > 20) {
            throw new IllegalArgumentException("Iterativo básico limitado a n <= 20");
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return String.valueOf(result);
    }

    /** Nombre descriptivo de la estrategia. */
    @Override
    public String getName() {
        return "Iterativo";
    }

    @Override
    public boolean supportsLargeNumbers() {
        return false;
    }

}
