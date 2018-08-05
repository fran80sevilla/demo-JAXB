package libreria;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * todo string Libro tambien es un elemento principal que contiene a su vez
 * otros elementos Entonces debemos definir el bloque completo libro contiene un
 * atributo isbn
 * 
 * @author Fran
 *
 */
// libro es tambien un elemento principal que contiene otros elementos
@XmlRootElement(name = "libro")
/*
 * indicamos que libro esta compuesto por una serie de elementos en un orden
 * exacto de nuestro elemento xml
 */
@XmlType(propOrder = { "isbn", "titulo", "autor" })
public class Libro {
	private String isbn;
	private String titulo;
	private String autor;

	/**
	 * Debemos distinguir entre el contenido de los ATRIBUTOS y el contenido de las
	 * etiquetas Definimos mediante la anotacion que se trata de un atributo en este
	 * caso e indicamos el nombre del mismo
	 * 
	 * @return the isbn
	 */
	@XmlAttribute(name = "isbn")
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn
	 *            the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Si coincide la propiedad con el nombre de la etiqueta o elemento, no es
	 * obligatorio definirlo. Aqui lo hemos puesto de forma opcional
	 * 
	 * @return the titulo
	 */
	@XmlElement(name = "titulo")
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor
	 *            the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + "]";
	}

}
