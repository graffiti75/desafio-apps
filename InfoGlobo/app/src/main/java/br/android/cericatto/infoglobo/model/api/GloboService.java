package br.android.cericatto.infoglobo.model.api;

import java.util.List;

import br.android.cericatto.infoglobo.model.parsing.GloboResponse;
import retrofit2.http.GET;
import rx.Observable;

/**
 * GloboService.java class.
 * 
 * @author Rodrigo Cericatto
 * @since Mar 29, 2017
 */
public interface GloboService {
	@GET("/Infoglobo/desafio-apps/master/capa.json")
	Observable<List<GloboResponse>> getContent();
}