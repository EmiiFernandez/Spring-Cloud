#Versión de Java utilizado. Tiene que estar
#instalada en el contenedor para poder ejecutar
#el proyecto
FROM openjdk:17
#Dirección del ejecutable.
#Por defecto se crea dentro de la carpeta target
ARG JAR_FILE=target/eureka-server.jar
#Copia el archivo y lo renombra app.jar
COPY ${JAR_FILE} app.jar
#Una vez que se encuentra dentro del contenedor
#Con entrypoint ejecuta el comando [...] para ejecutar el proyecto
ENTRYPOINT ["java","-jar","app.jar"]
#Este puerto ya lo configuramos
EXPOSE 8761

