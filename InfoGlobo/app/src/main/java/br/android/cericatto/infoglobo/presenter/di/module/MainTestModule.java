package br.android.cericatto.infoglobo.presenter.di.module;

import br.android.cericatto.infoglobo.model.api.GloboService;
import br.android.cericatto.infoglobo.presenter.di.scope.PerActivity;
import br.android.cericatto.infoglobo.view.fragment.LoadingDialogApiFragment;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * MainTestModule.java.
 *
 * @author Rodrigo Cericatto
 * @since Apr 3, 2017
 */
@Module
public class MainTestModule {
    private LoadingDialogApiFragment mDialogFragment;

    public MainTestModule(LoadingDialogApiFragment dialogFragment) {
        mDialogFragment = dialogFragment;
    }

    @PerActivity
    @Provides
    GloboService provideApiService(Retrofit retrofit) {
        return retrofit.create(GloboService.class);
    }

    @PerActivity
    @Provides
    LoadingDialogApiFragment provideDialogFragment() {
        return mDialogFragment;
    }
}


