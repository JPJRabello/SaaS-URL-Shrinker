package org.jpjr.quarkus.starting.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.jpjr.quarkus.starting.entity.UrlEntity;

@ApplicationScoped
public class UrlRepository implements PanacheMongoRepository<UrlEntity> {

    public UrlEntity findByShortenedCode(String code) {
        return find("shortenedCode", code).firstResult();
    }

}
