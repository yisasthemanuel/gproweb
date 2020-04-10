# GPRO WEB UPDATER

## Introducción

Libería que obtiene información de la web de GPRO contenándose como un usuario y parseando la respuesta html a las peticiones enviadas. Información que obtiene en estos momentos:

* Manager History de los managers que permitan acceder a su página de manager en GPRO.


## Desarrollo

### Prerequisitos

* Un IDE con soporte al proyecto Lombok (<https://projectlombok.org/>): Eclipse, IntelliJ, Visual Studio Code.
* Máquina versión Java instalada. Bien:
** JKD 1.8 de Oracle
** La JVM OpenJ9 instalada (<https://adoptopenjdk.net/installation.html#linux-pkg>, <https://adoptopenjdk.net/releases.html?variant=openjdk8&jvmVariant=openj9>)
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
* servicio para obtener los resultados de los managers en las disintas carreras
* Testing