/**
 * 
 */
package libreria;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * ES LA CLASE QUE REPRESENTA LA TOTALIDAD DEL XML
 * libreria representa el elemento raiz del xml
 * Tenemos Libreria > libros
 * la anotacion XmlRootElement nos indica que es el elemento raiz y el name debe llamarse igual que 
 * la etiqueta ROOT o raiz principal
 * En el arraylist introduciremos todos los libros, y corresponde a la etiqueta <libros> que es un 
 * envoltorio de los libros. Los elementos que son un envoltorio se definen como XmlElementWrapper
 * 
 * @author Fran
 *
 */

@XmlRootElement(name="libreria")
@XmlType(propOrder= {"nombre", "libros", "libro"})
public class Libreria {
	private String nombre;
	private String libro;
	
	// dentro guardaremos una coleccion de objetos Libro	
	private ArrayList<Libro> libros = new ArrayList();
	/**
	 * CONSTRUCTOR
	 */
	public Libreria() {
	}
	/** ACCESORES DE LAS PROPIEDADES DE LA CLASE */
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return the libro
	 */
	public String getLibro() {
		return libro;
	}
	/**
	 * @param libro the libro to set
	 */
	public void setLibro(String libro) {
		this.libro = libro;
	}
	/**
	 * Indicamos el envoltorio (libros) y el elemento que devuelve esta coleccion (libro)
	 * Los elementos que son un envoltorio  de otros elementos se definen como XmlElementWrapper
	 * @return libros ArrayList<Libro>
	 */
	@XmlElementWrapper(name="libros")
	@XmlElement(name=  "libro")
	public ArrayList<Libro> getLibros() {
		return libros;
	}
	/**
	 * @param libros the libros to set
	 */
	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}	
	
}
