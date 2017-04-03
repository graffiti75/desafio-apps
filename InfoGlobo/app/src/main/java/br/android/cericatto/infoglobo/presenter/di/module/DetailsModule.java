package br.android.cericatto.infoglobo.presenter.di.module;

import br.android.cericatto.infoglobo.presenter.di.scope.PerActivity;
import br.android.cericatto.infoglobo.view.activity.DetailsActivity;
import dagger.Module;
import dagger.Provides;

/**
 * DetailsModule.java.
 *
 * @author Rodrigo Cericatto
 * @since Apr 2, 2017
 */
@Module
public class DetailsModule {
    private DetailsActivity mActivity;

    public DetailsModule(DetailsActivity activity) {
        mActivity = activity;
    }

    @PerActivity
    @Provides
    DetailsActivity provideActivity() {
        return mActivity;
    }
}