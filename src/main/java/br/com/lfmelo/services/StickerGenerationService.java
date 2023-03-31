package br.com.lfmelo.services;

import br.com.lfmelo.models.dtos.StickerDTO;
import br.com.lfmelo.utils.PositionValidator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class StickerGenerationService {


    public void createSticker(InputStream inputStream, StickerDTO dto) {
        //TODO: ADD TOP POSITION
        String position = PositionValidator.getPosition(dto);

        if(position.equals("MIDDLE")) {
            createCenter(inputStream, dto);
        } else {
            create(inputStream, dto);
        }

    }


    public void create(InputStream inputStream, StickerDTO dto) {

        try {
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

            // center text in image
            FontMetrics metrics = graphics.getFontMetrics(font);
            int x = (width - metrics.stringWidth(dto.getText())) / 2;
            int y = newHeight - 70;

            // draw text in image
            graphics.drawString(dto.getText(), x, y);

            ImageIO.write(newImage, "png", new File(dto.getOutputPath() + "/" + dto.getFileName().concat(".png")));
        } catch (Exception ex) {
            throw new RuntimeException("Error: " + ex.getMessage() + " - " + ex.getLocalizedMessage());
        }

    }

    public void createCenter(InputStream inputStream, StickerDTO dto) {

        try {

            BufferedImage image = ImageIO.read(inputStream);

            Graphics2D graphics = image.createGraphics();
            Font font = new Font("Arial", Font.BOLD, 64);

            FontMetrics metrics = graphics.getFontMetrics(font);

            int width = image.getWidth();
            int height = image.getHeight();

            int x = (width - metrics.stringWidth(dto.getText())) / 2;
            int y = height - 500;

            // draw text in image
            graphics.setFont(font);
            graphics.setColor(Color.WHITE);
            graphics.drawString(dto.getText(), x, y);
            graphics.dispose();

            ImageIO.write(image, "jpg", new File(dto.getOutputPath() + "/" + dto.getFileName().concat(".png")));

        } catch (Exception ex) {
            throw new RuntimeException("Error: " + ex.getMessage() + " - " + ex.getLocalizedMessage());
        }

    }

}
