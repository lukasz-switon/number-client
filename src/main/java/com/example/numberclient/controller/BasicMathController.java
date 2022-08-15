package com.example.numberclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequiredArgsConstructor
public class BasicMathController {
    private final RestTemplate restTemplate;

    @GetMapping("/calculate")
    public String checkOddAndEven(@RequestParam("number") Integer number) {
        var httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        var exchange = restTemplate.exchange("http://localhost:8090/validate/prime-number?number=" + number,
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                String.class);
        return exchange.getBody();
    }
}
