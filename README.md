# Sistema de Atención de Emergencias del Hospital

Esta Hoja de Trabajo implementa un sistema de colas con prioridad para atender pacientes en la emergencia de un hospital. Utiliza una estructura de datos de heap para manejar las prioridades de los pacientes de manera eficiente.

## Características

- Implementación personalizada de un heap binario (`VectorHeap`).
- Interfaz de usuario simple para interactuar con el sistema.
- Capacidad de elegir entre la implementación personalizada y la `PriorityQueue` de Java.

## Instrucciones de Uso

Para ejecutar el sistema de atención de emergencias, siga estos pasos:

1. Compile el código fuente.
2. Ejecute `EmergencyRoomSystem` y seleccione el tipo de cola de prioridad a utilizar.
3. Asegúrese de que el archivo `pacientes.txt` esté en el directorio correcto y contenga los datos de los pacientes en el formato apropiado.

## Formato de Archivo de Pacientes

El archivo `pacientes.txt` debe seguir el siguiente formato, donde cada línea representa un paciente:

## Ejemplo

Juan Perez, fractura de pierna, C
Maria Ramirez, apendicitis, A

Los códigos de emergencia deben estar en el rango de la `A` (más urgente) a la `E` (menos urgente).

## Dependencias

Este proyecto requiere Java 8 o superior.

## Autor

- Joel Antonio Jaquez López - Desarrollo inicial
- 23369 - Carné
