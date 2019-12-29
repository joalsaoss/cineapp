/**
 * 
 */
package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IPeliculaService;
import net.itinajero.app.util.Utileria;

/**
 * @author Jose Alvaro
 *
 */
@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

	@Autowired
	private IPeliculaService servicePelicula;

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Pelicula> lista = servicePelicula.buscarTodas();
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping("/create")
	public String crear(@ModelAttribute Pelicula pelicula) {
		return "peliculas/formPelicula";
	}

	/**
	 * 
	 * @param pelicula
	 * @param result
	 * @param attributes
	 * @param multipart
	 * @param request
	 * @return
	 */
	@PostMapping("/save")
	public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result,
			RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multipart,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "peliculas/formPelicula";
		}

		if (!multipart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multipart, request);
			pelicula.setImagen(nombreImagen);
		}
		servicePelicula.insertar(pelicula);
		attributes.addFlashAttribute("msg", "Registro guardado");
		return "redirect:/peliculas/index";
	}

	/**
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(dateFormat, false));
	}
}
