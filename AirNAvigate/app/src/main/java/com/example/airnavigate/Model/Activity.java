package com.example.airnavigate.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Kelebro63 on 31.01.2016.
 */
public class Activity {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("subdivisionId")
    @Expose
    private Integer subdivisionId;
    @SerializedName("subdivisionNameGenitive")
    @Expose
    private String subdivisionNameGenitive;

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The subdivisionId
     */
    public Integer getSubdivisionId() {
        return subdivisionId;
    }

    /**
     *
     * @param subdivisionId
     * The subdivisionId
     */
    public void setSubdivisionId(Integer subdivisionId) {
        this.subdivisionId = subdivisionId;
    }

    /**
     *
     * @return
     * The subdivisionNameGenitive
     */
    public String getSubdivisionNameGenitive() {
        return subdivisionNameGenitive;
    }

    /**
     *
     * @param subdivisionNameGenitive
     * The subdivisionNameGenitive
     */
    public void setSubdivisionNameGenitive(String subdivisionNameGenitive) {
        this.subdivisionNameGenitive = subdivisionNameGenitive;
    }

}