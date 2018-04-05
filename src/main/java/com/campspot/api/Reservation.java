package com.campspot.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reservation {
    private long id;
    private long campsiteId;
    private String startDate;
    private String endDate;

    public Reservation() {

    }

    public Reservation(long id, long campsiteId, String startDate, String endDate) {
        this.id = id;
        this.campsiteId = campsiteId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public long getCampsiteId() {
        return campsiteId;
    }

    @JsonProperty
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty
    public String getEndDate() {
        return endDate;
    }
}
