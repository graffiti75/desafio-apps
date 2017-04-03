package br.android.cericatto.infoglobo.presenter;

import android.app.ProgressDialog;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import br.android.cericatto.infoglobo.AppConfiguration;
import br.android.cericatto.infoglobo.R;
import br.android.cericatto.infoglobo.databinding.ActivityMainBinding;
import br.android.cericatto.infoglobo.model.Noticia;
import br.android.cericatto.infoglobo.model.api.GloboService;
import br.android.cericatto.infoglobo.presenter.utils.ActivityUtils;
import br.android.cericatto.infoglobo.presenter.utils.DialogUtils;
import br.android.cericatto.infoglobo.presenter.utils.RetrofitUtils;
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
        RetrofitUtils.getContent(mActivity, mApiService, dialog);
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

    public void setHeader(Noticia noticia, ActivityMainBinding binding) {
        int black = ContextCompat.getColor(mActivity, R.color.black);
        binding.included.idActivityMainSecaoNomeTextView.setBackgroundColor(black);
        binding.included.setNoticia(noticia);
        binding.included.setSecao(noticia.getEditor());
        binding.included.setImagem(noticia.getImage());
    }

    public void goToDetails() {
        ActivityUtils.startActivityExtras(mActivity, DetailsActivity.class,
            AppConfiguration.NEWS_ID_EXTRA, 0);
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
                    ActivityUtils.startActivityExtras(mActivity, DetailsActivity.class,
                        AppConfiguration.NEWS_ID_EXTRA, position + 1);
                } else {
                    DialogUtils.showNoConnectionDialog(mActivity);
                }
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        });
    }
}