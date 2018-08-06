package libreria;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * todo elemento Libro tambien es un elemento principal que contiene a su vez
 * otros tantos. Entonces debemos definir el bloque completo Libro , el cual contiene un
 * atributo isbn
 * 
 * @author Fran
 *
 */
// libro es tambien otro elemento padre que contiene otros elementos
@XmlRootElement(name = "libro")
/*
 * indicamos que libro esta compuesto por una serie de elementos con un orden
 * exacto en nuestro documento XML
 */
@XmlType(propOrder = { "isbn", "titulo", "autor" })
public class Libro {
	private String isbn;
	private String titulo;
	private String autor;

	/**
	 * Debemos distinguir entre el contenido de los ATRIBUTOS y el contenido de las
	 * etiquetas. Mediante la anotacion indicamos que se trata de un atributo 
	 * 
	 * @return the isbn
	 */
	@XmlAttribute(name = "isbn")
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 * 
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * No es obligatorio que el nombre de la propiedad de la Clase coincida el nombre de la etiqueta
	 * Aqui lo hemos puesto de forma opcional
	 * 
	 * @return the titulo
	 */
	@XmlElement(name = "titulo")
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo titulo del libro to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return nombre del autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor nombre del autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + "]";
	}

}
