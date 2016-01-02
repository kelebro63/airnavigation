package com.example.airnavigate.Data;


import javax.inject.Inject;

@SuppressWarnings("TryWithIdenticalCatches")
/**
 * Implementation of IDataSource, which uses server api as a primary source of information and local database as a cache
 * */
public class DataSourceImpl implements IDataSource {

    /**
     * An account for which we should ignore analytics
     */
//    private static final String EDITORIAL_ACCOUNT_TEAM_NAME = "FC GOKIXX All Stars";
//
//    /**
//     * Twitter user for which  we fetch the timeline
//     */
//    private static final String GOKIXX_TWITTER_ACCOUNT = "Gokixx";
//
//    private final IGokixxAPI serverApi;
//    private final DBManager manager;
//    private final Prefs prefs;
//
//    /**
//     * Background scheduler which will be used to enqueue asynchronous tasks
//     */
//    private final Scheduler backgroundScheduler;
//
//
//    @Inject
//    public DataSourceImpl(IGokixxAPI serverApi,
//                          @BackgroundThread Scheduler backgroundScheduler,
//                          DBManager manager,
//                          Prefs prefs) {
//
//        this.serverApi = serverApi;
//        this.manager = manager;
//        this.prefs = prefs;
//        this.backgroundScheduler = backgroundScheduler;
//    }

    @Inject
    public DataSourceImpl() {


    }
//
//    @Override
//    public Observable<List<News>> requestLatestNews(int page, @NonNull String tag) {
//        return loadTwitterPosts()
//                .concatMap(ignore -> serverApi.requestLatestNews(page, tag)
//                        .doOnNext(newses -> manager.updateNewsAtPage(page, tag, newses))
//                        .onErrorResumeNext(
//                                Observable.just(manager.loadNews(page, tag))
//                        ).flatMap(newses -> Observable.just(manager.loadNews(page, tag))));
//
//    }
//
//    @Override
//    public Observable<List<News>> requestLatestNews(int page) {
//
//
//        return loadTwitterPosts()
//                .concatMap(ignore -> serverApi.requestLatestNews(page)
//                        .doOnNext(newses -> manager.updateNewsAtPage(page, newses))
//                        .onErrorResumeNext(
//                                Observable.just(manager.loadNews(page)
//                                )
//                        ).flatMap(newses -> Observable.just(manager.loadNews(page))));
//
//
//    }
//
//
//    @Override
//    public Observable<List<Tag>> requestFeaturedTags() {
//        return serverApi.requestFeaturedTags()
//                .doOnNext(manager::saveFeaturedTags)
//                .onErrorResumeNext(
//                        Observable.just(manager.getFeaturedTags())
//                );
//    }
//
//    @Override
//    public Observable<List<HashTag>> requestAlphabeticalTags() {
//        return serverApi.requestHashTags().doOnNext(manager::saveTagsList).map(hashTags -> {
//            Collections.sort(hashTags, Comparators.HASHTAG_ALPHABETICAL_COMPARATOR);
//            return hashTags;
//        }).onErrorResumeNext(Observable.just(manager.getTagsList()));
//    }
//
//    @Override
//    public Observable<Profile> login(String username, String password) {
//        Observable<Void> cleanup = performCleanup();
//        Observable<Token> login = serverApi.login(username, password)
//                .doOnNext(token -> {
//                    Credentials credentials = manager.getCredentials();
//                    credentials.setLogin(username);
//                    credentials.setPassword(password);
//                    credentials.setToken(token.getToken());
//                    manager.updateCredentials(credentials);
//
//                    String deviceToken = prefs.getDeviceToken();
//                    if (deviceToken != null && !deviceToken.isEmpty()) {
//                        registerGcmToken(deviceToken);
//                    }
//                });
//
//        Observable<Profile> myProfile = getMyProfile();
//        Observable<List<News>> prefetchTwitterPosts = loadAllTwitterPostsInternal();
//        Observable<OAuth2Token> twitterToken = getTwitterTokenInternal();
//
//
//        return cleanup                                 //cleanup first
//                .concatMap((ignore) -> login)   //then try to login
//                .concatMap(ignore -> twitterToken)//then get twitter token
//                .concatMap(ignore -> prefetchTwitterPosts) //then get all twitter posts
//                .concatMap(ignore -> updateMetadata()) //get all the content from server - Nations, Teams, etc
//                .concatMap(ignore -> myProfile)      //finally fetch profile
//                .doOnError(throwable -> {
//                    Cr.e("DatasourceImpl::login::doOnError", throwable);
//                    cleanup.toBlocking().next();//perform cleanup again
//                    Observable.error(throwable).toBlocking().next();//rethrow
//                });
//    }
//
//    /**
//     * Fetches a twitter token from server or from database
//     */
//    private Observable<OAuth2Token> getTwitterTokenInternal() {
//        return Observable.defer(() -> {
//            OAuth2Token oAuth2Token = safeGetTwitterToken();
//            if (oAuth2Token == null) {
//                return Observable.error(new Exception("OAuthToken couldn't be received from server and from credentials"));
//            } else {
//                return Observable.just(oAuth2Token);
//            }
//        }).doOnNext(oAuth2Token -> {
//            Credentials credentials = manager.getCredentials();
//            credentials.setTwitterToken(oAuth2Token.getAccessToken());
//            manager.updateCredentials(credentials);
//        });
//    }
//
//    /**
//     * Attempts to load the latest twitter posts (later than the last tweet saved in DB)
//     */
//    @Override
//    public Observable<List<News>> loadTwitterPosts() {
//        return getActualPaging()
//                .concatMap(o -> Observable.just(safeGetUserTimeline(o)))
//                .map(twitterStatusesToNewsFunc())
//                .doOnNext(manager::saveNews);
//    }
//
//    /**
//     * This method tries to load all twitter posts by gokixx in lists (200 posts in a list), until the last list.size() is 0
//     */
//    private Observable<List<News>> loadAllTwitterPostsInternal() {
//
//        return Observable.defer(() -> Observable.range(0, Integer.MAX_VALUE - 1)
//                .concatMap(integer -> getActualPaging())
//                .concatMap(
//                        o -> Observable.just(safeGetUserTimeline(o))
//                )
//                .map(twitterStatusesToNewsFunc())
//                .takeUntil(newses -> newses.size() == 0)
//                .doOnNext(manager::saveNews)
//                .toList()
//                .map(listOfLists -> {
//                    List<News> result = new ArrayList<>();
//                    for (List<News> l : listOfLists) {
//                        result.addAll(l);
//                    }
//                    return result;
//                }));
//
//    }
//
//    /**
//     * Get a paging to load twitter posts. It attempts to load posts later than the last tweet saved in
//     * the db - new tweets should have greater IDs
//     */
//    private Observable<Paging> getActualPaging() {
//        return Observable.defer(() -> {
//            Paging paging = new Paging();
//            paging.setCount(200);
//            long maxId = manager.findMaxTwitterId();
//            if (maxId != -1) {
//                paging.setSinceId(maxId);
//            }
//            return Observable.just(paging);
//        });
//    }
//
//    /**
//     * Exception-safe method to fetch user timeline using the given Paging. Invoked in BG-thread
//     */
//    private List<Status> safeGetUserTimeline(Paging paging) {
//        List<Status> list = new ArrayList<>();
//        try {
//            list.addAll(twitter.getUserTimeline(GOKIXX_TWITTER_ACCOUNT, paging));
//        } catch (TwitterException e) {
//            Cr.e(this, e);
//        }
//        return list;
//    }
//
//    /**
//     * Exception-safe method to get twitter bearer token from server. Invoked in BG-thread
//     */
//    @Nullable
//    private OAuth2Token safeGetTwitterToken() {
//        OAuth2Token token;
//        try {
//            token = twitter.getOAuth2Token();
//        } catch (TwitterException e) {
//            //network error maybe?
//            token = fallbackToken();
//        } catch (IllegalStateException e) {
//            //illegal library usage?
//            token = fallbackToken();
//        }
//        return token;
//    }
//
//    /**
//     * If failed to get token from twitter, go ahead and try this
//     */
//    private OAuth2Token fallbackToken() {
//        OAuth2Token token;
//        Credentials credentials = manager.getCredentials();
//        String twitterToken = credentials.getTwitterToken();
//        if (TextUtils.isEmpty(twitterToken)) {
//            token = null;
//        } else {
//            token = new OAuth2Token("bearer", twitterToken);
//        }
//        return token;
//    }
//
//    /**
//     * Maps the Status objects received from Twitter into Gokixx-domain-specific News,
//     * so that they could be saved
//     */
//    private Func1<List<Status>, List<News>> twitterStatusesToNewsFunc() {
//        return statuses -> {
//            List<News> result = new ArrayList<>();
//            if (statuses == null) {
//                return result;
//            }
//            for (Status status : statuses) {
//                News news = new News();
//                news.setId(status.getId());
//                news.setDate(status.getCreatedAt());
//                MediaEntity[] mediaEntities = status.getMediaEntities();
//                if (mediaEntities.length > 0) {
//                    news.setImage(mediaEntities[0].getMediaURL());
//                }
//                HashtagEntity[] hashtagEntities = status.getHashtagEntities();
//                StringArrayList hashTags = new StringArrayList();
//                for (HashtagEntity hashtagEntity : hashtagEntities) {
//                    hashTags.add(hashtagEntity.getText());
//                }
//                news.setTags(hashTags);
//                if (status.getRetweetedStatus() != null) {
//                    news.setContentType(ContentType.RETWET.value());
//                    news.setTwitterRetweetAtName("@" + status.getUser().getScreenName());
//                    status = status.getRetweetedStatus();
//                } else {
//                    news.setContentType(ContentType.TWEET.value());
//                }
//                news.setText(status.getText());
//                User user = status.getUser();
//                news.setTwitterScreenName(user.getName());
//                news.setTwitterAtName("@" + user.getScreenName());
//                news.setTwitterLogo(user.getProfileImageURL());
//                result.add(news);
//            }
//            return result;
//        };
//    }
//
//
//    /**
//     * Get all tags from server (or db)
//     */
//    @Override
//    public Observable<List<HashTag>> requestTagsList() {
//        return serverApi.requestHashTags()
//                .doOnNext(manager::saveTagsList)
//                .onErrorResumeNext(
//                        Observable.just(manager.getTagsList())
//                );
//    }
//
//
//    @Override
//    public Observable<List<Team>> loadTeamsInLeague(League league) {
//        return Observable.defer(() -> {
//            List<Team> clubsOfLeague = manager.getTeamsOfLeague(league, Comparators.TEAM_ORDER_COMPARATOR);
//            return Observable.just(clubsOfLeague);
//        });
//    }
//
//    @Override
//    public Observable<List<Club>> loadAllClubs() {
//        return Observable.defer(() -> {
//            List<Club> clubs = manager.getClubs(Comparators.CLUB_ALPHABETICAL_COMPARATOR);
//            return Observable.just(clubs);
//        });
//    }
//
//    @Override
//    public Observable<List<Club>> filterClubs(@NonNull String query) {
//        return Observable.defer(() -> {
//            List<Club> clubs = manager.getClubs(query, Comparators.CLUB_ALPHABETICAL_COMPARATOR);
//            return Observable.just(clubs);
//        });
//    }
//
//    @Override
//    public Observable<Club> findMyClub() {
//        return Observable.defer(() -> Observable.just(manager.getUserClub()));
//    }
//
//    @Override
//    public Observable<List<Profile>> search(@NonNull String query) {
//        return serverApi.searchProfilesByString(query).map((profiles -> {
//            manager.saveProfiles(profiles);
//            return prepareProfilesList(profiles);
//        }));
//
//    }
//
//    @Override
//    public Observable<List<Profile>> searchByTeam(long teamId) {
//        return serverApi.searchProfilesByTeam(String.valueOf(teamId)).map((profiles -> {
//            manager.saveProfiles(profiles);
//            return prepareProfilesList(profiles);
//        }));
//    }
//
//    /**
//     * Append Team and Position relation to list of profiles.<br>
//     * That is just a convenience, because our current data model doesn't allow to build an appropriate ORM
//     */
//    private List<Profile> prepareProfilesList(@NonNull List<Profile> profiles) {
//        for (Profile profile : profiles) {
//            Team team = manager.findTeamWithId(profile.getTeam());
//            Position position = manager.findPositionBy(profile.getPosition1());
//            profile.setTeamObject(team);
//            profile.setPositionObject(position);
//        }
//        Collections.sort(profiles, Comparators.PROFILE_COMPARATOR);
//        return profiles;
//    }
//
//    @Override
//    public Observable<List<Profile>> searchProfilesFollowedByMe() {
//        return serverApi.searchProfilesFollowedByMe().map((profiles -> {
//            manager.saveProfiles(profiles);
//            return prepareProfilesList(profiles);
//        }));
//    }
//
//    @Override
//    public Observable<Profile> getProfileBy(long id) {
//        if (id == prefs.getCurrentProfileId()) {
//            return getMyProfile();
//        } else {
//            return Observable.defer(() -> Observable.just(manager.getProfileBy(id)));
//        }
//    }
//
//    @Override
//    public Observable<Profile> getMyProfile() {
//        // side effect - update Gcm token
//        String deviceToken = prefs.getDeviceToken();
//        if (deviceToken != null && !deviceToken.isEmpty()) {
//            registerGcmToken(deviceToken);
//        }
//
//        return serverApi.requestProfileInfo()
//                .doOnNext((profile) -> {
//                    manager.updateProfile(profile);
//
//                    //mark this profile as self profile
//                    prefs.setCurrentProfileId(profile.getId());
//
//                    Long teamId = profile.getTeam();
//                    if (teamId != null) {
//                        Team team = manager.findTeamWithId(teamId);
//                        //that is a dirty and ugly hack, not a solution. But backend gives no other chance
//                        if (team != null && team.getName() != null && team.getName().equals(EDITORIAL_ACCOUNT_TEAM_NAME)) {
//                            prefs.setIsGokixxAllStarProfile(true);
//                        } else {
//                            prefs.setIsGokixxAllStarProfile(false);
//                        }
//
//                    } else {
//                        prefs.setIsGokixxAllStarProfile(false);
//                    }
//
//                })
//                .onErrorResumeNext(throwable -> {
//                            Cr.e("datasourceimpl::getMyProfile::onErrorResumeNext", throwable);
//                            Profile myProfile = manager.getMyProfile();
//                            if (myProfile != null) {
//                                return Observable.just(myProfile);
//                            } else {
//                                return Observable.error(new Exception("Profile is not cached. Try again"));
//                            }
//                        }
//                );
//    }
//
//
//    private Observable<Void> performCleanup() {
//        manager.clearUserInfo();
//        twitter.setOAuth2Token(null);
//        return Observable.just(null);
//    }
//
//    @Override
//    public Observable<Boolean> isFollowing(long followerId, long followeeId) {
//        return serverApi
//                .searchProfileFollowerOfProfileId(String.valueOf(followeeId))
//                .map(profiles -> {
//                    //we received profiles - we need to save them first
//                    if (profiles == null || profiles.isEmpty()) {
//                        return false;
//                    } else {
//                        manager.saveProfiles(profiles);
//
//                        for (Profile p : profiles) {
//                            if (p.getId() == followerId) {
//                                return true;
//                            }
//                        }
//                        return false;
//                    }
//                });
//    }
//
//    @Override
//    public Observable<Boolean> amFollowing(long followeeId) {
//        return serverApi.searchProfilesFollowedByMe().map(
//                profiles ->
//                {
//                    if (profiles == null || profiles.isEmpty()) {
//                        return false;
//                    } else {
//                        manager.saveProfiles(profiles);
//                        for (Profile p : profiles) {
//                            if (p.getId() == followeeId) {
//                                return true;
//                            }
//                        }
//                        return false;
//                    }
//                }
//        );
//    }
//
//
//    @Override
//    public Observable<InternalText> requestInternalText(InternalTextType type) {
//        return serverApi.requestInternalTexts()
//                .doOnNext(manager::saveInternalTexts)
//                .onErrorResumeNext(Observable.just(manager.getInternalTexts()))
//                .flatMap(internalTexts -> Observable.just(manager.getInternalTextWithType(type)));
//    }
//
//
//    @Override
//    public Observable<Team> findTeamBy(long id) {
//        return Observable.defer(() -> Observable.just(manager.findTeamWithId(id)));
//    }
//
//    @Override
//    public Observable<List<Nation>> getNationsFor(Profile profile) {
//        return Observable.defer(() -> Observable.just(manager.getNationsFor(profile)));
//    }
//
//    @Override
//    public Observable<Object> updateProfileFollowStatus(String followedId, String newFollowStatus) {
//        return serverApi.updateProfileFollowStatus(followedId, newFollowStatus);
//    }
//
//    @Override
//    public Observable<Object> updateProfile(Profile profile) {
//        return serverApi.updateProfile(profile).map((response) -> {
//            //after we save profile and retrieve positive response, we save profile in db
//            manager.save(profile);
//            return response;
//        });
//    }
//
//    @Override
//    public Observable<Object> updateInactivateImage(int imageId) {
//        return serverApi.updateInactivateImage(imageId);
//    }
//
//    @Override
//    public Observable<Object> updateProfileMoreInactivate(int moreId) {
//        return serverApi.updateProfileMoreInactivate(moreId);
//    }
//
//    @Override
//    public Observable<Object> updateImage(String value, TypedFile file) {
//        return serverApi.updateImage(value, file);
//    }
//
//    @Override
//    public Observable<Object> updateProfileRoleModel(String text, String about) {
//        return serverApi.updateProfileRoleModel(text, about);
//    }
//
//    @Override
//    public Observable<Object> updateProfileObjective(String text, int order) {
//        return serverApi.updateProfileObjective(text, order);
//    }
//
//    @Override
//    public Observable<Object> updateProfileStatus(String status) {
//        return serverApi.updateProfileStatus(status);
//    }
//
//    @Override
//    public Observable<Object> addCareerRecordToMore(String text) {
//        return serverApi.addCareerRecordToMore(text);
//    }
//
//    @Override
//    public Observable<Object> updatePassword(String oldPassword, String newPassword) {
//        return serverApi.updatePassword(oldPassword, newPassword).concatMap(o -> {
//            Credentials credentials = manager.getCredentials();
//            credentials.setPassword(newPassword);
//            manager.updateCredentials(credentials);
//            return Observable.just(o);
//        });
//    }
//
//    @Override
//    public Observable<Object> sendContactMessage(String message) {
//        return serverApi.sendContactMessage(message);
//    }
//
//    @Override
//    public Observable<Team> getTeamFor(Profile profile) {
//        if (profile == null) {
//            return Observable.just(null);
//        }
//        return Observable.defer(() -> Observable.just(manager.findTeamWithId(profile.getTeam())));
//    }
//
//    @Override
//    public Observable<Object> forgotPassword(String email) {
//        return serverApi.forgotPassword(email);
//    }
//
//    @Override
//    public Observable<Void> logout() {
//        return performCleanup().map(ignore -> null);
//    }
//
//    @Override
//    public void registerGcmToken(String token) {
//        serverApi.registerGcmToken(token, new Callback<Void>() {
//            @Override
//            public void success(Void aVoid, Response response) {
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//            }
//        });
//    }
//
//    private Observable<Object> updateMetadata() {
//        return serverApi.metadataLastModifiedTimestamp().flatMap(this::processMetadataResponse);
//    }
//
//
//    /**
//     * In case there's metadata to update (at least is the case when app first run),
//     * builds an update chain to be executed. Update chain consists of only those data chunks and requests for data,
//     * where data has recently changed
//     */
//    private Observable<Object> processMetadataResponse(MetadataResponse response) {
//        Observable<Object> updatesChain = Observable.just(null);
//        if (timestampChanged(response.getLeague(), Prefs.MetadataValue.League)) {
//            updatesChain = updatesChain.concatMap(aVoid ->
//                    serverApi.actualLeagues().map(leagues -> {
//                        manager.insertLeagues(leagues);
//                        prefs.setLastTimestampForMeta(Prefs.MetadataValue.League, response.getLeague().getTimestamp());
//                        return null;
//                    }));
//        }
//        if (timestampChanged(response.getClub(), Prefs.MetadataValue.Club)) {
//            updatesChain = updatesChain.concatMap(aVoid ->
//                    serverApi.actualClubs().map(clubs -> {
//                        manager.insertClubs(clubs);
//                        prefs.setLastTimestampForMeta(Prefs.MetadataValue.Club, response.getClub().getTimestamp());
//                        return null;
//                    }));
//        }
//        if (timestampChanged(response.getNation(), Prefs.MetadataValue.Nation)) {
//            updatesChain = updatesChain.concatMap(aVoid ->
//                    serverApi.actualNations().map(leagues -> {
//                        manager.insertNations(leagues);
//                        prefs.setLastTimestampForMeta(Prefs.MetadataValue.Nation, response.getNation().getTimestamp());
//                        return null;
//                    }));
//        }
//
//        if (timestampChanged(response.getNationalTeam(), Prefs.MetadataValue.NationalTeam)) {
//            updatesChain = updatesChain.concatMap(aVoid ->
//                    serverApi.actualNationalTeams().map(leagues -> {
//                        manager.insertNationalTeams(leagues);
//                        prefs.setLastTimestampForMeta(Prefs.MetadataValue.NationalTeam, response.getNationalTeam().getTimestamp());
//                        return null;
//                    }));
//        }
//
//        if (timestampChanged(response.getPosition(), Prefs.MetadataValue.Position)) {
//            updatesChain = updatesChain.concatMap(aVoid ->
//                    serverApi.actualPositions().map(leagues -> {
//                        manager.insertPositions(leagues);
//                        prefs.setLastTimestampForMeta(Prefs.MetadataValue.Position, response.getPosition().getTimestamp());
//                        return null;
//                    }));
//        }
//
//        if (timestampChanged(response.getStateAssociation(), Prefs.MetadataValue.StateAssociation)) {
//            updatesChain = updatesChain.concatMap(aVoid ->
//                    serverApi.actualStateAssociations().map(leagues -> {
//                        manager.insertStateAssociations(leagues);
//                        prefs.setLastTimestampForMeta(Prefs.MetadataValue.StateAssociation, response.getStateAssociation().getTimestamp());
//                        return null;
//                    }));
//        }
//        if (timestampChanged(response.getStateSelection(), Prefs.MetadataValue.StateSelection)) {
//            updatesChain = updatesChain.concatMap(aVoid ->
//                    serverApi.actualStateSelections().map(leagues -> {
//                        manager.insertStateSelections(leagues);
//                        prefs.setLastTimestampForMeta(Prefs.MetadataValue.StateSelection, response.getStateSelection().getTimestamp());
//                        return null;
//                    }));
//        }
//        if (timestampChanged(response.getTeam(), Prefs.MetadataValue.Team)) {
//            updatesChain = updatesChain.concatMap(aVoid ->
//                    serverApi.actualTeams().map(leagues -> {
//                        manager.insertTeams(leagues);
//                        prefs.setLastTimestampForMeta(Prefs.MetadataValue.Team, response.getTeam().getTimestamp());
//                        return null;
//                    }));
//        }
//        if (timestampChanged(response.getTeamCommittee(), Prefs.MetadataValue.TeamCommittee)) {
//            updatesChain = updatesChain.concatMap(aVoid ->
//                    serverApi.actualCommittees().map(leagues -> {
//                        manager.insertTeamCommittees(leagues);
//                        prefs.setLastTimestampForMeta(Prefs.MetadataValue.TeamCommittee, response.getTeamCommittee().getTimestamp());
//                        return null;
//                    }));
//        }
//
//        return updatesChain;
//    }
//
//    /**
//     * Checks whether metadata content has changed recently. If yes, it has to be updated
//     */
//    private boolean timestampChanged(Metadata data, Prefs.MetadataValue metadataType) {
//        return data != null && !prefs.getLastTimestampForMeta(metadataType).equals(data.getTimestamp());
//    }
//
//    @Override
//    public void updateMeta() {
//        updateMetadata()
//                .subscribeOn(backgroundScheduler)
//                .observeOn(backgroundScheduler)
//                .subscribe(new MetaSubscriber());
//    }
//
//    /**
//     * Subscriber for metadata request
//     */
//    private class MetaSubscriber extends Subscriber<Object> {
//        @Override
//        public void onCompleted() {
//
//        }
//
//        @Override
//        public void onError(Throwable e) {
//            Cr.e(this, e);
//        }
//
//        @Override
//        public void onNext(Object o) {
//            Cr.log_d(this, "updates came in:" + o);
//        }
//    }


}
