/**
 * 
 */
package net.itinajero.app.service;

import java.util.List;

import net.itinajero.app.model.Banner;

/**
 * @author Jose Alvaro
 *
 */
public interface IBannerService {
	
	/**
	 * 
	 * @param banner
	 */
	void insertar(Banner banner);
	
	/**
	 * 
	 * @return
	 */
	List<Banner> buscarTodos();
}
