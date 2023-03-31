package br.com.lfmelo.models.dtos;


import javax.validation.constraints.NotEmpty;
import java.util.UUID;

public class StickerDTO {

    @NotEmpty(message = "Output path cannot be empty")
    private String outputPath;

    @NotEmpty(message = "Image URL cannot be empty")
    private String imageURL;

    @NotEmpty(message = "Text cannot be empty")
    private String text;

    private String fileName;

    private String position;

    public String getOutputPath() {
        return outputPath;
    }


    public String getImageURL() {
        return imageURL;
    }


    public String getText() {
        return text;
    }


    public String getFileName() {
        return fileName == null ? UUID.randomUUID().toString() : fileName;
    }


    public String getPosition() {
        return position;
    }
}
