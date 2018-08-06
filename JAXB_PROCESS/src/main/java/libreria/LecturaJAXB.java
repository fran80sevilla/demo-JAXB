package libreria;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class LecturaJAXB {

	public static String inicialesAutor(String isbn, String titulo, String nombreAutor) {
		String array[];
		String iniciales = "";
		array = nombreAutor.split(" ");
		//System.out.println(array.length);
		for (int i = 0; i < array.length; i++) {
			iniciales += array[i].substring(0, 1).toUpperCase() + ".";
		}
		
		if (array.length <= 1) {

			iniciales = "no hay iniciales que valga para " + 
			array[0].substring(0, 1).toUpperCase() + 
			array[0].substring(1, array[0].length()).toLowerCase();
			
		} else {
			iniciales = iniciales.substring(0, iniciales.length() - 1);
		}
		return "ISBN:" + isbn + " ,titulo: " + titulo + " ,autor: " + nombreAutor + ", iniciales: " + iniciales;
	}

	public static void main(String[] args) {

		// creamos los objetos necesarios para leer el documento
		// primero definimos el contexto principal
		// me pide la clase que representa la totalidad del XML(root element), tiene excepcion
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Libreria.class);

			/* creamos un objeto que permita pasar de XML a JAVA, es el Unmarshaller */
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			
			/* invocamos al metodo unmarshall, recibe un XML a partir de objeto File */
			// unmarshaller.unmarshal(new File("libreria.xlm"));

			File file = new File("libreria.xml");
			// Asignamos a Libreria toda la informacion que nos devuelve el xml - unmarshaller devuelve Object
			Libreria libreria = (Libreria) unmarshaller.unmarshal(file);

			System.out.println("Nombre de la librería: " + libreria.getNombre());
			List<Libro> libros = libreria.getLibros();

			System.out.println("Numero de Libros: " + libros.size());

			Integer numero = 0;
			for (Libro lib : libros) {
				// mostramos solo las iniciales del autor a partir del 4º libro
				if (numero > 2) {
					if (numero == 3) {
						System.out.println();
						System.out.println("***** Autores con Iniciales *****");
						System.out.println();
					}
					System.out.println( inicialesAutor(lib.getIsbn(), lib.getTitulo(), lib.getAutor()) ) ;
					// sin iniciales
				} else
					System.out.println("ISBN:" + lib.getIsbn() + " ,titulo: " + lib.getTitulo() + " ,autor: "
							+ lib.getAutor());
				numero++;
			}

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
