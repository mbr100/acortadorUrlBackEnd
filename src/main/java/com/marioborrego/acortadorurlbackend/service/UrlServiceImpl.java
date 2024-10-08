package com.marioborrego.acortadorurlbackend.service;

import com.marioborrego.acortadorurlbackend.entities.Url;
import com.marioborrego.acortadorurlbackend.repository.UrlRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UrlServiceImpl implements UrlService{
    private final UrlRepository urlRepository;
    private final Logger logger = LoggerFactory.getLogger(UrlServiceImpl.class);

    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public String generarUrlCorta(String url) {
        logger.info("Generando URL corta para {}", url);
        Optional<Url> existeUrl = urlRepository.findByUrl(url);

        if (existeUrl.isPresent()) {
            return existeUrl.get().getUuid();
        } else {
            Url nuevaUrl = new Url();
            nuevaUrl.setUrl(url);
            nuevaUrl.setUuid(generarUUID());
            urlRepository.save(nuevaUrl);
            return nuevaUrl.getUuid();
        }
    }

    @Override
    public Optional<String> obtenerUrlOriginal(String uuid) {
        logger.info("Obteniendo URL original para {}", uuid);
        return urlRepository.findByUuid(uuid).map(Url::getUrl);
    }

    @Override
    public String generarUUID() {
        return UUID.randomUUID().toString();
    }
}
