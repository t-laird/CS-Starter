package com.campspot.Service;

import com.campspot.dao.ReservationDAO;
import com.campspot.domain.Reservation;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

public abstract class ReservationService {
    private static final Logger logger = LoggerFactory.getLogger(ReservationService.class);
    private static final String DATABASE_ACCESS_ERROR =
            "Could not reach the MySQL database. The database may be down or there may be network connectivity issues. Details: ";
    private static final String DATABASE_CONNECTION_ERROR =
            "Could not create a connection to the MySQL database. The database configurations are likely incorrect. Details: ";
    private static final String UNEXPECTED_DATABASE_ERROR =
            "Unexpected error occurred while attempting to reach the database. Details: ";
    private static final String SUCCESS = "Success";
    private static final String RESERVATION_NOT_FOUND = "Reservation id %s not found.";

    @CreateSqlObject
    abstract ReservationDAO reservationDao();

    public List<Reservation> getReservations() {
        return reservationDao().getReservations();
    }

    public Reservation getReservation(int id) {
        Reservation reservation = reservationDao().getReservation(id);
        if (Objects.isNull(reservation)) {
            throw new WebApplicationException(String.format(RESERVATION_NOT_FOUND, id), Response.Status.NOT_FOUND);
        }
        return reservation;
    }

}
