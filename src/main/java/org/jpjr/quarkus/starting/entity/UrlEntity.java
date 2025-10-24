package org.jpjr.quarkus.starting.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

import static org.jpjr.quarkus.starting.service.UrlService.generateRandomness;

@MongoEntity(collection = "urls")
@Getter
@Setter
@NoArgsConstructor
public class UrlEntity extends PanacheMongoEntity {

    private UUID userId;
    private String originURL;
    private String shortenedCode;
    private Integer counter;

    public void urlEntity() {
    }

    public UrlEntity(UUID userId, String originURL) {
        this.userId = userId;
        this.originURL = originURL;
        this.counter = 0;
        this.shortenedCode = generateRandomness();
    }
}
