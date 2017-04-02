package br.android.cericatto.infoglobo.presenter.utils;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.android.cericatto.infoglobo.R;
import br.android.cericatto.infoglobo.model.Noticia;
import br.android.cericatto.infoglobo.model.api.GloboService;
import br.android.cericatto.infoglobo.model.parsing.ConteudosBean;
import br.android.cericatto.infoglobo.model.parsing.GloboResponse;
import br.android.cericatto.infoglobo.model.parsing.ImagensBean;
import br.android.cericatto.infoglobo.model.parsing.SecaoBean;
import br.android.cericatto.infoglobo.view.activity.MainActivity;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * ActivityUtils class.
 * 
 * @author Rodrigo Cericatto
 * @since Mar 29, 2017
 */
public class ReactiveUtils {

	//--------------------------------------------------
	// Retrofit
	//--------------------------------------------------

	public static void getContent(AppCompatActivity activity, GloboService apiService, Dialog dialog) {
		Observable<List<GloboResponse>> observable = apiService.getContent();
		observable
			.compose(setupSchedulers())
			.subscribe(
				(response) -> setResponseInActivity(activity, response.get(0)),
				(error) -> {
					dialog.dismiss();
					String message = activity.getString(R.string.fetch_news_error);
					Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
				},
				() -> dialog.dismiss()
			);
	}

	private static void setResponseInActivity(AppCompatActivity activity, GloboResponse response) {
		// Get list.
		List<Noticia> list = new ArrayList<>();
        for (ConteudosBean item : response.getConteudos()) {
            String titulo = item.getTitulo();
            SecaoBean editor = item.getSecao();
            String subTitulo = item.getSubTitulo();
            String publicadoEm = item.getPublicadoEm();
            String texto = item.getTexto();
            Noticia noticia = new Noticia(getAutores(item.getAutores()), titulo, editor, subTitulo,
                publicadoEm, getImagens(item.getImagens()), texto);
            list.add(noticia);
        }
		// Calls activity.
		MainActivity mainActivity = (MainActivity) activity;
		mainActivity.updateAdapter(list);
	}

	private static List<String> getAutores(List<String> autores) {
        if (autores == null || autores.size() <= 0) return null;
        return autores;
    }

    private static ImagensBean getImagens(List<ImagensBean> imagens) {
        if (imagens == null || imagens.size() <= 0) return null;
        return imagens.get(0);
    }

	//--------------------------------------------------
	// Common Database Methods
	//--------------------------------------------------

	public static <T> Observable.Transformer<T, T> setupSchedulers() {
		return observable -> observable
			.subscribeOn(Schedulers.newThread())
			.observeOn(AndroidSchedulers.mainThread());
	}
}