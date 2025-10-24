package org.jpjr.quarkus.starting.resource;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.jpjr.quarkus.starting.dto.UrlRequestDTO;
import org.jpjr.quarkus.starting.entity.UrlEntity;
import org.jpjr.quarkus.starting.service.UrlService;

import java.net.URI;


@Path("/api/v1/shorten")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class PostUrlResource {

    @Inject UrlService urlService;

    @POST
    @Transactional
    public Response shorten(UrlRequestDTO requestDTO, @Context UriInfo uriInfo) {
        Log.info("[PostOriginalUrlController] Iniciando busca de Url");

        UrlEntity newEntity = urlService.createShortenedUrl(requestDTO.getUserId(), requestDTO.getOriginURL());

        URI location = uriInfo.getAbsolutePathBuilder()
            .path(newEntity.getShortenedCode())
            .build();

        return Response.created(location).entity(newEntity).build();
    }
}
