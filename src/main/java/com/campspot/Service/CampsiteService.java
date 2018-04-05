package com.campspot.Service;


import com.campspot.dao.CampsiteDAO;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.campspot.domain.Campsite;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

public abstract class CampsiteService {

    private static final Logger logger = LoggerFactory.getLogger(CampsiteService.class);
    private static final String DATABASE_ACCESS_ERROR =
            "Could not reach the MySQL database. The database may be down or there may be network connectivity issues. Details: ";
    private static final String DATABASE_CONNECTION_ERROR =
            "Could not create a connection to the MySQL database. The database configurations are likely incorrect. Details: ";
    private static final String UNEXPECTED_DATABASE_ERROR =
            "Unexpected error occurred while attempting to reach the database. Details: ";
    private static final String SUCCESS = "Success";
    private static final String CAMPSITE_NOT_FOUND = "Campsite id %s not found.";


    @CreateSqlObject
    abstract CampsiteDAO campsiteDao();

    public List<Campsite> getCampsites() {
        return campsiteDao().getCampsites();
    }

    public Campsite getCampsite(int id) {
        Campsite campsite = campsiteDao().getCampsite(id);
        if (Objects.isNull(campsite)) {
            throw new WebApplicationException(String.format(CAMPSITE_NOT_FOUND, id), Response.Status.NOT_FOUND);
        }
        return campsite;
    }
}
