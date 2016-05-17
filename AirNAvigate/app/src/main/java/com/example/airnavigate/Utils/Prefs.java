package com.example.airnavigate.Utils;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * A preferences facade to modify/read som very minor app's preferences
 */
@Singleton
public class Prefs {

    private static final String KEY_USER_LEARNED_DRAWER = "KEY_USER_LEARNED_DRAWER";
    private static final String KEY_CURRENT_USER_ID = "KEY_CURRENT_USER_ID";
    private static final String KEY_ANALYTICS_ENABLED = "KEY_ANALYTICS_ENABLED";
    private static final String KEY_DEVICE_TOKEN = "KEY_DEVICE_TOKEN";
    private static final String KEY_NOTIFICATIONS_KEYS = "KEY_NOTIFICATIONS_KEYS";
    private static final String KEY_NOTIFICATION_KEY_PREFIX = "KEY_NOTIFICATION_KEY_PREFIX";
    private static final String KEY_IS_ALL_STAR_PROFILE = "KEY_IS_ALL_STAR_PROFILE";

    private static final String KEY_FORMAT_METADATA_LAST_MODIFIED_TIMESTAMP = "last_modified_online_%s";


    private final SharedPreferences prefs;

    @Inject
    public Prefs(SharedPreferences prefs) {
        this.prefs = prefs;
    }

    /**
     * Does User know about navigation drawer?
     */
    public boolean hasUserLearnedDrawer() {
        return prefs.getBoolean(KEY_USER_LEARNED_DRAWER, false);
    }

    /**
     * User knows about navigation drawer, never show it on launch again
     */
    public void setUserLearnedDrawer(boolean hasLearned) {
        prefs.edit().putBoolean(KEY_USER_LEARNED_DRAWER, hasLearned).apply();
    }

    public long getCurrentProfileId() {
        return prefs.getLong(KEY_CURRENT_USER_ID, -1);
    }

    public void setCurrentProfileId(long id) {
        prefs.edit().putLong(KEY_CURRENT_USER_ID, id).apply();
    }

    public boolean isAnalyticsEnabled() {
        return prefs.getBoolean(KEY_ANALYTICS_ENABLED, true);
    }

    public void setAnalyticsEnabled(boolean enabled) {
        prefs.edit().putBoolean(KEY_ANALYTICS_ENABLED, enabled).apply();
    }

    /**
     * Set if current user's account is a  Redaction account
     */
    public void setIsAllStarProfile(boolean isAllStarProfile) {
        prefs.edit().putBoolean(KEY_IS_ALL_STAR_PROFILE, isAllStarProfile).apply();
    }

    /**
     * Is this user's account a  Redaction account?
     */
    public boolean isAllStarProfile() {
        return prefs.getBoolean(KEY_IS_ALL_STAR_PROFILE, false);
    }


    public String getDeviceToken() {
        return prefs.getString(KEY_DEVICE_TOKEN, "");
    }

    public void setDeviceToken(String deviceToken) {
        prefs.edit().putString(KEY_DEVICE_TOKEN, deviceToken).apply();
    }

    //-----------METADATA-------------//


    /**
     * Get last time given metadata has changed
     */
    public String getLastTimestampForMeta(MetadataValue metadataValue) {
        return prefs.getString(
                String.format(KEY_FORMAT_METADATA_LAST_MODIFIED_TIMESTAMP, metadataValue.clientMetadataName), ""
        );
    }

    /**
     * Update last time given metadata has changed
     */
    public void setLastTimestampForMeta(MetadataValue metadataValue, String timestamp) {
        prefs.edit().putString(
                String.format(KEY_FORMAT_METADATA_LAST_MODIFIED_TIMESTAMP, metadataValue.clientMetadataName),
                timestamp
        ).apply();
    }

    /**
     * Available metadata types and their string representation
     */
    public enum MetadataValue {
        Position("Position", "positions"),
        TeamCommittee("TeamCommittee", "teamcommittees"),
        Nation("Nation", "nations"),
        StateAssociation("StateAssociation", "stateassociations"),
        Club("Club", "clubs"),
        NationalTeam("NationalTeam", "nationalteams"),
        StateSelection("StateSelection", "stateselections"),
        League("League", "leagues"),
        Team("Team", "teams");

        private final String serverMetadataName;
        private final String clientMetadataName;

        MetadataValue(String serverMetadataName, String clientMetadataName) {
            this.serverMetadataName = serverMetadataName;
            this.clientMetadataName = clientMetadataName;
        }

    }

}
