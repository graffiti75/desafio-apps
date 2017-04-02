package br.android.cericatto.infoglobo.view.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import javax.inject.Inject;

import br.android.cericatto.infoglobo.R;
import br.android.cericatto.infoglobo.databinding.ActivityMainBinding;
import br.android.cericatto.infoglobo.presenter.DetailsPresenter;

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
    private ActivityMainBinding mBinding;

    @Inject
    protected DetailsPresenter mPresenter;

    //--------------------------------------------------
    // Base Activity
    //--------------------------------------------------

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        mBinding = DataBindingUtil.setContentView(mActivity, getContentView());

        showBackArrow(mActivity, false, getString(R.string.toolbar_text));
    }

    /*
    @Override
    protected void resolveDaggerDependency() {
        DaggerDetailsComponent.builder()
            .applicationComponent(getApplicationComponent())
            .mainModule(new DetailsModule(this))
            .build().inject(this);
    }
    */

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    //--------------------------------------------------
    // Callback
    //--------------------------------------------------


}