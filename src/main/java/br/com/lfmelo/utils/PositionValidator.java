package br.com.lfmelo.utils;

import br.com.lfmelo.models.dtos.StickerDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionValidator {

    public static String getPosition(StickerDTO dto) {
        if(dto.getPosition() == null || dto.getPosition().equals("")) {
            return "BOTTOM";
        } else if (!POSITIONS.contains(dto.getPosition().toUpperCase())) {
            throw new RuntimeException("Position not allowed");
        } else {
            return dto.getPosition();
        }
    }

    private static List<String> POSITIONS = new ArrayList<>(Arrays.asList("TOP", "MIDDLE", "BOTTOM"));
}
