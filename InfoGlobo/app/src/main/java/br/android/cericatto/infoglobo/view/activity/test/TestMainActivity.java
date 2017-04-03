package br.android.cericatto.infoglobo.view.activity.test;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import br.android.cericatto.infoglobo.R;
import br.android.cericatto.infoglobo.databinding.ActivityTestMainBinding;
import br.android.cericatto.infoglobo.view.fragment.LoadingDialogApiFragment;

/**
 * TestMainActivity.java.
 * 
 * @author Rodrigo Cericatto
 * @since Apr 3, 2017
 */
public class TestMainActivity extends AppCompatActivity {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private ActivityTestMainBinding mBinding;

	//--------------------------------------------------
	// Activity Life Cycle
	//--------------------------------------------------

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test_main);

		LoadingDialogApiFragment fragment = new LoadingDialogApiFragment();
		fragment.setCancelable(false);
		fragment.show(getSupportFragmentManager(), LoadingDialogApiFragment.TAG);
	}

	//--------------------------------------------------
	// Callbacks
	//--------------------------------------------------

	public void onLoadingFinished() {
		mBinding.idActivityTestMainTextView.setText(R.string.dialog_ok);
	}
}