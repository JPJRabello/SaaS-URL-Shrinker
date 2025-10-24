package org.jpjr.quarkus.starting.resource;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.jpjr.quarkus.starting.service.UrlService;

import java.net.URI;
import java.util.Map;

@Path("/{shortenedCode}")
@ApplicationScoped
public class GetUrlResource {

    @Inject
    UrlService urlService;

    private static final Map<String, String> urlMap = Map.of(
        "/redirectTo01", "https://google.com/"
    );

    @GET
    public Response shortenedUrl(@PathParam("shortenedCode") String shortenedCode) {

        String originURL = urlService.getOrinalUrl(shortenedCode);

        URI location = URI.create(originURL);

        return Response.status(Response.Status.FOUND).location(location).build();
    }
}
