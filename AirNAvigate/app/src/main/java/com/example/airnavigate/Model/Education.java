package com.example.airnavigate.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bistrov Alexey on 27.01.2016.
 */
public class Education {

    private String institution;
    private String year;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
