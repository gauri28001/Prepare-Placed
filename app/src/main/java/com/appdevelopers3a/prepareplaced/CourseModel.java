package com.appdevelopers3a.prepareplaced;

public class CourseModel {

    private String course_name;
    private int course_rating;
    private int course_image;
    private String id ;

    //Constructor

    public CourseModel(String course_name, int course_rating, int course_image, String id) {
        this.course_name = course_name;
        this.course_rating = course_rating;
        this.course_image = course_image;
        this.id = id ;
    }

    //getters and setters
    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCourse_rating() {
        return course_rating;
    }

    public void setCourse_rating(int course_rating) {
        this.course_rating = course_rating;
    }

    public int getCourse_image() {
        return course_image;
    }

    public void setCourse_image(int course_image) {
        this.course_image = course_image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
