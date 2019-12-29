package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Banner;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IBannerService;
import net.itinajero.app.service.IPeliculaService;
import net.itinajero.app.util.Utileria;

@Controller
public class HomeController {
	
	@Autowired
	private IBannerService serviceBanner;

	@Autowired
	private IPeliculaService servicePeliculas;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model) {
		// System.out.println("Buscando para la fecha:" + fecha);
		List<String> listaFechas = Utileria.getNextDays(4);

		List<Pelicula> peliculas = getLista();
		List<Banner> banners = getBanners();
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("banners", banners);
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {

		List<String> listaFechas = Utileria.getNextDays(4);

		List<Pelicula> peliculas = getLista();
		List<Banner> banners = getBanners();
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("banners", banners);
		return "home";
	}

	@RequestMapping(value = "/detail/{id}/{fecha}", method = RequestMethod.GET)
	public String mostrarDetallePath(Model model,
			@PathVariable("id") int idPelicula,
			@PathVariable("fecha") String fecha) {
		System.out.println("idPelicula:" + idPelicula);
		System.out.println("Fecha:" + fecha);

		model.addAttribute("pelicula",
				servicePeliculas.buscarPorId(idPelicula));

		return "detalle";
	}

	/**
	 * 
	 * @param model
	 * @param idPelicula
	 * @param fecha
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String mostrarDetalle(Model model,
			@RequestParam("idMovie") int idPelicula,
			@RequestParam("fecha") String fecha) {

		System.out.println("idPelicula:" + idPelicula);
		System.out.println("Fecha:" + fecha);

		String tituloPelicula = "Rapidos y furuiosos 8";
		int duracion = 136;
		double precioEntrada = 50;
		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio", precioEntrada);
		return "detalle";
	}

	/**
	 * 
	 * @return
	 */
	private List<Pelicula> getLista() {
		return servicePeliculas.buscarTodas();
	}
	
	/**
	 * 
	 * @return
	 */
	private List<Banner> getBanners() {
		return serviceBanner.buscarTodos();
	}
}
