package com.juniverse.math.algorithms;

/**
 * Factorial exacto con {@link java.math.BigInteger} mediante un bucle de multiplicaciones (n ≤ 10000).
 *
 * @author Java Universe
 */
public class BigIntegerFactorial implements FactorialStrategy {

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
        if (n > 10000) {
            throw new IllegalArgumentException("Límite de seguridad: n <= 10000");
        }

        java.math.BigInteger result = java.math.BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(java.math.BigInteger.valueOf(i));
        }
        return result.toString();
    }

    /** Nombre descriptivo de la estrategia. */
    @Override
    public String getName() {
        return "BigInteger";
    }

    @Override
    public boolean supportsLargeNumbers() {
        return true;
    }

}
