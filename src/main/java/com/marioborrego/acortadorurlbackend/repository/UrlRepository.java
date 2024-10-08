package com.marioborrego.acortadorurlbackend.repository;

import com.marioborrego.acortadorurlbackend.entities.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByUuid(String shortUrl);
    Optional<Url> findByUrl(String url);
}