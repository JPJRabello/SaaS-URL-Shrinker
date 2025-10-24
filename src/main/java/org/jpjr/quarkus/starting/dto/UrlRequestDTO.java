package org.jpjr.quarkus.starting.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlRequestDTO {

    private String userId; //adicionar lógica para validar que não são nulos
    private String originURL;
}
