package com.campspot.core;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "campsites")
@NamedQueries(
    {
        @NamedQuery(
            name = "com.campspot.core.Campsite.findAll",
            query = "SELECT p FROM Campsite p"
        )
    })
)
public class Campsite {
    @Id
    @
}
