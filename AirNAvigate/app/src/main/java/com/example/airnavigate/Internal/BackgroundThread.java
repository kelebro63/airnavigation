package com.example.airnavigate.Internal;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Dedicated for background IO operation, like performing disk/network read/write
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface BackgroundThread {
}
