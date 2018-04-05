package com.campspot.resources;


import com.campspot.Service.CampsiteService;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/campsites")
@Produces(MediaType.APPLICATION_JSON)
public class CampsitesResource {

    private final CampsiteService campsiteService;

    public CampsitesResource(CampsiteService campsiteService) {
        this.campsiteService = campsiteService;
    }

    @GET
    @Timed
    public Response getCampsites() {
        return Response.ok(campsiteService.getCampsites()).build();
    }

    @GET
    @Timed
    @Path("{id}")
    public Response getCampsite(@PathParam("id") final int id) {
        return Response.ok(campsiteService.getCampsite(id)).build();
    }








//    private final CampsiteDAO campsitedao;
//
//    public CampsitesResource(CampsiteDAO campsitedao) {
//        this.campsitedao = campsitedao;
//    }

//    @GET
//    @UnitOfWork
//    public List<Campsite> listCampsites() {
//        return campsitedao.findAll();
//    }
}
