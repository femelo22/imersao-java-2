package br.com.lfmelo.controllers;

import br.com.lfmelo.services.StickerGenerationService;
import br.com.lfmelo.models.dtos.StickerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.InputStream;
import java.net.URL;

@RestController
public class StickerController {

    @PostMapping("/generate-stickers")
    public ResponseEntity createNewSticker(@RequestBody @Valid StickerDTO dto) throws Exception {

        var generation = new StickerGenerationService();

        InputStream inputStream = new URL(dto.getImageURL()).openStream();

        generation.createSticker(inputStream, dto);

        return ResponseEntity.ok().body("Sticker successfully generated.");
    }


    @GetMapping("/status")
    public ResponseEntity status() {
        return ResponseEntity.ok().body("Running..");
    }
}
