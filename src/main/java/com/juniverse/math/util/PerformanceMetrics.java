package com.juniverse.math.util;

/**
 * Mide el tiempo y la memoria aproximada que consume un cálculo.
 *
 * @author Java Universe
 */
public class PerformanceMetrics {

    private long startTime;
    private long endTime;
    private long memoryBefore;
    private long memoryAfter;

    /** Marca el inicio de la medición (tiempo y memoria). */
    public void start() {
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        startTime = System.nanoTime();
    }

    /** Marca el fin de la medición. */
    public void end() {
        endTime = System.nanoTime();
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    /** Tiempo transcurrido en nanosegundos. */
    public long getExecutionTimeNs() {
        return endTime - startTime;
    }

    /** Tiempo transcurrido en milisegundos. */
    public double getExecutionTimeMs() {
        return (endTime - startTime) / 1_000_000.0;
    }

    /** Diferencia de memoria usada en bytes (aproximada: depende del recolector de basura). */
    public long getMemoryUsed() {
        return memoryAfter - memoryBefore;
    }

    /** Resumen legible de tiempo y memoria. */
    @Override
    public String toString() {
        return String.format("Tiempo: %.2f ms, Memoria: %d bytes",
                getExecutionTimeMs(), getMemoryUsed());
    }
}
