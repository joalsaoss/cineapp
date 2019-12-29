/**
 * 
 */
package net.itinajero.app.service;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Noticia;

/**
 * @author Jose Alvaro
 *
 */
@Service
public class NoticiaServiceImpl implements INoticiasService {
	
	/**
	 * 
	 */
	public NoticiaServiceImpl() {
		System.out.println("Creando una instancia de la clase NoticiasServiceImpl");
	}
	
	/* (non-Javadoc)
	 * @see net.itinajero.app.service.INoticiasService#guardar(net.itinajero.app.model.Noticia)
	 */
	@Override
	public void guardar(Noticia noticia) {
		System.out.println("Guadando el objeto " + noticia + " en la base de datos.");
	}

}
