# 📱 Agenda Telefónica

![Java](https://img.shields.io/badge/Java-11%2B-ED8B00?logo=openjdk&logoColor=white)
![Aplicación de consola](https://img.shields.io/badge/Interfaz-Consola-2563EB)
![Hackathon](https://img.shields.io/badge/Desarrollo-Hackathon-7C3AED)

**Agenda Telefónica** es una aplicación de consola desarrollada en Java para **organizar, consultar y administrar contactos de manera sencilla**. Su diseño prioriza operaciones claras, control de duplicados y gestión de una capacidad configurable, sin depender de servicios externos.

El proyecto fue construido de forma colaborativa durante un hackathon, desde el diseño de las entidades hasta la integración de las funcionalidades y las pruebas desde consola.

## 🚀 Características

- **Registro de contactos:** agrega nombre, apellido y número telefónico.
- **Prevención de duplicados:** identifica contactos por nombre y apellido, sin distinguir mayúsculas y minúsculas, independientemente del teléfono.
- **Búsqueda y consulta:** localiza contactos y muestra su número telefónico.
- **Listado alfabético:** presenta los contactos ordenados por nombre y apellido.
- **Actualización de teléfonos:** modifica el número de un contacto existente.
- **Eliminación de contactos:** elimina registros y recupera espacio disponible.
- **Control de capacidad:** verifica si la agenda está llena y cuántos lugares quedan.
- **Menú interactivo:** permite utilizar todas las operaciones desde la terminal.

## 🛠️ Stack tecnológico

| Tecnología / concepto | Aplicación |
| --- | --- |
| **Java 11+** | Implementación de la aplicación. |
| **Programación orientada a objetos** | Separación de responsabilidades en clases y encapsulamiento de datos. |
| **Arreglos (`Contacto[]`)** | Almacenamiento en memoria con capacidad limitada. |
| **Java Standard Library** | `Scanner`, `Arrays`, `Comparator`, `Pattern` y `Matcher`. |
| **Expresiones regulares** | Validación adicional del formato de teléfono. |
| **Manejo de excepciones** | Rechazo de datos inválidos durante el registro de contactos. |

## 🏗️ Arquitectura

```text
com/
└── hackathon2/
    ├── AgendaApp.java
    └── Entities/
        ├── Agenda.java
        └── Contacto.java
```

- **`Contacto`**: representa los datos de un contacto, valida los datos de entrada y define la comparación por nombre y apellido.
- **`Agenda`**: administra el almacenamiento, la capacidad máxima y las operaciones sobre los contactos.
- **`AgendaApp`**: proporciona el punto de entrada (`main`) y el menú interactivo de consola.

## ▶️ Cómo ejecutar

**Requisitos:** JDK 11 o superior y un entorno compatible con Java.

1. Clona o descarga el repositorio.
2. Abre el proyecto en tu IDE o entorno Java preferido.
3. Ejecuta la clase `com.hackathon2.AgendaApp`.
4. Ingresa la capacidad máxima de la agenda y utiliza el menú de opciones.

> La clase `Agenda` admite una capacidad predeterminada de **10 contactos** mediante `new Agenda()` o una capacidad personalizada con `new Agenda(capacidad)`. La aplicación de consola solicita la capacidad al iniciar.

### Menú principal

```text
==================================
      MENÚ DE GESTIÓN DE AGENDA
==================================
1. Añadir contacto
2. Verificar si existe contacto
3. Listar contactos
4. Buscar contacto
5. Eliminar contacto
6. Modificar teléfono
7. Verificar si la agenda está llena
8. Mostrar espacios libres
9. Salir
Seleccione una opción:
```

### Ejemplo de salida

```text
Ana García - 5512345678
Daniel Rosas - 5598765432
Mara González - 5511122233
```

*Los registros anteriores son ilustrativos.*

## ⚙️ Reglas de negocio

- Cada contacto se identifica por la combinación de **nombre y apellido**.
- No se admiten nombres ni apellidos vacíos.
- No pueden existir dos contactos con el mismo nombre y apellido, aunque tengan diferentes números telefónicos.
- El equipo incorporó una validación de formato telefónico mediante expresiones regulares.
- La cantidad de contactos no puede superar la capacidad definida para la agenda.
- El almacenamiento es **temporal y en memoria**: los contactos no se conservan después de cerrar la aplicación.

## 🤝 Forma de trabajo

El equipo siguió un **proceso colaborativo e iterativo**: definición de requisitos, diseño de entidades, implementación incremental, integración de funcionalidades y pruebas manuales. Este enfoque permitió revisar decisiones técnicas y ajustar el comportamiento de la aplicación a medida que avanzó el desarrollo.

La organización se inspiró en principios de trabajo ágil, **sin atribuir al proyecto una implementación formal de Scrum**.

## 🧪 Casos de prueba

| Escenario | Comportamiento esperado |
| --- | --- |
| Añadir un contacto válido | Se registra en la agenda. |
| Añadir un contacto duplicado | Se rechaza el registro. |
| Introducir nombre o apellido vacío | Se informa del error. |
| Buscar un contacto existente | Se muestra su teléfono. |
| Buscar un contacto inexistente | Se informa que no fue encontrado. |
| Listar varios contactos | Se muestran alfabéticamente. |
| Eliminar un contacto | Se libera un espacio. |
| Alcanzar la capacidad máxima | Se impide agregar más contactos. |
| Actualizar un teléfono | Se intenta validar y guardar el nuevo número. |

> Estos son escenarios de validación propuestos; no representan resultados de pruebas automatizadas.

## 👥 Equipo

- **Dante Escamilla**
- **Daniel Rosas**
- **Víctor Lazaro**
- **Mara González**
- **Laura Rojas**

---

**Desarrollado en equipo durante un hackathon.**
