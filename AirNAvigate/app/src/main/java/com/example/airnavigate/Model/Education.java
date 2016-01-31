package com.example.airnavigate.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Kelebro63 on 31.01.2016.
 */
public class Education {

    @SerializedName("institution")
    @Expose
    private String institution;
    @SerializedName("year")
    @Expose
    private String year;

    /**
     *
     * @return
     * The institution
     */
    public String getInstitution() {
        return institution;
    }

    /**
     *
     * @param institution
     * The institution
     */
    public void setInstitution(String institution) {
        this.institution = institution;
    }

    /**
     *
     * @return
     * The year
     */
    public String getYear() {
        return year;
    }

    /**
     *
     * @param year
     * The year
     */
    public void setYear(String year) {
        this.year = year;
    }

}

