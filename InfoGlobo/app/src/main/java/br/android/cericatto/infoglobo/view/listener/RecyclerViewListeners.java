package br.android.cericatto.infoglobo.view.listener;

import android.view.View;

/**
 * RecyclerViewListeners.java.
 * 
 * @author Rodrigo Cericatto
 * @since Mar 29, 2017
 */
public interface RecyclerViewListeners {
	void onClick(View view, int position);
	void onLongClick(View view, int position);
}