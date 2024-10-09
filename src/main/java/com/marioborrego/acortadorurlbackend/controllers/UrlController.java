package com.marioborrego.acortadorurlbackend.controllers;

import com.marioborrego.acortadorurlbackend.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
public class UrlController {
    private final UrlService urlService;
    private final Logger logger = LoggerFactory.getLogger(UrlController.class);

    @Value("${app.url.shortener.domain}")
    private String dominio;

    @Value("${app.url.shortener.URL_PATH}")
    private String URL_PATH;

    @Value("${app.url.shortener.REDIRECT_URL_PATH}")
    private String REDIRECT_URL_PATH;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/")
    public String index() {
        return "¡Bienvenido al acortador de URL!";
    }

    @GetMapping("obtenerUrlOriginal/{uuid}")
    public ResponseEntity<Map<String, String>> obtenerUrlOriginal(@PathVariable("uuid") String uuid) {
        Optional<String> originalUrl = urlService.obtenerUrlOriginal(uuid);

        return originalUrl.map(url -> {
            logger.info("URL encontrada para {}", uuid);
            return ResponseEntity.ok(Map.of("url", url));
        }).orElseGet(() -> {
            logger.warn("URL no encontrada para {}", uuid);
            return ResponseEntity.status(404).body(Map.of("url", dominio + REDIRECT_URL_PATH));
        });
    }

    @PostMapping("obtenerUrlCorta")
    public ResponseEntity<Map<String, String>> obtenerUrlCorta(@RequestBody Map<String, String> request) {
        logger.info("Petición para generar URL corta");
        String url = request.get("url");
        logger.info("Generando URL corta para {}", url);
        String shortUrl = urlService.generarUrlCorta(url);

        return ResponseEntity.ok(Map.of("urlCorta", dominio + URL_PATH + shortUrl));
    }
}
