package com.campspot.mapper;
import com.campspot.domain.Campsite;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CampsiteMapper implements ResultSetMapper<Campsite> {
    private static final String ID = "id";
    private static final String NAME = "name";

    public Campsite map(int i, ResultSet resultSet, StatementContext statementContext)
            throws SQLException {
        Campsite campsite = new Campsite(resultSet.getString(NAME));
        campsite.setId(resultSet.getInt(ID));
        return campsite;
    }
}
