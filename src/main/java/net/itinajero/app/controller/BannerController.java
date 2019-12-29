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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Banner;
import net.itinajero.app.service.IBannerService;
import net.itinajero.app.util.Utileria;

/**
 * @author Jose Alvaro
 *
 */
@Controller
@RequestMapping("/banners/")
public class BannerController {

	@Autowired
	private IBannerService bannerService;

	/**
	 * 
	 * @return
	 */
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Banner> lista = bannerService.buscarTodos();
		model.addAttribute("banners", lista);
		return "banners/listBanners";
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping("/create")
	public String crear() {
		return "banners/formBanner";
	}

	/**
	 * 
	 * @return
	 */
	@PostMapping("/save")
	public String guardar(Banner banner, BindingResult result,
			RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multipart,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "banners/formBanner";
		}

		if (!multipart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multipart, request);
			banner.setArchivo(nombreImagen);
		}
		bannerService.insertar(banner);
		attributes.addFlashAttribute("msg", "Registro guardado");

		return "redirect:/banners/index";
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
