package com.example.airnavigate.Modules;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.example.airnavigate.BuildConfig;
import com.example.airnavigate.Data.Credentials;
import com.example.airnavigate.Data.DBManager;
import com.example.airnavigate.Data.DataSourceImpl;
import com.example.airnavigate.Data.IAirNavigateAPI;
import com.example.airnavigate.Data.IDataSource;
import com.example.airnavigate.Internal.BackgroundThread;
import com.example.airnavigate.Internal.MainThread;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Kelebro63 on 10.12.2015.
 */
@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    @MainThread
    Scheduler provideMainThreadScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    @BackgroundThread
    Scheduler provideBackgroundThreadScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    IDataSource provideDataSource(IAirNavigateAPI api, @BackgroundThread Scheduler scheduler, DBManager manager) { //, Prefs prefs
        return new DataSourceImpl(api, scheduler, manager, null);
    }


    @Provides
    @Singleton
    OkHttpClient provideClient() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(10, TimeUnit.SECONDS);
        client.setReadTimeout(10, TimeUnit.SECONDS);
        return client;
    }

    @Provides
    @Singleton
    IAirNavigateAPI provideRestAPI(OkHttpClient client, RequestInterceptor interceptor) { //, RequestInterceptor interceptor

        RestAdapter.Builder builder = new RestAdapter.Builder();
        builder.setClient(new OkClient(client));
        builder.setEndpoint("http://api.duma.gov.ru/api/3b816383786e9b28914837d27a06c50394dd5240");
        builder.setRequestInterceptor(interceptor);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        builder.setConverter(new GsonConverter(gson));

        if (BuildConfig.DEBUG) {
            builder.setLogLevel(RestAdapter.LogLevel.FULL);
        }

        return builder.build().create(IAirNavigateAPI.class);
    }

    @Provides
    @Singleton
    RequestInterceptor provideRequestInterceptor(Credentials credentials) {
        return requestFacade -> {
            if (!TextUtils.isEmpty(credentials.getToken())) {
                //if user token is not empty, lets append dat header!
                requestFacade.addQueryParam(
                        "app_token", credentials.getToken()
                );

            }

        };
    }

    @Provides
    @Singleton
    Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    Credentials provideCredentials() {
        return new Credentials();
    }
}
