package com.example.myapplication.Activity;

public class RecyclerViewListActivity {
    // ATTRIBUTES
    private Integer image;
    private String text;
    // CONSTRUCTOR
    public RecyclerViewListActivity(Integer image, String text) {
        this.image = image;
        this.text = text;
    }
    // METHODS
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
}
