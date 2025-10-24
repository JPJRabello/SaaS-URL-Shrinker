package org.jpjr.quarkus.starting.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UrlRequestDTO {

    private UUID userId; //adicionar lógica para validar que não são nulos
    private String originURL;
}
