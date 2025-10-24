package org.jpjr.quarkus.starting.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.jpjr.quarkus.starting.entity.UrlEntity;
import org.jpjr.quarkus.starting.repository.UrlRepository;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

@ApplicationScoped
public class UrlService {

    @Inject
    UrlRepository urlRepository;

    private static final SecureRandom random = new SecureRandom();
    private static final Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();

    public static String generateRandomness() {
        byte[] buffer = new byte[8];
        random.nextBytes(buffer);
        String encoded = encoder.encodeToString(buffer);
        return encoded.substring(0, 10);
    }

    public String getOrinalUrl(String shortenedCode) {
        UrlEntity entity = urlRepository.findByShortenedCode(shortenedCode);
        if (entity == null) {
            throw new NotFoundException("URL não encontrada para o código: " + shortenedCode);
        }
        return entity.getOriginURL();
    }

    public UrlEntity createShortenedUrl(UUID userId, String originURL) {
        String newCode = generateRandomness(); //implementar lógica para verificar se já existe no BD
        UrlEntity newEntity = new UrlEntity(userId, originURL);
        urlRepository.persist(newEntity);
        return newEntity;
    }
}
