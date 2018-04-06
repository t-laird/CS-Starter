package com.campspot.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reservation {

    @JsonProperty
    private Integer id;
    @JsonProperty
    private String startDate;
    @JsonProperty
    private String endDate;
    @JsonProperty
    private Integer campsiteId;

    public Reservation() {
        super();
    }

    public Reservation(String startDate, String endDate, Integer campsiteId) {
        super();
        this.startDate = startDate;
        this.endDate = endDate;
        this.campsiteId = campsiteId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getCampsiteId() {
        return campsiteId;
    }

    public void setCampsiteId(Integer campsiteId) {
        this.campsiteId = campsiteId;
    }

    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", startDate=`" + startDate +
                "' endDate=`" + endDate +
                "' campsiteId='" + campsiteId + "'}";
    }
}
