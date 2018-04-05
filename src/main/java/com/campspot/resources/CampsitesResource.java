package com.campspot.resources;


import com.campspot.api.Campsite;
import com.codahale.metrics.annotation.Timed;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;


@Path("/campsites")
@Produces(MediaType.APPLICATION_JSON)

public class CampsitesResource {
    private final String name;
    private final long id;

    public CampsitesResource(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Valid
    @PermitAll
    @SuppressWarnings("ResourceMethodMultitenancy")
    @GET
    @Timed
    public Campsite fetchCampsite(@QueryParam("id") Optional<String> id) {
        if(id.isPresent()) {
            return null;
        } else {
            return null;
        }
    }
}
