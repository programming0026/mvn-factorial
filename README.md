# Factorial con varias estrategias

Calcula el factorial de un número con cinco algoritmos distintos (patrón Strategy), y compara su resultado, tiempo y memoria.

## Características

- **Recursivo** e **iterativo** con `long` (exactos hasta 20!).
- **BigInteger** (bucle) exacto hasta 10 000!.
- **Optimizado**: divide y vencerás con caché.
- **Stirling**: aproximación en notación científica, sin límite de tamaño.
- Medición de tiempo y memoria de cada estrategia.

## Requisitos

- JDK 21 y Maven 3.9 o superior.

## Compilar y ejecutar

```bash
mvn compile exec:java
```

## Estructura

```text
src/main/java/com/juniverse/math/
├── Main.java
├── algorithms/   # estrategias y calculadora
└── util/         # consola UTF-8 y métricas
```

## Notas

- La métrica de memoria es aproximada porque depende del recolector de basura.
- Para n ≤ 20 sirven todas; para n grande usa `biginteger` u `optimizado`.

## JAR ejecutable (fat jar)

```bash
mvn clean package
java -jar target/mvn-factorial-1.0-SNAPSHOT-launcher.jar
```

El archivo `-launcher.jar` incluye todas las dependencias.

## Licencia

Código de ejemplo de uso libre con fines educativos.
