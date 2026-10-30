package com.juniverse.math.algorithms;

/**
 * Factorial recursivo con {@code long}; exacto hasta n = 20.
 *
 * @author ajuar
 */
public class RecursiveFactorial implements FactorialStrategy {

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
            throw new IllegalArgumentException("Recursión limitada a n <= 20 para evitar desbordamiento");
        }
        return String.valueOf(calculateRecursive(n));
    }

    /** Cálculo recursivo: n! = n · (n − 1)!. */
    private long calculateRecursive(int n) {
        return n <= 1 ? 1 : n * calculateRecursive(n - 1);
    }

    /** Nombre descriptivo de la estrategia. */
    @Override
    public String getName() {
        return "Recursivo";
    }

    /** Indica si la estrategia admite números grandes. */
    @Override
    public boolean supportsLargeNumbers() {
        return false;
    }

}
