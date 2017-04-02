package br.android.cericatto.infoglobo.model.parsing;

import java.util.List;

/**
 * GloboResponse.java class.
 * 
 * @author Rodrigo Cericatto
 * @since Mar 29, 2017
 */
public class GloboResponse {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private String produto;
	private List<ConteudosBean> conteudos;

	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------

	public GloboResponse() {
	}

	public GloboResponse(List<ConteudosBean> conteudos, String produto) {
		this.conteudos = conteudos;
		this.produto = produto;
	}

	//--------------------------------------------------
	// To String
	//--------------------------------------------------

	@Override
	public String toString() {
		return "GloboResponse{" +
			"conteudos=" + conteudos +
			", produto='" + produto + '\'' +
			'}';
	}

	//--------------------------------------------------
	// Getters and Setters
	//--------------------------------------------------

	public List<ConteudosBean> getConteudos() {
		return conteudos;
	}

	public void setConteudos(List<ConteudosBean> conteudos) {
		this.conteudos = conteudos;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}
}