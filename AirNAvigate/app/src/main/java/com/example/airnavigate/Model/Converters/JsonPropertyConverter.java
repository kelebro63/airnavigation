package com.example.airnavigate.Model.Converters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.greenrobot.dao.converter.PropertyConverter;

/**
 * Abstract Converter for some property (GreenDao)
 */
abstract class JsonPropertyConverter<T> implements PropertyConverter<T, String> {
    protected Gson gson;

    public JsonPropertyConverter() {
        gson = new GsonBuilder().create(); //.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
    }

    @Override
    public synchronized T convertToEntityProperty(String databaseValue) {
        return gson.fromJson(databaseValue, propertyClass());
    }

    protected abstract Class<T> propertyClass();

    @Override
    public synchronized String convertToDatabaseValue(T entityProperty) {
        return gson.toJson(entityProperty);
    }
}
