package com.example.airnavigate.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bistrov Alexey on 27.01.2016.
 */
public class Activity {

    private String name;
    private Integer subdivisionId;
    private String subdivisionNameGenitive;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
