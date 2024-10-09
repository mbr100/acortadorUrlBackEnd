# Usar una imagen base de Java
FROM openjdk:23
# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR de la aplicación
COPY target/acortadorUrlBackEnd-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto de la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]