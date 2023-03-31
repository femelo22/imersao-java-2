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

    public String fileName;

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFileName() {
        return fileName == null ? UUID.randomUUID().toString() : fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
