package com.wbdv.projectbackend.model;

public class BestBuyProductResponse {

    private int from;
    private int to;
    private int currentPage;
    private int total;
    private int totalPages;
    private float queryTime;
    private float totalTime;
    private boolean partial;
    private String canonicalUrl;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public float getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(float queryTime) {
        this.queryTime = queryTime;
    }

    public float getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(float totalTime) {
        this.totalTime = totalTime;
    }

    public boolean isPartial() {
        return partial;
    }

    public void setPartial(boolean partial) {
        this.partial = partial;
    }

    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    @Override
    public String toString() {
        return "BestBuyProductResponse{" +
                "from=" + from +
                ", to=" + to +
                ", currentPage=" + currentPage +
                ", total=" + total +
                ", totalPages=" + totalPages +
                ", queryTime=" + queryTime +
                ", totalTime=" + totalTime +
                ", partial=" + partial +
                ", canonicalUrl='" + canonicalUrl + '\'' +
                '}';
    }
}
