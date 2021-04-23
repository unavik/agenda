package com.unavik.agenda.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerContractTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Value("classpath:json/persons.json")
    private Resource persons;

    @DisplayName("Prueba de contrato para el trade")
    @Test
    public void getTradeTest() throws Exception {
        List<String> expectedJsonResponseData = Files.readAllLines(Paths.get(persons.getURI()));

        String expected = String.join("", expectedJsonResponseData);

        ResponseEntity<String> response = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/agenda/person").toString(),
                String.class);

        System.out.println(response.getBody());

        JSONAssert.assertEquals(expected, response.getBody(), JSONCompareMode.STRICT);
    }


}
