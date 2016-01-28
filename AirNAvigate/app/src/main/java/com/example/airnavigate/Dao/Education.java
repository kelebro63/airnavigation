package com.example.airnavigate.Dao;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table "EDUCATION".
 */
public class Education {

    private String institution;
    private String year;
    private long deputyId;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Education() {
    }

    public Education(String institution, String year, long deputyId) {
        this.institution = institution;
        this.year = year;
        this.deputyId = deputyId;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public long getDeputyId() {
        return deputyId;
    }

    public void setDeputyId(long deputyId) {
        this.deputyId = deputyId;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
