package com.demo.aiven.entity;

import java.util.List;

public class Cloud {
    private List<Clouds> clouds;
    public void setClouds(List<Clouds> clouds) {
        this.clouds = clouds;
    }
    public List<Clouds> getClouds() {
        return clouds;
    }

}