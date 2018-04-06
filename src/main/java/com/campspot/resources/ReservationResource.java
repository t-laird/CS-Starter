package com.campspot.resources;

import com.campspot.Service.ReservationService;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;

@Path("/reservations")
@Produces(MediaType.APPLICATION_JSON)
public class ReservationResource {

    private final ReservationService reservationService;

    public ReservationResource(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GET
    @Timed
    public Response getReservations() {
        return Response.ok(reservationService.getReservations()).build();
    }

    @GET
    @Timed
    @Path("{id}")
    public Response getReservation(@PathParam("id") final int id) {
        return Response.ok(reservationService.getReservation(id)).build();
    }
}