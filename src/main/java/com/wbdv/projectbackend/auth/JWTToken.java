package com.wbdv.projectbackend.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JWTToken {
    private String idToken;

    public JWTToken(String idToken) {
        this.idToken = idToken;
    }

    @JsonProperty("idToken")
    String getIdToken() {
        return idToken;
    }

    void setIdToken(String idToken) {
        this.idToken = idToken;
    }
}
