package com.example.airnavigate.Internal;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Dedicated for main  UI thread operations
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface MainThread {
}
