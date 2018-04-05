package com.campspot.core;


import javax.persistence.*;

@Entity
@Table(name = "campsites")
@NamedQueries(
        {
                @NamedQuery(
                        name = "com.campspot.core.Campsite.findAll",
                        query = "SELECT p FROM campsites p"
                )
        })
public class Campsite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    public Campsite() {

    }

    public Campsite(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}