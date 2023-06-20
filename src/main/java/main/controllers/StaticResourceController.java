package main.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/api/static")
public class StaticResourceController {

    @GetMapping(value = "{fileName}", produces = "text/javascript")
    public byte[] getScriptFile(@PathVariable String fileName) throws IOException {
        Resource resource = new ClassPathResource("static/" + fileName);
        return Files.readAllBytes(Path.of(resource.getURI()));
    }

    @GetMapping(value = "/styles.css", produces = "text/css")
    public byte[] getStyleFile() throws IOException {
        Resource resource = new ClassPathResource("static/styles.css");
        return Files.readAllBytes(Path.of(resource.getURI()));
    }
}
