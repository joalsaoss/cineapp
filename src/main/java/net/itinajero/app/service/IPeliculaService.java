/**
 * 
 */
package net.itinajero.app.service;

import java.util.List;

import net.itinajero.app.model.Pelicula;

/**
 * @author Jose Alvaro
 *
 */
public interface IPeliculaService {
	
	/**
	 * 
	 * @return
	 */
	List<Pelicula> buscarTodas();
	
	/**
	 * 
	 * @param pelicula
	 */
	void insertar(Pelicula pelicula);
	
	/**
	 * 
	 * @param idPelicula
	 * @return
	 */
	Pelicula buscarPorId(int idPelicula); 
}
