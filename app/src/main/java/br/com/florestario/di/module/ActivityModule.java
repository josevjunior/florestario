/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package br.com.florestario.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import br.com.florestario.data.network.model.BlogResponse;
import br.com.florestario.data.network.model.OpenSourceResponse;
import br.com.florestario.di.ActivityContext;
import br.com.florestario.di.PerActivity;
import br.com.florestario.ui.about.AboutMvpPresenter;
import br.com.florestario.ui.about.AboutMvpView;
import br.com.florestario.ui.about.AboutPresenter;
import br.com.florestario.ui.feed.FeedMvpPresenter;
import br.com.florestario.ui.feed.FeedMvpView;
import br.com.florestario.ui.feed.FeedPagerAdapter;
import br.com.florestario.ui.feed.FeedPresenter;
import br.com.florestario.ui.feed.blogs.BlogAdapter;
import br.com.florestario.ui.feed.blogs.BlogMvpPresenter;
import br.com.florestario.ui.feed.blogs.BlogMvpView;
import br.com.florestario.ui.feed.blogs.BlogPresenter;
import br.com.florestario.ui.feed.opensource.OpenSourceAdapter;
import br.com.florestario.ui.feed.opensource.OpenSourceMvpPresenter;
import br.com.florestario.ui.feed.opensource.OpenSourceMvpView;
import br.com.florestario.ui.feed.opensource.OpenSourcePresenter;
import br.com.florestario.ui.login.LoginMvpPresenter;
import br.com.florestario.ui.login.LoginMvpView;
import br.com.florestario.ui.login.LoginPresenter;
import br.com.florestario.ui.main.MainMvpPresenter;
import br.com.florestario.ui.main.MainMvpView;
import br.com.florestario.ui.main.MainPresenter;
import br.com.florestario.ui.main.rating.RatingDialogMvpPresenter;
import br.com.florestario.ui.main.rating.RatingDialogMvpView;
import br.com.florestario.ui.main.rating.RatingDialogPresenter;
import br.com.florestario.ui.splash.SplashMvpPresenter;
import br.com.florestario.ui.splash.SplashMvpView;
import br.com.florestario.ui.splash.SplashPresenter;
import br.com.florestario.utils.rx.AppSchedulerProvider;
import br.com.florestario.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    AboutMvpPresenter<AboutMvpView> provideAboutPresenter(
            AboutPresenter<AboutMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    RatingDialogMvpPresenter<RatingDialogMvpView> provideRateUsPresenter(
            RatingDialogPresenter<RatingDialogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedMvpPresenter<FeedMvpView> provideFeedPresenter(
            FeedPresenter<FeedMvpView> presenter) {
        return presenter;
    }

    @Provides
    OpenSourceMvpPresenter<OpenSourceMvpView> provideOpenSourcePresenter(
            OpenSourcePresenter<OpenSourceMvpView> presenter) {
        return presenter;
    }

    @Provides
    BlogMvpPresenter<BlogMvpView> provideBlogMvpPresenter(
            BlogPresenter<BlogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter(AppCompatActivity activity) {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    OpenSourceAdapter provideOpenSourceAdapter() {
        return new OpenSourceAdapter(new ArrayList<OpenSourceResponse.Repo>());
    }

    @Provides
    BlogAdapter provideBlogAdapter() {
        return new BlogAdapter(new ArrayList<BlogResponse.Blog>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
