package br.android.cericatto.infoglobo.presenter.di.component;

import br.android.cericatto.infoglobo.presenter.di.module.MainTestModule;
import br.android.cericatto.infoglobo.presenter.di.scope.PerActivity;
import br.android.cericatto.infoglobo.view.fragment.LoadingDialogApiFragment;
import dagger.Component;

/**
 * MainTestComponent.java.
 *
 * @author Rodrigo Cericatto
 * @since Apr 3, 2017
 */
@PerActivity
@Component(modules = MainTestModule.class, dependencies = ApplicationComponent.class)
public interface MainTestComponent {
    void inject(LoadingDialogApiFragment fragment);
}