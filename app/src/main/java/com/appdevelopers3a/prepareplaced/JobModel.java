package com.appdevelopers3a.prepareplaced;

public class JobModel {

    int imageId;
    String name;
    String description;
    String url ;

    public JobModel(int imageId, String name, String description , String url ) {
        this.imageId = imageId;
        this.name = name;
        this.description = description;
        this.url = url ;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
