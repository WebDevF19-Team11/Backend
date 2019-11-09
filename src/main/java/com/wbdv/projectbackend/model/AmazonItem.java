package com.wbdv.projectbackend.model;

public class AmazonItem {

    private Integer id;
    private String title;
    private String author;
    private String manufacturer;
    private String productGroup;

    public AmazonItem(Integer id, String title, String author, String manufacturer, String productGroup) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.manufacturer = manufacturer;
        this.productGroup = productGroup;
    }

    public AmazonItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
