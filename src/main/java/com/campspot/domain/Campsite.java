package com.campspot.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Campsite {

    @JsonProperty
    private Integer id;
    @JsonProperty
    private String name;

    public Campsite() {
        super();
    }

    public Campsite(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String toString() {
        return "Campsite{" +
                "id=" + id +
                ", name='" + name + "'}";
    }
}
