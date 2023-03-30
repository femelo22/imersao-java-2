package br.com.lfmelo.controllers;

import br.com.lfmelo.aula02.StickerGeneration;
import br.com.lfmelo.dtos.StickerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.net.URL;

@RestController
@RequestMapping("/")
public class StickerController {

    @PostMapping("/generate-sticker")
    public ResponseEntity createNewSticker(@RequestBody StickerDTO dto) throws Exception {

        var generation = new StickerGeneration();

        InputStream inputStream = new URL(dto.getImageURL()).openStream();

        generation.create(inputStream, dto);

        return ResponseEntity.ok().body("");
    }
}
