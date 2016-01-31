package com.example.airnavigate.Model.Converters;

import com.example.airnavigate.Model.Activity;

/**
 * Converter for  Status property (GreenDao)
 */
public class ActivityPropertyConverter extends JsonPropertyConverter<Activity> {
    @Override
    protected Class<Activity> propertyClass() {
        return Activity.class;
    }
}
