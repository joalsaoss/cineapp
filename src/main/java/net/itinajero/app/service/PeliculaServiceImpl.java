/**
 * 
 */
package net.itinajero.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Pelicula;

/**
 * @author Jose Alvaro
 *
 */

@Service
public class PeliculaServiceImpl implements IPeliculaService {

	private List<Pelicula> lista = null;

	public PeliculaServiceImpl() {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		try {
			lista = new LinkedList<>();

			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Rangers");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("27-10-2019"));
			pelicula1.setImagen("estreno8.png");

			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("La bella y la bestia");
			pelicula2.setDuracion(132);
			pelicula2.setClasificacion("A");
			pelicula2.setGenero("Infantil");
			pelicula2.setFechaEstreno(formatter.parse("27-10-2019"));
			pelicula2.setImagen("bella.png");

			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Contratiempo");
			pelicula3.setDuracion(106);
			pelicula3.setClasificacion("B");
			pelicula3.setGenero("Thriller");
			pelicula3.setFechaEstreno(formatter.parse("27-10-2019"));
			pelicula3.setImagen("contratiempo.png");

			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("Kong");
			pelicula4.setDuracion(106);
			pelicula4.setClasificacion("B");
			pelicula4.setGenero("Aventura");
			pelicula4.setFechaEstreno(formatter.parse("27-10-2019"));
			pelicula4.setImagen("kong.png");
			pelicula4.setEstatus("Inactiva");

			Pelicula pelicula5 = new Pelicula();
			pelicula5.setId(5);
			pelicula5.setTitulo("Life: Vida Inteligente");
			pelicula5.setDuracion(104);
			pelicula5.setClasificacion("B");
			pelicula5.setGenero("Drama");
			pelicula5.setFechaEstreno(formatter.parse("27-10-2019"));
			pelicula5.setImagen("estreno5.png");
			pelicula5.setEstatus("Activa");

			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);
			lista.add(pelicula5);

		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.itinajero.app.service.IPeliculaService#buscarTodas()
	 */
	@Override
	public List<Pelicula> buscarTodas() {
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.itinajero.app.service.IPeliculaService#buscarPorId(int)
	 */
	@Override
	public Pelicula buscarPorId(int idPelicula) {
		for (Pelicula pelicula : lista) {
			if (pelicula.getId() == idPelicula) {
				return pelicula;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.itinajero.app.service.IPeliculaService#insertar(net.itinajero.app.model.Pelicula)
	 */
	@Override
	public void insertar(Pelicula pelicula) {
		lista.add(pelicula);
	}

}
