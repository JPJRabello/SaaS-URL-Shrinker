package org.jpjr.quarkus.starting;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.Map;

@Path("/redirect/{id}")

public class ShortenedResource {

    private static final Map<String, String> urlMap = Map.of(
        "/redirectTo01", "https://google.com/"
    );
    @GET
    public Response shortenedUrl(@PathParam("id") String shortenedId) {
        String uri = "/redirectTo"+shortenedId;
        String google = urlMap.get(uri);
        URI googleURI = URI.create(google);

        return Response.status(Response.Status.FOUND)
            .location(googleURI)
            .build();
    }
}
