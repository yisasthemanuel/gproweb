# GPRO WEB UPDATER

## Introducción

Libería que obtiene información de la web de GPRO conectándose como un usuario y parseando la respuesta html a las peticiones enviadas. Información que obtiene en estos momentos:

* Manager History de los managers que permitan acceder a su página de manager en GPRO.

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
## TO DOs

* Integrar con Artifactory para publicar las nuevas releases
* Meter dependencia Lombok
* Servicio para obtener los resultados de los managers en las disintas carreras
* Testing