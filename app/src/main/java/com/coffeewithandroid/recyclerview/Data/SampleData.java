package com.coffeewithandroid.recyclerview.Data;

/**
 * Created by Antarjot on 7/12/2016.
 */
public class SampleData {

    //Variables used to display data in recycler view
    private String title, date, link;

    //Default Constructor
    public SampleData() {

    }

    //Parameterized Constructor
    public SampleData(String title, String date, String link) {
        this.title = title;
        this.date = date;
        this.link = link;
    }

    /*
    * Getters for the variables
    */
    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getLink() {
        return link;
    }


    /*
    * Setters for the variables
    */
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
