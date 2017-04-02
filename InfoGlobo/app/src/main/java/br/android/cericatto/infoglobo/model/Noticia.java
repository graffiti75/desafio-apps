package br.android.cericatto.infoglobo.model;

import java.util.List;

import br.android.cericatto.infoglobo.model.parsing.ImagensBean;
import br.android.cericatto.infoglobo.model.parsing.SecaoBean;

/**
 * Noticia.java class.
 * 
 * @author Rodrigo Cericatto
 * @since Mar 29, 2017
 */
public class Noticia {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private List<String> autor;
	private String titulo;
	private SecaoBean editor;
	private String subTitulo;
	private String publicadoEm;
	private ImagensBean image;
	private String texto;

	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------

	public Noticia() {
	}

	public Noticia(List<String> autor, String titulo, SecaoBean editor, String subTitulo,
				   String publicadoEm, ImagensBean image, String texto) {
		this.autor = autor;
		this.titulo = titulo;
		this.editor = editor;
		this.subTitulo = subTitulo;
		this.publicadoEm = publicadoEm;
		this.image = image;
		this.texto = texto;
	}

	//--------------------------------------------------
	// To String
	//--------------------------------------------------

	@Override
	public String toString() {
		return "Noticia{" +
			"autor=" + autor +
			", titulo='" + titulo + '\'' +
			", editor=" + editor +
			", subTitulo='" + subTitulo + '\'' +
			", publicadoEm='" + publicadoEm + '\'' +
			", image=" + image +
			", texto='" + texto + '\'' +
			'}';
	}

	//--------------------------------------------------
	// Getters and Setters
	//--------------------------------------------------

	public List<String> getAutor() {
		return autor;
	}

	public void setAutor(List<String> autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public SecaoBean getEditor() {
		return editor;
	}

	public void setEditor(SecaoBean editor) {
		this.editor = editor;
	}

	public String getSubTitulo() {
		return subTitulo;
	}

	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}

	public String getPublicadoEm() {
		return publicadoEm;
	}

	public void setPublicadoEm(String publicadoEm) {
		this.publicadoEm = publicadoEm;
	}

	public ImagensBean getImage() {
		return image;
	}

	public void setImage(ImagensBean image) {
		this.image = image;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
}