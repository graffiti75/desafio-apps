package br.android.cericatto.infoglobo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.android.cericatto.infoglobo.MainApplication;
import br.android.cericatto.infoglobo.R;
import br.android.cericatto.infoglobo.presenter.di.component.ApplicationComponent;

/**
 * BaseActivity.java.
 *
 * @author Rodrigo Cericatto
 * @since Mar 29, 2017
 */
public abstract class BaseActivity extends AppCompatActivity {

    //--------------------------------------------------
    // Activity Life Cycle
    //--------------------------------------------------

    protected abstract int getContentView();

    @CallSuper
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        resolveDaggerDependency();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onViewReady(savedInstanceState, getIntent());
    }

    //--------------------------------------------------
    // Dependency Injection
    //--------------------------------------------------

    protected void resolveDaggerDependency() {}

    protected ApplicationComponent getApplicationComponent() {
        return ((MainApplication) getApplication()).getApplicationComponent();
    }

    //--------------------------------------------------
    // Methods
    //--------------------------------------------------

    public void showBackArrow(AppCompatActivity activity, boolean homeEnabled, boolean logoEnabled,
        String string) {
        Toolbar toolbar = (Toolbar)activity.findViewById(R.id.id_toolbar);
        if (toolbar != null) {
            activity.setSupportActionBar(toolbar);
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(homeEnabled);
            activity.getSupportActionBar().setTitle(string);
            if (logoEnabled) activity.getSupportActionBar().setLogo(R.drawable.ic_menu);
        }
    }
}