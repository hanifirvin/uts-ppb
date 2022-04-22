package com.ck4u.booking;

public class hotel {
    private int id;
    private String name;
    private String location;
    private String price;
    private String description;
    private String note;
    private int hotelType;
    private int image;
    private int review;
    private boolean isFavorite;

    public hotel(int id, String name, String location, String price, String description, String note, int hotelType, int image, int review, boolean isFavorite) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.description = description;
        this.note = note;
        this.hotelType = hotelType;
        this.image = image;
        this.review = review;
        this.isFavorite = isFavorite;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getNote() {
        return note;
    }

    public int getHotelType() {
        return hotelType;
    }

    public int getImage() {
        return image;
    }

    public int getReview() {
        return review;
    }

    public boolean isFavorite() {
        return isFavorite;
    }
}
