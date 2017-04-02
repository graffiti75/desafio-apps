package br.android.cericatto.infoglobo.presenter.di.module;

import br.android.cericatto.infoglobo.model.api.GloboService;
import br.android.cericatto.infoglobo.presenter.di.scope.PerActivity;
import br.android.cericatto.infoglobo.view.activity.MainActivity;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * MainModule.java.
 *
 * @author Rodrigo Cericatto
 * @since Jan 29, 2017
 */
@Module
public class MainModule {
    private MainActivity mActivity;

    public MainModule(MainActivity activity) {
        mActivity = activity;
    }

    @PerActivity
    @Provides
    GloboService provideApiService(Retrofit retrofit) {
        return retrofit.create(GloboService.class);
    }

    @PerActivity
    @Provides
    MainActivity provideActivity() {
        return mActivity;
    }
}


