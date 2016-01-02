package com.example.airnavigate.Internal;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;


/**
 * regular activity's support fragment manager
 * */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface NormalFragmentManager {
}
