package com.wicakson0.urlshortener.service;

import com.wicakson0.urlshortener.model.URL;
import com.wicakson0.urlshortener.repository.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class URLService {
    @Autowired
    private URLRepository urlRepository;

    public URL createShortURL(String longUrl) {
        URL url = new URL();
        url.setLongUrl(longUrl);
        url.setShortUrl(UUID.randomUUID().toString().substring(0, 10));
        url.setCreatedAt(LocalDateTime.now());

        return urlRepository.save(url);
    }

    public Optional<URL> getLongURL(String shortUrl) {
        return urlRepository.findByShortUrl(shortUrl);
    }
}
