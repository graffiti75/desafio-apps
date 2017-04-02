package br.android.cericatto.infoglobo;

import android.app.Application;

import br.android.cericatto.infoglobo.presenter.di.component.ApplicationComponent;
import br.android.cericatto.infoglobo.presenter.di.component.DaggerApplicationComponent;
import br.android.cericatto.infoglobo.presenter.di.module.ApplicationModule;

/**
 * MainApplication.java.
 *
 * @author Rodrigo Cericatto
 * @since Mar 29, 2017
 */
public class MainApplication extends Application {
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(new ApplicationModule(this, AppConfiguration.BASE_URL))
            .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}