package com.wicakson0.urlshortener.controller;

import com.wicakson0.urlshortener.model.URL;
import com.wicakson0.urlshortener.repository.URLRepository;
import com.wicakson0.urlshortener.service.URLService;
import com.wicakson0.urlshortener.dto.UrlPairDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

@RestController
@RequestMapping("/api")
public class URLController {
    @Autowired
    private URLService urlService;

    @Autowired
    private URLRepository urlRepository;

    @PostMapping("/shorten")
    public ResponseEntity<URL> shortenURL(@RequestBody URL urlRequest) {
        URL url = urlService.createShortURL(urlRequest.getLongUrl());
        return new ResponseEntity<>(url, HttpStatus.CREATED);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<?> redirectURL(@PathVariable String shortCode) {
        Optional<URL> url = urlService.getLongURL(shortCode);
        if (url.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", url.get().getLongUrl())
                    .build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("URL not found");
        }
    }

    @GetMapping("/all")
    public List<UrlPairDto> getAllUrlPairs(){
        List<URL> urlList = urlRepository.findAll();

        return urlList
            .stream()
            .map(url -> new UrlPairDto(url.getLongUrl(), url.getShortUrl()))
            .collect(Collectors.toList());

    }
}
