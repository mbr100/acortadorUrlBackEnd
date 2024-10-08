package com.marioborrego.acortadorurlbackend.service;

import java.util.Optional;

public interface UrlService {
    Optional<String> obtenerUrlOriginal(String uuid);
    String generarUrlCorta(String url);
    String generarUUID();
}
