package com.campspot.mapper;
import com.campspot.domain.Reservation;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ReservationMapper implements ResultSetMapper<Reservation> {
    private static final String ID = "id";
    private static final String CAMPSITEID = "campsiteId";
    private static final String STARTDATE = "startDate";
    private static final String ENDDATE = "endDate";

    public Reservation map(int i, ResultSet resultSet, StatementContext statementContext)
            throws SQLException {
        Reservation reservation = new Reservation(
                resultSet.getString(STARTDATE),
                resultSet.getString(ENDDATE),
                resultSet.getInt(CAMPSITEID));
        reservation.setId(resultSet.getInt(ID));
        return reservation;
    }
}
