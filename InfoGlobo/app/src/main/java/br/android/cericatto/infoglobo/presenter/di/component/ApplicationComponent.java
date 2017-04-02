package br.android.cericatto.infoglobo.presenter.di.component;

import android.content.Context;

import javax.inject.Singleton;

import br.android.cericatto.infoglobo.presenter.di.module.ApplicationModule;
import dagger.Component;
import retrofit2.Retrofit;

/**
 * ApplicationComponent.java.
 *
 * @author Rodrigo Cericatto
 * @since Mar 29, 2017
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Retrofit exposeRetrofit();
    Context exposeContext();
}