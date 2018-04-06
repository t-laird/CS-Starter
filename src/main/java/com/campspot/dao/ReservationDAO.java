package com.campspot.dao;


import com.campspot.domain.Reservation;
import com.campspot.mapper.ReservationMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(ReservationMapper.class)
public interface ReservationDAO {

    @SqlQuery("select * from reservations;")
    public List<Reservation> getReservations();

    @SqlQuery("select * from reservations where id = :id")
    public Reservation getReservation(@Bind("id") final int id);
}