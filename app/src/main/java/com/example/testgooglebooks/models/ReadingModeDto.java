package com.example.testgooglebooks.models;

public class ReadingModeDto {

    private Boolean text;
    private Boolean image;

    public Boolean getText() {
        return text;
    }

    public void setText(Boolean text) {
        this.text = text;
    }

    public Boolean getImage() {
        return image;
    }

    public void setImage(Boolean image) {
        this.image = image;
    }

    public ReadingModeDto(Boolean text, Boolean image) {
        this.text = text;
        this.image = image;
    }
}
