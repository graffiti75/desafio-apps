package br.android.cericatto.infoglobo.presenter.di.component;

import br.android.cericatto.infoglobo.presenter.di.module.DetailsModule;
import br.android.cericatto.infoglobo.presenter.di.scope.PerActivity;
import br.android.cericatto.infoglobo.view.activity.DetailsActivity;
import dagger.Component;

/**
 * DetailsComponent.java.
 *
 * @author Rodrigo Cericatto
 * @since Apr 2, 2017
 */
@PerActivity
@Component(modules = DetailsModule.class, dependencies = ApplicationComponent.class)
public interface DetailsComponent {
    void inject(DetailsActivity activity);
}