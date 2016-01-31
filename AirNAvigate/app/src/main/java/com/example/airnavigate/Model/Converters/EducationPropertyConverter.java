package com.example.airnavigate.Model.Converters;

import com.example.airnavigate.Model.Education;

/**
 * Converter for  Status property (GreenDao)
 */
public class EducationPropertyConverter extends JsonPropertyConverter<Education> {
    @Override
    protected Class<Education> propertyClass() {
        return Education.class;
    }
}
