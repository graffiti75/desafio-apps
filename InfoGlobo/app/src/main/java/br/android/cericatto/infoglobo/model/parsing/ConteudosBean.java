package br.android.cericatto.infoglobo.model.parsing;

import java.util.List;

/**
 * ConteudosBean.java class.
 * 
 * @author Rodrigo Cericatto
 * @since Mar 29, 2017
 */
public class ConteudosBean {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private boolean informePublicitario;
	private String subTitulo;
	private String texto;
	private String atualizadoEm;
	private int id;
	private String publicadoEm;
	private SecaoBean secao;
	private String tipo;
	private String titulo;
	private String url;
	private String urlOriginal;
	private List<String> autores;
	private List<String> videos;
	private List<ImagensBean> imagens;

	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------

	public ConteudosBean() {
	}

	public ConteudosBean(boolean informePublicitario, String subTitulo, String texto,
		String atualizadoEm, int id, String publicadoEm, SecaoBean secao,
		String tipo, String titulo, String url, String urlOriginal, List<String> autores,
		List<String> videos, List<ImagensBean> imagens) {
		this.informePublicitario = informePublicitario;
		this.subTitulo = subTitulo;
		this.texto = texto;
		this.atualizadoEm = atualizadoEm;
		this.id = id;
		this.publicadoEm = publicadoEm;
		this.secao = secao;
		this.tipo = tipo;
		this.titulo = titulo;
		this.url = url;
		this.urlOriginal = urlOriginal;
		this.autores = autores;
		this.videos = videos;
		this.imagens = imagens;
	}

	//--------------------------------------------------
	// To String
	//--------------------------------------------------

	@Override
	public String toString() {
		return "ConteudosBean{" +
			"informePublicitario=" + informePublicitario +
			", subTitulo='" + subTitulo + '\'' +
			", texto='" + texto + '\'' +
			", atualizadoEm='" + atualizadoEm + '\'' +
			", id=" + id +
			", publicadoEm='" + publicadoEm + '\'' +
			", secao=" + secao +
			", tipo='" + tipo + '\'' +
			", titulo='" + titulo + '\'' +
			", url='" + url + '\'' +
			", urlOriginal='" + urlOriginal + '\'' +
			", autores=" + autores +
			", videos=" + videos +
			", imagens=" + imagens +
			'}';
	}

	//--------------------------------------------------
	// Getters and Setters
	//--------------------------------------------------

	public boolean isInformePublicitario() {
		return informePublicitario;
	}

	public void setInformePublicitario(boolean informePublicitario) {
		this.informePublicitario = informePublicitario;
	}

	public String getSubTitulo() {
		return subTitulo;
	}

	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getAtualizadoEm() {
		return atualizadoEm;
	}

	public void setAtualizadoEm(String atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublicadoEm() {
		return publicadoEm;
	}

	public void setPublicadoEm(String publicadoEm) {
		this.publicadoEm = publicadoEm;
	}

	public SecaoBean getSecao() {
		return secao;
	}

	public void setSecao(SecaoBean secao) {
		this.secao = secao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlOriginal() {
		return urlOriginal;
	}

	public void setUrlOriginal(String urlOriginal) {
		this.urlOriginal = urlOriginal;
	}

	public List<String> getAutores() {
		return autores;
	}

	public void setAutores(List<String> autores) {
		this.autores = autores;
	}

	public List<String> getVideos() {
		return videos;
	}

	public void setVideos(List<String> videos) {
		this.videos = videos;
	}

	public List<ImagensBean> getImagens() {
		return imagens;
	}

	public void setImagens(List<ImagensBean> imagens) {
		this.imagens = imagens;
	}
}