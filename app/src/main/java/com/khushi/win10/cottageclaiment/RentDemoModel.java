package com.khushi.win10.cottageclaiment;

/**
 * Created by Win10 on 17-02-2017.
 */

public class RentDemoModel {
    private String name;
    private String location;
    private String rating;
    private String rank;
    private String price;

    public int getImageViewCottage() {
        return imageViewCottage;
    }

    public void setImageViewCottage(int imageViewCottage) {
        this.imageViewCottage = imageViewCottage;
    }

    private int imageViewCottage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
