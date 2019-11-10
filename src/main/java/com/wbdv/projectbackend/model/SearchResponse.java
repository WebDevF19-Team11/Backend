package com.wbdv.projectbackend.model;

public class SearchResponse {

    private Integer id;
    private String title;
    private String urlPictureSmall;

    public SearchResponse(Integer id, String title, String urlPictureSmall) {
        this.id = id;
        this.title = title;
        this.urlPictureSmall = urlPictureSmall;
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

    public String getUrlPictureSmall() {
        return urlPictureSmall;
    }

    public void setUrlPictureSmall(String urlPictureSmall) {
        this.urlPictureSmall = urlPictureSmall;
    }
}
