package com.marioborrego.acortadorurlbackend.controllers;

import com.marioborrego.acortadorurlbackend.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
public class UrlController {
    private final UrlService urlService;
    private final Logger logger = LoggerFactory.getLogger(UrlController.class);

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/")
    public String index() {
        return "¡Bienvenido al acortador de URL!";
    }

    @GetMapping("obtenerUrlOriginal/{uuid}")
    public ResponseEntity<Map<String,String>> obtenerUrlOriginal(@PathVariable String uuid) {
        Optional<String> originalUrl = urlService.obtenerUrlOriginal(uuid);
        Map<String,String> url = new HashMap<>();
        if (originalUrl.isPresent()) {
            url.put("url", originalUrl.get());
            logger.info("URL encontrada para {}", uuid);
            logger.info("Redirigiendo a {}", url);
            return ResponseEntity.status(200).body(url);
        } else {
            logger.warn("URL no encontrada para {}", uuid);
            url.put("url", "http://localhost:4200/acortar");
            return ResponseEntity.status(404).body(url);
        }
    }

    @PostMapping("obtenerUrlCorta")
    public ResponseEntity<Map<String, String>> obtenerUrlCorta(@RequestBody Map<String, String> request) {
        String url = request.get("url"); // La URL se pasa en el cuerpo de la petición
        logger.info("Generando URL corta para {}", url);
        String shortUrl = urlService.generarUrlCorta(url);
        Map<String, String> response = new HashMap<>();
        String dominio = "http://localhost:4200/obtenerUrlOriginal/";
        response.put("urlCorta", dominio + shortUrl);
        return ResponseEntity.status(200).body(response);
    }
}
