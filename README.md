# prueba_manuel_figueiras_gago_back
Prueba técnica Manuel Figueiras Gago (back)

----------------------------------------- NOTAS SOBRE LA PRUEBA --------------------------------------------
- Se entrega una aplicación JAVA 17 + Springboot 3 (utilizando Maven para las dependencias) formada por una arquitectura en capas 
	(intentando utilizar la arquitectura que mejor se adapta a lo requerido y que le permitirá escalar al software en caso de querer apliar sus funcionalidades) 
	en donde se desarrolla un API Rest conformada en este momento por 2 endpoint. Un método GET y otro método POST, que satisfacen lo requerido en el enunciado de la 
	prueba en cucestión.

	- Para su ejecución habrá que colonar el proyecto de GIT a un repositorio local, abrirlo en el IDE que se utilice y arrancarlo como un proyecto de SpringBoot. 
	Esto iniciará el backend en el puerto 8080 (necesario tener versión de Java 17 instalada en el equipo).

	- El backend lleva integrado un swagger para que se pueda ver y probar los 2 endpoints (Post y Get) que se requieren en la prueba (http://localhost:8080/swagger-ui/index.html).

	- Se implementan una serie de unitarias utilizando JUnit. Para ejecutar estos test se lanzará el comando mvn test en la consola del proyecto.

	- Para securizar el API de una manera sencilla se ha implantado un sistema de autenticación básico utilizando Springboot security con 2 usuarios. Uno con rol de USER y otro con roles de USER y ADMIN. Como se trata de una prueba, la generación del parámetro de autenticación se setea directamente en el front. 
	Si la aplicación escalase, esta autenticación debería de hacerse a través de una pantalla de login en donde el usuario pueda introducir sus credenciales para ser posteriormente validadas en una lógica segura implementada en el servidor (back).