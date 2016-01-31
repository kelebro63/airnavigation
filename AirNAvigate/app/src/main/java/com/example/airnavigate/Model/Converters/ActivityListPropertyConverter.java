package com.example.airnavigate.Model.Converters;


import com.example.airnavigate.Model.ActivityArrayList;

/**
 * Converter for StatusArrayList property (GreenDao)
 */
public class ActivityListPropertyConverter extends JsonPropertyConverter<ActivityArrayList> {

    @Override
    protected Class<ActivityArrayList> propertyClass() {
        return ActivityArrayList.class;
    }
}
