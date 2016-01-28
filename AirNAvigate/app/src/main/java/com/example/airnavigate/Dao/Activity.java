package com.example.airnavigate.Dao;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table "ACTIVITY".
 */
public class Activity {

    private String name;
    private String subdivisionNameGenitive;
    private Integer subdivisionId;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Activity() {
    }

    public Activity(String name, String subdivisionNameGenitive, Integer subdivisionId) {
        this.name = name;
        this.subdivisionNameGenitive = subdivisionNameGenitive;
        this.subdivisionId = subdivisionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubdivisionNameGenitive() {
        return subdivisionNameGenitive;
    }

    public void setSubdivisionNameGenitive(String subdivisionNameGenitive) {
        this.subdivisionNameGenitive = subdivisionNameGenitive;
    }

    public Integer getSubdivisionId() {
        return subdivisionId;
    }

    public void setSubdivisionId(Integer subdivisionId) {
        this.subdivisionId = subdivisionId;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
