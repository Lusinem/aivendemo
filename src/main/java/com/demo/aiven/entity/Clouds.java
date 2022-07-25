package com.demo.aiven.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Clouds {   @JsonProperty("cloud_description")
private String cloudDescription;
    @JsonProperty("cloud_name")
    private String cloudName;
    @JsonProperty("geo_latitude")
    private double geoLatitude;
    @JsonProperty("geo_longitude")
    private double geoLongitude;
    @JsonProperty("geo_region")
    private String geoRegion;
    public void setCloudDescription(String cloudDescription) {
        this.cloudDescription = cloudDescription;
    }
    public String getCloudDescription() {
        return cloudDescription;
    }

    public void setCloudName(String cloudName) {
        this.cloudName = cloudName;
    }
    public String getCloudName() {
        return cloudName;
    }

    public void setGeoLatitude(double geoLatitude) {
        this.geoLatitude = geoLatitude;
    }
    public double getGeoLatitude() {
        return geoLatitude;
    }

    public void setGeoLongitude(double geoLongitude) {
        this.geoLongitude = geoLongitude;
    }
    public double getGeoLongitude() {
        return geoLongitude;
    }

    public void setGeoRegion(String geoRegion) {
        this.geoRegion = geoRegion;
    }
    public String getGeoRegion() {
        return geoRegion;
    }

}