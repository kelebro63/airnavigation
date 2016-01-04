package com.example.airnavigate.Data;

import com.example.airnavigate.Model.Topic;

import java.util.List;

import rx.Observable;

/**
 * This is an API to get access to any data used in the application.
 * It abstracts away the details (getting data from server, or getting it from db cache, or anything)
 * <br>
 * It has the same API as {@link //IGokixxAPI} for convenience (except for data that is not stored)
 */
public interface IDataSource {

    Observable<List<Topic>> requestGetNews();

//    Observable<List<News>> requestLatestNews(int page, String tag);
//
//    Observable<List<News>> requestLatestNews(int page);
//
//
//    Observable<List<Tag>> requestFeaturedTags();
//
//    Observable<List<HashTag>> requestAlphabeticalTags();
//
//
//    Observable<Profile> login(String username, String password);
//
//    Observable<List<HashTag>> requestTagsList();
//
//    /**
//     * Loads recent twitter posts list by "gokixx" user
//     */
//    Observable<List<News>> loadTwitterPosts();
//
//    Observable<List<Team>> loadTeamsInLeague(League league);
//
//    Observable<List<Club>> loadAllClubs();
//
//    Observable<List<Club>> filterClubs(String query);
//
//    Observable<Club> findMyClub();
//
//    Observable<List<Profile>> search(String query);
//
//    Observable<List<Profile>> searchByTeam(long teamId);
//
//    Observable<List<Profile>> searchProfilesFollowedByMe();
//
//    Observable<Profile> getProfileBy(long id);
//
//    Observable<Profile> getMyProfile();
//
//    /**
//     * check if there's a one-way follow relationship followeeInQuestionID -> followeeInQuestionID
//     *
//     * @param followerInQuestionID a possible follower id
//     * @param followeeInQuestionID a possible user who is followed, id
//     */
//    Observable<Boolean> isFollowing(long followerInQuestionID, long followeeInQuestionID);
//
//    /**
//     * check if current user follows an user with a given id
//     */
//    Observable<Boolean> amFollowing(long followeeId);
//
//    Observable<InternalText> requestInternalText(InternalTextType type);
//
//    Observable<List<Nation>> getNationsFor(Profile profile);
//
//    /**
//     * @param followedId      a user to follow/unfollow
//     * @param newFollowStatus "1" to follow, "0" to unfollow
//     */
//    Observable<Object> updateProfileFollowStatus(String followedId, String newFollowStatus);
//
//    /**
//     * Update profile in local cache and on server
//     */
//    Observable<Object> updateProfile(Profile profile);
//
//    /**
//     * inactivate profile image
//     */
//    Observable<Object> updateInactivateImage(int imageId);
//
//    /**
//     * inactivate profile "more" entry?
//     */
//    Observable<Object> updateProfileMoreInactivate(int moreId);
//
//    Observable<Object> updateImage(String value, TypedFile file);
//
//    Observable<Object> updateProfileRoleModel(String text, String about);
//
//    Observable<Object> updateProfileObjective(String text, int order);
//
//    Observable<Object> updateProfileStatus(String status);
//
//    Observable<Object> addCareerRecordToMore(String text);
//
//    Observable<Object> updatePassword(String oldPassword, String newPassword);
//
//    Observable<Object> sendContactMessage(String message);
//
//    Observable<Team> getTeamFor(Profile profile);
//
//    Observable<Team> findTeamBy(long id);
//
//    Observable<Object> forgotPassword(String email);
//
//    /**
//     * Async logout action. Performs cleanup of all the profile info and credentials.
//     * Navigation to LoginActivity is expected to be done after the action completes
//     */
//    Observable<Void> logout();
//
//
//    void updateMeta();
//
//    /**
//     * Register GCM token to allow push notifications
//     */
//    void registerGcmToken(String token);


}