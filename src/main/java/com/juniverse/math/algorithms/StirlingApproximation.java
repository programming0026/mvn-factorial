package com.juniverse.math.algorithms;

import java.util.Locale;

/**
 * Estimación de n! con la fórmula de Stirling: n! ≈ √(2πn)·(n/e)ⁿ.
 * Devuelve notación científica (mantisa y exponente), por lo que no tiene límite de tamaño.
 *
 * @author Java Universe
 */
public class StirlingApproximation implements FactorialStrategy {

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
        if (n == 0) {
            return "1";
        }

        // Se trabaja con logaritmos para no desbordar el double (170! ya es el máximo representable).
        double log10 = stirlingLog10(n);
        long exponent = (long) Math.floor(log10);
        double mantissa = Math.pow(10, log10 - exponent);
        return String.format(Locale.ROOT, "%.2fe+%d", mantissa, exponent);
    }

    /** Logaritmo decimal de n! según la fórmula de Stirling: ln n! ≈ ½·ln(2πn) + n·(ln n − 1). */
    private double stirlingLog10(int n) {
        double ln = 0.5 * Math.log(2 * Math.PI * n) + n * (Math.log(n) - 1);
        return ln / Math.log(10);
    }

    /** Nombre descriptivo de la estrategia. */
    @Override
    public String getName() {
        return "Aproximación de Stirling";
    }

    @Override
    public boolean supportsLargeNumbers() {
        return true;
    }
}
