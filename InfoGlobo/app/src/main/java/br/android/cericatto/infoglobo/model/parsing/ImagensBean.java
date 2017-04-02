package br.android.cericatto.infoglobo.model.parsing;

/**
 * ImagensBean.java class.
 * 
 * @author Rodrigo Cericatto
 * @since Mar 29, 2017
 */
public class ImagensBean {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private String autor;
	private String fonte;
	private String legenda;
	private String url;

	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------

	public ImagensBean() {
	}

	public ImagensBean(String autor, String fonte, String legenda, String url) {
		this.autor = autor;
		this.fonte = fonte;
		this.legenda = legenda;
		this.url = url;
	}

	//--------------------------------------------------
	// To String
	//--------------------------------------------------

	@Override
	public String toString() {
		return "ImagensBean{" +
			"autor='" + autor + '\'' +
			", fonte='" + fonte + '\'' +
			", legenda='" + legenda + '\'' +
			", url='" + url + '\'' +
			'}';
	}

	//--------------------------------------------------
	// Getters and Setters
	//--------------------------------------------------

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getFonte() {
		return fonte;
	}

	public void setFonte(String fonte) {
		this.fonte = fonte;
	}

	public String getLegenda() {
		return legenda;
	}

	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}