package com.example.airnavigate.Views.Drawer;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Navigation elements constants
 */
public class NavigationConstants {
    //regular items
    public static final int DRAWER_ITEM_NO_ID = -1;
    public static final int DRAWER_PROFILE_HEADER = 0;
    public static final int DRAWER_NEWS = 1;
    public static final int DRAWER_HASHTAGS = 2;
    public static final int DRAWER_PROFILES = 4;
    public static final int DRAWER_MY_PROFILE = 16;
    public static final int DRAWER_RATE_GPLAY = 64;
    public static final int DRAWER_SEND_EMAIL = 128;
    public static final int DRAWER_FOLLOW_US = 256;
    public static final int DRAWER_TELL_ABOUT_US = 512;
    //profile options
    public static final int DRAWER_PROFILE_MEIN_ACCOUNT = 1024;
    public static final int DRAWER_PROFILE_LOGOUT = 2048;
    public static final int DRAWER_ABOUT_US = 4096;
    public static final int DRAWER_PRIVACY = 8192;
    public static final int DRAWER_TERMS = 16384;
    public static final int DRAWER_CONTACTS = 32768;

    /**
     * This id is used to identify a menu item user clicked to
     */
    @IntDef({DRAWER_ITEM_NO_ID,
            DRAWER_PROFILE_HEADER,
            DRAWER_NEWS,
            DRAWER_HASHTAGS,
            DRAWER_PROFILES,
            DRAWER_MY_PROFILE,
            DRAWER_RATE_GPLAY,
            DRAWER_SEND_EMAIL,
            DRAWER_FOLLOW_US,
            DRAWER_TELL_ABOUT_US,
            DRAWER_PROFILE_MEIN_ACCOUNT,
            DRAWER_PROFILE_LOGOUT,
            DRAWER_ABOUT_US,
            DRAWER_PRIVACY,
            DRAWER_TERMS,
            DRAWER_CONTACTS

    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface MenuItemId {
    }
}
