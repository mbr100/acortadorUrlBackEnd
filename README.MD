# Acortador de URL - Backend

Este proyecto consiste en el desarrollo del backend de una aplicación para acortar URLs. Se trata de un servicio que permite a los usuarios introducir una URL
larga, acortarla y recuperarla posteriormente a través de un enlace.

## Tecnologías Utilizadas

- <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" alt="Java logo" width="20" height="20"/> Java 23
- <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" alt="Spring Boot logo" width="20" height="20"/> Spring Boot 3.2
- <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" alt="MySQL logo" width="20" height="20"/> MySQL 9
- <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/docker/docker-original.svg" alt="Docker logo" width="20" height="20"/> Docker
- <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/docker/docker-plain.svg" alt="Docker Compose logo" width="20" height="20"/> Docker Compose

## Características

- **Acortar URLs**: Permite a los usuarios enviar una URL larga y obtener una versión corta.
- **Recuperar URLs**: Los usuarios pueden recuperar la URL original a través de la URL acortada.
- **Interfaz API**: Proporciona una API RESTful para interactuar con el servicio.

## Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/mbr100/acortador-url-backend.git

2. Navega al directorio del proyecto:
    ```bash
    cd acortador-url-backend
    ```
3. Levanta los servicios usando Docker Compose:
    ```bash
    docker-compose up
    ```
4. Accede a la aplicación en tu entorno local.

## Uso de la API

### Acortar URL

- **Endpoint**: `POST "/obtenerUrlCorta"`
- **Cuerpo**:
  ```json
  {
    "url": "http://ejemplo.com"
  }
- **Respuesta**:
    ```json
      {
        "urlCorta": "http://localhost:8080/{UUID}"
      }

### Recuperar URL Original

- **Endpoint**: `GET "/obtenerUrlOriginal/{uuid}"`
- **Respuesta**:
    ```json
      {
        "urlOriginal": "http://ejemplo.com"
      }
- **Respuesta de Error (si la URL no existe)**:
    ```json
      {
        "mensaje": "Dominio/obtenerUrlCorta"
      }

## Notas

- CORS: La API permite solicitudes desde http://localhost:4200, lo que es útil para la interacción con el frontend de Angular.
- Asegúrate de reemplazar localhost:4200 con la dirección de tu servidor si lo despliegas en un entorno diferente.

## Enlace al FrontEnd
Este proyecto requiere un FrontEnd para funcionar correctamente. Puedes encontrar el FrontEnd del proyecto [aquí](https://github.com/mbr100/acortadorUrlFrontEnd).

## Contribuciones

Las contribuciones son bienvenidas. Para contribuir:

- Haz un fork del proyecto.
- Crea una rama para tu función (feature/nueva-funcion).
- Realiza un pull request con una descripción clara de tu contribución.

## Licencia

Este proyecto está licenciado bajo la Licencia Creative Commons Atribución-NoComercial 4.0 Internacional (CC BY-NC 4.0). Puedes usar, modificar y distribuir el
código para fines no comerciales siempre que otorgues el crédito correspondiente a su autor, Mario Borrego. Para cualquier uso comercial de este software, por
favor, contacta previamente con el autor.

Para más detalles, visita: CC BY-NC 4.0.

<div style="margin-top: 20px;">
    <div class="footer" style="text-align: center;">
        &copy; 2024 Mario Borrego
    </div>
</div>
