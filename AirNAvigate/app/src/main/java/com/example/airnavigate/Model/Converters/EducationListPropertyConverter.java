package com.example.airnavigate.Model.Converters;


import com.example.airnavigate.Model.EducationArrayList;

/**
 * Converter for StatusArrayList property (GreenDao)
 */
public class EducationListPropertyConverter extends JsonPropertyConverter<EducationArrayList> {

    @Override
    protected Class<EducationArrayList> propertyClass() {
        return EducationArrayList.class;
    }
}
