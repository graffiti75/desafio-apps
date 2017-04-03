package br.android.cericatto.infoglobo.presenter;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import br.android.cericatto.infoglobo.AppConfiguration;
import br.android.cericatto.infoglobo.databinding.ActivityDetailsBinding;
import br.android.cericatto.infoglobo.model.Noticia;
import br.android.cericatto.infoglobo.view.activity.DetailsActivity;

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

    private DetailsActivity mActivity;

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------

    @Inject
    public DetailsPresenter(DetailsActivity activity) {
        mActivity = activity;
    }

    //--------------------------------------------------
    // Public Methods
    //--------------------------------------------------

    public void getExtras(ActivityDetailsBinding binding, String json) {
        // Gets the list.
        Gson gson = new Gson();
        Type datasetListType = new TypeToken<Collection<Noticia>>() {}.getType();
        List<Noticia> list = gson.fromJson(json, datasetListType);

        // Gets the current item.
        Bundle extras = mActivity.getIntent().getExtras();
        if (extras != null) {
            int id = extras.getInt(AppConfiguration.NEWS_ID_EXTRA);
            Noticia noticia = list.get(id);
            setBinding(binding, noticia);
        }
    }

    //--------------------------------------------------
    // Private Methods
    //--------------------------------------------------

    private void setBinding(ActivityDetailsBinding binding, Noticia noticia) {
        binding.setNoticia(noticia);
        binding.tituloIncluded.setNoticia(noticia);
        binding.imagemIncluded.setImagem(noticia.getImage());
    }
}