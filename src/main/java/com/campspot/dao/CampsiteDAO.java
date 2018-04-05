package com.campspot.dao;

import com.campspot.domain.Campsite;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import com.campspot.mapper.CampsiteMapper;

import java.util.List;

@RegisterMapper(CampsiteMapper.class)
public interface CampsiteDAO {

    @SqlQuery("select * from campsites;")
    public List<Campsite> getCampsites();

    @SqlQuery("select * from campsites where id = :id")
    public Campsite getCampsite(@Bind("id") final int id);
}