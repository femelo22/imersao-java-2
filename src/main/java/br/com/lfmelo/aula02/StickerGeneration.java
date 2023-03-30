package br.com.lfmelo.aula02;

import br.com.lfmelo.dtos.StickerDTO;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class StickerGeneration {

    public void create(InputStream inputStream, StickerDTO dto) throws Exception {
        BufferedImage originalImage = ImageIO.read(inputStream);

        //create a new image with transparency and new dimensions
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 200; //add more height

        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = newImage.createGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        var font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setFont(font);

        graphics.setColor(Color.yellow);

        graphics.drawString(dto.getText(), 100, newHeight - 100); // add text

        ImageIO.write(newImage, "png", new File(dto.getOutputPath() + dto.getFileName().concat(".png")));
    }

}
