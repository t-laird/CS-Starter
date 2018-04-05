package com.campspot;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class CampsitesConfiguration extends Configuration {
    @NotEmpty
    private String name;
    @NotEmpty
    private long id;


    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public long getId() {
        return id;
    }
}
