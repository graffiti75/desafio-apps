package br.android.cericatto.infoglobo.presenter;

import android.os.Bundle;

import java.util.List;

import javax.inject.Inject;

import br.android.cericatto.infoglobo.AppConfiguration;
import br.android.cericatto.infoglobo.R;
import br.android.cericatto.infoglobo.model.Noticia;
import br.android.cericatto.infoglobo.view.activity.MainActivity;

/**
 * DetailsPresenter.java.
 *
 * @author Rodrigo Cericatto
 * @since Apr 1, 2017
 */
public class DetailsPresenter {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private MainActivity mActivity;

    @Inject
    protected List<Noticia> mNoticiaList;

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------

    @Inject
    public DetailsPresenter(MainActivity activity) {
        mActivity = activity;
    }

    //--------------------------------------------------
    // Public Methods
    //--------------------------------------------------

    public void getExtras() {
        Bundle extras = mActivity.getIntent().getExtras();
        if (extras != null) {
//            mActivity.setCityId(extras.getString(AppConfiguration.NEWS_ID_EXTRA));
            mActivity.showBackArrow(mActivity, true, mActivity.getString(R.string.app_name));
        }
    }

    //--------------------------------------------------
    // Private Methods
    //--------------------------------------------------

}