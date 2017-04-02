package br.android.cericatto.infoglobo.presenter.di.component;

import br.android.cericatto.infoglobo.presenter.di.module.MainModule;
import br.android.cericatto.infoglobo.presenter.di.scope.PerActivity;
import br.android.cericatto.infoglobo.view.activity.MainActivity;
import dagger.Component;

/**
 * MainComponent.java.
 *
 * @author Rodrigo Cericatto
 * @since Jan 27, 2017
 */
@PerActivity
@Component(modules = MainModule.class, dependencies = ApplicationComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
}