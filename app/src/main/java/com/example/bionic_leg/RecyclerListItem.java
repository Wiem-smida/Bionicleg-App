package com.example.bionic_leg;

public class RecyclerListItem {
    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public RecyclerListItem(Integer image, String text) {
        this.image = image;
        this.text = text;
    }

    private Integer image;
    private String text;
}
