package br.android.cericatto.infoglobo.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import br.android.cericatto.infoglobo.AppConfiguration;
import br.android.cericatto.infoglobo.R;
import br.android.cericatto.infoglobo.databinding.ActivityMainBinding;
import br.android.cericatto.infoglobo.model.Noticia;
import br.android.cericatto.infoglobo.presenter.MainPresenter;
import br.android.cericatto.infoglobo.presenter.di.component.DaggerMainComponent;
import br.android.cericatto.infoglobo.presenter.di.module.MainModule;
import br.android.cericatto.infoglobo.presenter.utils.Utils;
import br.android.cericatto.infoglobo.view.adapter.NoticiaAdapter;

/**
 * MainActivity.java.
 *
 * @author Rodrigo Cericatto
 * @since Mar 29, 2017
 */
public class MainActivity extends BaseActivity {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    // Context.
    private MainActivity mActivity = MainActivity.this;
    private ActivityMainBinding mBinding;
    private SharedPreferences mSharedPreferences;

    // Adapter.
    private NoticiaAdapter mAdapter;


    @Inject
    protected MainPresenter mPresenter;

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

        showBackArrow(mActivity, false, true, getString(R.string.toolbar_text));
        mPresenter.setAdapter(mBinding);
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerMainComponent.builder()
            .applicationComponent(getApplicationComponent())
            .mainModule(new MainModule(this))
            .build().inject(this);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    //--------------------------------------------------
    // Callbacks
    //--------------------------------------------------

    public NoticiaAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(NoticiaAdapter adapter) {
        mAdapter = adapter;
    }

    public void updateAdapter(List<Noticia> list) {
        mPresenter.updateAdapter(list, mBinding);
        mPresenter.setHeader(list.get(0), mBinding);

        mSharedPreferences = getApplicationComponent().exposePreferences();
        mSharedPreferences.edit().putString(AppConfiguration.NOTICIAS_LIST_EXTRA, Utils.toJson(list)).apply();
    }
}