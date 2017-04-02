package br.android.cericatto.infoglobo.presenter.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;

import br.android.cericatto.infoglobo.R;

/**
 * DialogUtils.java.
 * 
 * @author Rodrigo Cericatto
 * @since Mar 29, 2017
 */
public class DialogUtils {

	public static ProgressDialog showProgressDialog(Context context, String message) {
		return showProgressDialog(context, message, false);
	}
	
	private static ProgressDialog showProgressDialog(Context context, String message, boolean cancelable) {
		ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage(message);
        dialog.setIndeterminate(true);
        dialog.setCancelable(cancelable);
        dialog.show();
        return dialog;
	}
	
	public static void showSimpleAlert(Context context, int titleResource, int messageResource, OnClickListener listener) {
		String dialogTitle = titleResource > 0 ? context.getString(titleResource) : null;
		String dialogMessage = messageResource > 0 ? context.getString(messageResource) : null;
		showSimpleAlert(context, dialogTitle, dialogMessage, listener);
	}

	private static void showSimpleAlert(Context context, String title, String message, OnClickListener listener) {
		if (context instanceof Activity && ((Activity)context).isFinishing()) {
			return;
		}
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(title);
		builder.setMessage(message);
		builder.setIcon(android.R.drawable.ic_dialog_alert);
		builder.setPositiveButton(R.string.dialog_ok, listener);
		builder.show();
	}

	public static void showNoConnectionDialog(Activity activity) {
		showSimpleAlert(activity, R.string.network_error_dialog_title,
			R.string.network_error_dialog_message, (dialog, which) -> dialog.cancel());
	}
}