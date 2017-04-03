package br.android.cericatto.infoglobo.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import br.android.cericatto.infoglobo.AppConfiguration;
import br.android.cericatto.infoglobo.R;
import br.android.cericatto.infoglobo.databinding.ActivityDetailsBinding;
import br.android.cericatto.infoglobo.presenter.DetailsPresenter;
import br.android.cericatto.infoglobo.presenter.di.component.DaggerDetailsComponent;
import br.android.cericatto.infoglobo.presenter.di.module.DetailsModule;
import br.android.cericatto.infoglobo.presenter.utils.NavigationUtils;

/**
 * DetailsActivity.java.
 *
 * @author Rodrigo Cericatto
 * @since Mar 29, 2017
 */
public class DetailsActivity extends BaseActivity {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    // Context.
    private DetailsActivity mActivity = DetailsActivity.this;
    private ActivityDetailsBinding mBinding;
    private SharedPreferences mSharedPreferences;

    @Inject
    protected DetailsPresenter mPresenter;

    //--------------------------------------------------
    // Base Activity
    //--------------------------------------------------

    @Override
    protected int getContentView() {
        return R.layout.activity_details;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        mBinding = DataBindingUtil.setContentView(mActivity, getContentView());

        showBackArrow(mActivity, true, false, getString(R.string.toolbar_text));
        getExtras();
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerDetailsComponent.builder()
            .applicationComponent(getApplicationComponent())
            .detailsModule(new DetailsModule(this))
            .build().inject(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        NavigationUtils.animate(mActivity, NavigationUtils.Animation.BACK);
    }

    //--------------------------------------------------
    // Menu
    //--------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //--------------------------------------------------
    // Private Methods
    //--------------------------------------------------

    private void getExtras() {
        mSharedPreferences = getApplicationComponent().exposePreferences();
        String json = mSharedPreferences.getString(AppConfiguration.NOTICIAS_LIST_EXTRA, "");
        mPresenter.getExtras(mBinding, json);
    }
}