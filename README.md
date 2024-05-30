# GPRO WEB UPDATER

## Introducción

Libería que obtiene información de la web de GPRO conectándose como un usuario y parseando la respuesta html a las peticiones enviadas. Información que obtiene en estos momentos:

* Manager History de los managers que permitan acceder a su página de manager en GPRO.
* Records del equipo en un circuito determinado. Se obtienen cuatro records: clasificación en seco, clasificación en mojado, carrera en seco y carrera en mojado.

## Desarrollo

### Prerequisitos

* Un IDE con soporte al proyecto Lombok (<https://projectlombok.org/>): Eclipse, IntelliJ, Visual Studio Code.
* Máquina Java versión 17 instalada. Por ejemplo, la JVM OpenJ17 instalada (<https://adoptium.net/es/temurin/releases/?os=linux&version=17&package=jdk>
* Maven: No necesario, está integrado en el proyecto mediante "maven wrapper" / mvnw (<https://github.com/takari/maven-wrapper>)


## Construcción

Para generar el jar

```sh
$ cd gproweb
$ ./mvnw clean package
```

Para publicar el jar en el repositorio maven local

```sh
$ cd gproweb
$ ./mvnw clean install
```

## Changelog [ES]

* **1.0.3 (30/05/2024)** - Se utiliza WebDriverManager para asegurar la correcta configuración del driver de Chrome a la hora de ejecutar la navegación por la web. Se configura el driver para que navegue sin generar interfaz gráfica (headless)

* **1.0.2 (21/04/2024)** - Se utiliza SeleniumHQ para obtener los datos de la web de GPRO. Se añade el método getTrackRecordsInfo para obtener los records de un circuito. Se obtienen cuatro records por cada circuito: clasificación en seco, carrera en seco, clasificación en mojado, carrera en mojado

## TO DOs

* Integrar con Artifactory para publicar las nuevas releases
* Servicio para obtener los resultados de los managers en las disintas carreras
* Refactorizar para crear una clase base de la que extiendan todas las implementaciones de GPROWebSession
* Revisar que la información se puede obtener de igual forma con el estilo antiguo. Actualmente sólo se ha probado con el estilo nuevo
* Probar a obtener la información en varios idiomas
* Deprecar el uso de GPROWebSessionJWebUnit