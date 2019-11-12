package com.wbdv.projectbackend.model;

public class SearchResponse {

    private String id;
    private String title;
    private String urlPictureSmall;

    public SearchResponse(String id, String title, String urlPictureSmall) {
        this.id = id;
        this.title = title;
        this.urlPictureSmall = urlPictureSmall;
    }

    public SearchResponse() {
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

    public String getUrlPictureSmall() {
        return urlPictureSmall;
    }

    public void setUrlPictureSmall(String urlPictureSmall) {
        this.urlPictureSmall = urlPictureSmall;
    }
}
