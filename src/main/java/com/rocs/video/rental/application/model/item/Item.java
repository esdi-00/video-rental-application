package com.rocs.video.rental.application.model.item;

public class Item {

    private String id;

    private String title;

    private String genre;

    private int copy;

    public Item() {
    }

    public Item(String id, String title, String genre, int copy) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.copy = copy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }
}
