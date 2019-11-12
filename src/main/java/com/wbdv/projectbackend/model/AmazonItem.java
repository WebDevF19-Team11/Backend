package com.wbdv.projectbackend.model;

public class AmazonItem {

    private String id;
    private String title;
    private String author;
    private String manufacturer;
    private String productGroup;
    private String url;
    private String largeImageUrl;

    public AmazonItem(String id, String title, String author, String manufacturer, String productGroup, String url, String largeImageUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.manufacturer = manufacturer;
        this.productGroup = productGroup;
        this.url = url;
        this.largeImageUrl = largeImageUrl;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLargeImageUrl() {
        return largeImageUrl;
    }

    public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
    }
}
