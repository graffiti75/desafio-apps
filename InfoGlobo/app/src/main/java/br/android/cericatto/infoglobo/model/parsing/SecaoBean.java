package br.android.cericatto.infoglobo.model.parsing;

/**
 * SecaoBean.java class.
 * 
 * @author Rodrigo Cericatto
 * @since Mar 29, 2017
 */
public class SecaoBean {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private String nome;
	private String url;

	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------

	public SecaoBean() {
	}

	public SecaoBean(String nome, String url) {
		this.nome = nome;
		this.url = url;
	}

	//--------------------------------------------------
	// To String
	//--------------------------------------------------

	@Override
	public String toString() {
		return "SecaoBean{" +
			"nome='" + nome + '\'' +
			", url='" + url + '\'' +
			'}';
	}

	//--------------------------------------------------
	// Getters and Setters
	//--------------------------------------------------

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}