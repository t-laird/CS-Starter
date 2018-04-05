package com.campspot.db;

import com.campspot.core.Campsite;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;


import java.util.List;
import java.util.Optional;

public class CampsiteDAO extends AbstractDAO<Campsite> {
    public CampsiteDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Campsite> findById(Long id) {
        return Optional.ofNullable(get(id));
    }
}