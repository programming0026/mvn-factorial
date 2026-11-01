package com.juniverse.math.algorithms;

/**
 * Estrategia para calcular el factorial (patrón Strategy).
 *
 * @author ajuar
 */
public interface FactorialStrategy {

    /**
     * Calcula el factorial de {@code n}.
     * @param n número no negativo
     * @return resultado como texto
     */
    String calculate(int n);

    /** Nombre descriptivo de la estrategia. */
    String getName();

    boolean supportsLargeNumbers();
}
