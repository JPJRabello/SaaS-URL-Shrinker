package org.jpjr.quarkus.starting.dto;

import java.util.UUID;

public class UrlRequestDTO {

    private UUID userId; //adicionar lógica para validar que não são nulos
    private String originURL;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getOriginURL() {
        return originURL;
    }

    public void setOriginURL(String originURL) {
        this.originURL = originURL;
    }
}
