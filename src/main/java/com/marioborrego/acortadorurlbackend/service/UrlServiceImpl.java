package com.marioborrego.acortadorurlbackend.service;

import com.marioborrego.acortadorurlbackend.entities.Url;
import com.marioborrego.acortadorurlbackend.repository.UrlRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        if (!StringUtils.hasText(url)) {
            throw new IllegalArgumentException("La URL proporcionada no puede estar vacía");
        }
        return urlRepository.findByUrl(url)
                .map(Url::getUrl)
                .orElseGet(() -> {
                    String uuid = generarUUID();
                    Url nuevaUrl = Url.builder()
                            .url(url)
                            .uuid(uuid)
                            .build();
                    urlRepository.save(nuevaUrl);
                    return uuid;
                });
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
