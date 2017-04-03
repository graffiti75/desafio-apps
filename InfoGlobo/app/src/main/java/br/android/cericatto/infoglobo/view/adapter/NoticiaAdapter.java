package br.android.cericatto.infoglobo.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.android.cericatto.infoglobo.R;
import br.android.cericatto.infoglobo.databinding.AdapterNoticiaBinding;
import br.android.cericatto.infoglobo.model.Noticia;
import br.android.cericatto.infoglobo.view.activity.MainActivity;

/**
 * NoticiaAdapter.java.
 * 
 * @author Rodrigo Cericatto
 * @since Mar 29, 2017
 */
public class NoticiaAdapter extends RecyclerView.Adapter<NoticiaAdapter.NoticiaAdapterViewHolder> {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private MainActivity mActivity;
	private List<Noticia> mItems;

	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------

	public NoticiaAdapter(MainActivity context, List<Noticia> items) {
		mActivity = context;
		mItems = items;
	}

	//--------------------------------------------------
	// Adapter Methods
	//--------------------------------------------------

	@Override
	public NoticiaAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		AdapterNoticiaBinding binding = DataBindingUtil.inflate(
			LayoutInflater.from(parent.getContext()), R.layout.adapter_noticia, parent, false);
		return new NoticiaAdapterViewHolder(binding.getRoot());
	}

	@Override
	public void onBindViewHolder(NoticiaAdapterViewHolder holder, int position) {
		Noticia item = mItems.get(position);
		holder.binding.setNoticia(item);
		holder.binding.setSecao(item.getEditor());
		holder.binding.setImagem(item.getImage());
	}

	@Override
	public int getItemCount() {
		if (mItems != null && mItems.size() > 0) {
			return mItems.size();
		}
		return 0;
	}

	//--------------------------------------------------
	// View Holder
	//--------------------------------------------------

	public class NoticiaAdapterViewHolder extends RecyclerView.ViewHolder {
		AdapterNoticiaBinding binding;

		public NoticiaAdapterViewHolder(View rootView) {
			super(rootView);
			binding = DataBindingUtil.bind(rootView);
		}
	}
}