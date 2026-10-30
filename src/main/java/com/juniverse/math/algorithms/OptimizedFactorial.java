package com.juniverse.math.algorithms;

/**
 * Factorial exacto con BigInteger usando divide y vencerás (producto por mitades,
 * que multiplica números de tamaño parecido) y una caché de resultados.
 *
 * @author ajuar
 */
public class OptimizedFactorial implements FactorialStrategy {

    private final java.util.Map<Integer, java.math.BigInteger> cache = new java.util.concurrent.ConcurrentHashMap<>();

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

        return calculateOptimized(n).toString();
    }

    /** Devuelve n! usando la caché si ya se calculó. */
    private java.math.BigInteger calculateOptimized(int n) {
        if (n <= 1) {
            return java.math.BigInteger.ONE;
        }

        // Verificar caché
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        // Divide y vencerás
        java.math.BigInteger result = divideAndConquer(1, n);
        cache.put(n, result);
        return result;
    }

    /** Producto de los enteros entre {@code start} y {@code end} dividiendo el rango por la mitad. */
    private java.math.BigInteger divideAndConquer(int start, int end) {
        if (start > end) {
            return java.math.BigInteger.ONE;
        }
        if (start == end) {
            return java.math.BigInteger.valueOf(start);
        }

        if (end - start == 1) {
            return java.math.BigInteger.valueOf(start).multiply(java.math.BigInteger.valueOf(end));
        }

        int mid = start + (end - start) / 2;
        java.math.BigInteger left = divideAndConquer(start, mid);
        java.math.BigInteger right = divideAndConquer(mid + 1, end);

        return left.multiply(right);
    }

    /** Vacía la caché de resultados. */
    public void clearCache() {
        cache.clear();
    }

    /** Nombre descriptivo de la estrategia. */
    @Override
    public String getName() {
        return "Optimizado (Divide y Vencerás + Caché)";
    }

    /** Indica si la estrategia admite números grandes. */
    @Override
    public boolean supportsLargeNumbers() {
        return true;
    }
}
