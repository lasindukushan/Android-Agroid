package com.example.splash;

public class PlantingShedule {

    private String plantID;
    private String plantName;
    private String description;
    private String url;

    public PlantingShedule() {
    }

    public PlantingShedule(String plantID, String plantName, String description,String url) {
        this.plantID = plantID;
        this.plantName = plantName;
        this.description = description;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPlantID() {
        return plantID;
    }

    public void setPlantID(String plantID) {
        this.plantID = plantID;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
