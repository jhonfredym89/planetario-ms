### PLANETARIO-MS
Este es un proyecto API Rest, el cual expone servicios para:

 - Listar todos los Planetas.
 - Ver detalle de un Planeta.
 - Incrementar contador de visitas al detalle de un planeta.
 - Listar el Top 3 de Planetas mas visitados.
 - Listar todas las Personas.
 - Ver el detalle de una Persona.
 - Incrementar contador de visitas de una Persona.
 
Los principales patrones y estilos de arquitectura utilizados en este proyecto, para favorecer el enfoque DDD, son:

#### Arquitectura hexagonal
Arquitectura orientada al dominio del negocio, donde el dominio es el nucleo de todas las capas, tambien es conocida como puertos y adaptadores.  
Se divide princialmente en tres capas, **aplicacion**, **dominio** e **infraestructura**

#### Patron CQRS:  
Patron con el cual dividimos nuestro modelo de objetos en dos, un modelo para consulta y un modelo para comando (modificacion de datos). Este patron es recomendado cuando se va a desarrollar logica de negocio compleja porque ayuda a separar las responsabilidades y a mantener un modelo de negocio consistente. 

#### Estructura del proyecto: 
Se identifican tres carpetas principales, comun, configuracion y microservicio. 

 - Comun: contiene cdigo fuente que comparten todos los microservicios, por ejemplo Utilidades, Manejo de Excepciones, etc.
 - Configuracion: contiene todos los archivos de configuracion, como por ejemplo registro de Beans utilizados en la capa de dominio, configuracion de Swagger, etc.
 - Microservicio: es la carpeta que contiene todo el codigo fuente para el microservicio del proyecto. 
 
#### Especificaciones tecnicas: 
 - Java 8
 - Spring boot 2.5.1
 - Gradle 6.8.x o superior
 - Base de datos H2
 - Acceso a la base de datos por medio de Spring Boot JPA
 - Pruebas unitarias y de integracion con JUnit
 - CQRS a nivel de paquetes
 
#### Ejecutar el proyecto:
 - Clonar el proyecto
 - Ingresar a la carpeta del proyecto: **cd planetario-ms**
 - Compilar el proyecto: **gradle clean build**
 - Ejecutar el proyecto: **gradle bootRun**

### Documentacion de los Servicios
Para revisar la documentacion de los servicios expuestos, ingresa a la siguiente URL: http://localhost:8080/swagger-ui/