package com.example.airnavigate.Views.Main;

import android.support.v4.app.Fragment;

/**
 * An interface used to walk into detail-level views
 */
public interface DetailsNavigator {
    void navigateToDetailsLevel(Fragment fragment, String tag);

    void navigateToDetailsLevelAndCloseSearch(Fragment fragment, String tag);
}
