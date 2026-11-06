package com.juniverse.math.algorithms;

import com.juniverse.math.util.ConsoleHelper;
import com.juniverse.math.util.PerformanceMetrics;

/**
 * Calculadora que permite elegir y comparar distintas estrategias de factorial.
 *
 * @author Java Universe
 */
public class FactorialCalculator {
    private final java.util.Map<String, FactorialStrategy> strategies;
    private FactorialStrategy currentStrategy;
    
    /** Registra las cinco estrategias; la predeterminada es "optimizado". */
    public FactorialCalculator() {
        strategies = new java.util.HashMap<>();
        strategies.put("recursivo", new RecursiveFactorial());
        strategies.put("iterativo", new IterativeFactorial());
        strategies.put("biginteger", new BigIntegerFactorial());
        strategies.put("optimizado", new OptimizedFactorial());
        strategies.put("stirling", new StirlingApproximation());
        
        // Estrategia por defecto
        currentStrategy = strategies.get("optimizado");
    }

    /** Estrategia seleccionada actualmente. */
    public FactorialStrategy getCurrentStrategy() {
        return currentStrategy;
    }
    
    /**
     * Cambia la estrategia activa.
     * @param strategyName recursivo, iterativo, biginteger, optimizado o stirling
     * @throws IllegalArgumentException si el nombre no existe
     */
    public void setStrategy(String strategyName) {
        FactorialStrategy strategy = strategies.get(strategyName.toLowerCase());
        if (strategy == null) {
            throw new IllegalArgumentException("Estrategia no válida: " + strategyName);
        }
        currentStrategy = strategy;
    }
    
    /**
     * Calcula n! con la estrategia activa.
     * @param n número no negativo
     */
    public String calculate(int n) {
        return currentStrategy.calculate(n);
    }
    
    /**
     * Calcula n! y devuelve el resultado junto con el tiempo y la memoria usados.
     * @param n número no negativo
     */
    public String calculateWithMetrics(int n) {
        PerformanceMetrics metrics = new PerformanceMetrics();
        
        metrics.start();
        String result = currentStrategy.calculate(n);
        metrics.end();
        
        return String.format("Resultado: %s\nEstrategia: %s\nMétricas: %s",
                           result, currentStrategy.getName(), metrics);
    }
    
    /**
     * Ejecuta todas las estrategias con el mismo {@code n} e imprime resultado y métricas.
     * @param n número no negativo
     */
    public void compareStrategies(int n) {
        ConsoleHelper.println("=== Comparación de Estrategias para n = " + n + " ===\n");
        
        for (java.util.Map.Entry<String, FactorialStrategy> entry : strategies.entrySet()) {
            FactorialStrategy strategy = entry.getValue();
            
            try {
                PerformanceMetrics metrics = new PerformanceMetrics();
                
                metrics.start();
                String result = strategy.calculate(n);
                metrics.end();
                
                ConsoleHelper.printf("%s:\n", strategy.getName());
                ConsoleHelper.printf("  Resultado: %s\n", 
                                result.length() > 50 ? result.substring(0, 50) + "..." : result);
                ConsoleHelper.printf("  Métricas: %s\n", metrics);
                ConsoleHelper.printf("  Soporta números grandes: %s\n\n", 
                                strategy.supportsLargeNumbers() ? "Sí" : "No");
                
            } catch (Exception e) {
                ConsoleHelper.printf("%s:\n", strategy.getName());
                ConsoleHelper.printf("  Error: %s\n\n", e.getMessage());
            }
        }
    }
    
    /** Nombres de las estrategias disponibles. */
    public java.util.Set<String> getAvailableStrategies() {
        return strategies.keySet();
    }
    
    /** Nombre descriptivo de la estrategia activa. */
    public String getCurrentStrategyName() {
        return currentStrategy.getName();
    }
}
