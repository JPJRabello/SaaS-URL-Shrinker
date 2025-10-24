package org.jpjr.quarkus.starting.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static org.jpjr.quarkus.starting.service.UrlService.generateRandomness;

@MongoEntity(collection = "urls")
@Getter
@Setter
@NoArgsConstructor
public class UrlEntity extends PanacheMongoEntity {

    private String userId;
    private String originURL;
    private String shortenedCode;
    private Integer counter;

    public void urlEntity() {
    }

    public UrlEntity(String userId, String originURL) {
        this.userId = userId;
        this.originURL = originURL;
        this.counter = 0;
        this.shortenedCode = generateRandomness();
    }
}
