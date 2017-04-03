package br.android.cericatto.infoglobo.view.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import javax.inject.Inject;

import br.android.cericatto.infoglobo.MainApplication;
import br.android.cericatto.infoglobo.R;
import br.android.cericatto.infoglobo.model.api.GloboService;
import br.android.cericatto.infoglobo.presenter.di.component.DaggerMainTestComponent;
import br.android.cericatto.infoglobo.presenter.di.module.MainTestModule;
import br.android.cericatto.infoglobo.presenter.utils.RetrofitUtils;
import br.android.cericatto.infoglobo.view.activity.test.TestMainActivity;

/**
 * LoadingDialogApiFragment.java.
 *
 * @author Rodrigo Cericatto
 * @since Apr 3, 2017
 */
public class LoadingDialogApiFragment extends DialogFragment {

    //--------------------------------------------------
    // Constants
    //--------------------------------------------------

    public static final String TAG = "LoadingApi";

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    @Inject
    protected GloboService mApiService;

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------

    public LoadingDialogApiFragment() {
    }

    //--------------------------------------------------
    // Dialog Fragment
    //--------------------------------------------------

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        TestMainActivity activity = (TestMainActivity)getActivity();

        DaggerMainTestComponent.builder()
            .applicationComponent(((MainApplication)activity.getApplication()).getApplicationComponent())
            .mainTestModule(new MainTestModule(this))
            .build().inject(this);

        RetrofitUtils.getContent(activity, mApiService, this);

        return new AlertDialog.Builder(getActivity())
            .setTitle(R.string.loading)
            .setMessage(R.string.please_wait)
            .create();
    }
}