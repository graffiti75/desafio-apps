package br.android.cericatto.infoglobo.presenter;

import android.app.ProgressDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import br.android.cericatto.infoglobo.AppConfiguration;
import br.android.cericatto.infoglobo.R;
import br.android.cericatto.infoglobo.databinding.ActivityMainBinding;
import br.android.cericatto.infoglobo.model.Noticia;
import br.android.cericatto.infoglobo.model.api.GloboService;
import br.android.cericatto.infoglobo.presenter.utils.ActivityUtils;
import br.android.cericatto.infoglobo.presenter.utils.DialogUtils;
import br.android.cericatto.infoglobo.presenter.utils.ReactiveUtils;
import br.android.cericatto.infoglobo.presenter.utils.Utils;
import br.android.cericatto.infoglobo.view.activity.DetailsActivity;
import br.android.cericatto.infoglobo.view.activity.MainActivity;
import br.android.cericatto.infoglobo.view.adapter.DividerItemDecoration;
import br.android.cericatto.infoglobo.view.adapter.NoticiaAdapter;
import br.android.cericatto.infoglobo.view.listener.RecyclerTouchListener;
import br.android.cericatto.infoglobo.view.listener.RecyclerViewListeners;

/**
 * MainPresenter.java.
 *
 * @author Rodrigo Cericatto
 * @since Mar 29, 2017
 */
public class MainPresenter {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private MainActivity mActivity;

    @Inject
    protected GloboService mApiService;

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------

    @Inject
    public MainPresenter(MainActivity activity) {
        mActivity = activity;
    }

    //--------------------------------------------------
    // Public Methods
    //--------------------------------------------------

    public void setAdapter(ActivityMainBinding binding) {
        binding.idActivityMainRecyclerView.addOnItemTouchListener(setRecyclerViewListener(binding));

        String message = mActivity.getString(R.string.fetching_news);
        ProgressDialog dialog = DialogUtils.showProgressDialog(mActivity, message);
        ReactiveUtils.getContent(mActivity, mApiService, dialog);
    }

    public void updateAdapter(List<Noticia> list, ActivityMainBinding binding) {
        mActivity.setAdapter(new NoticiaAdapter(mActivity, list));
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.idActivityMainRecyclerView.setLayoutManager(layoutManager);
        binding.idActivityMainRecyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.idActivityMainRecyclerView.setAdapter(mActivity.getAdapter());
        binding.idActivityMainRecyclerView.addItemDecoration(
            new DividerItemDecoration(mActivity, R.drawable.divider));
    }

    //--------------------------------------------------
    // Private Methods
    //--------------------------------------------------

    private RecyclerTouchListener setRecyclerViewListener(ActivityMainBinding binding) {
        return new RecyclerTouchListener(mActivity, binding.idActivityMainRecyclerView,
        new RecyclerViewListeners() {
            @Override
            public void onClick(View view, final int position) {
                if (Utils.checkConnection(mActivity)) {
//                    ActivityUtils.startActivityExtras(mActivity, DetailsActivity.class,
//                        AppConfiguration.NEWS_ID_EXTRA, position);
                } else {
                    DialogUtils.showNoConnectionDialog(mActivity);
                }
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        });
    }

    //--------------------------------------------------
    // Callbacks
    //--------------------------------------------------


}