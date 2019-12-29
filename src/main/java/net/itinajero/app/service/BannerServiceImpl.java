/**
 * 
 */
package net.itinajero.app.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Banner;

/**
 * @author Jose Alvaro
 *
 */
@Service
public class BannerServiceImpl implements IBannerService {

	private List<Banner> lista = null;
	
	/**
	 * 
	 */
	public BannerServiceImpl() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			lista = new LinkedList<>();
			
			Banner banner1 = new Banner();
			banner1.setId(1);
			banner1.setTitulo("Slide 1");
			banner1.setFecha(formatter.parse("19-11-2019"));
			banner1.setArchivo("slide1");
			banner1.setStatus("Activo");
			
			Banner banner2 = new Banner();
			banner2.setId(2);
			banner2.setTitulo("Slide 2");
			banner2.setFecha(formatter.parse("19-11-2019"));
			banner2.setArchivo("slide2");
			banner2.setStatus("Activo");

			Banner banner3 = new Banner();
			banner3.setId(3);
			banner3.setTitulo("Slide 3");
			banner3.setFecha(formatter.parse("19-11-2019"));
			banner3.setArchivo("slide3");
			banner3.setStatus("Activo");
			
			Banner banner4 = new Banner();
			banner4.setId(4);
			banner4.setTitulo("Slide 4");
			banner4.setFecha(formatter.parse("19-11-2019"));
			banner4.setArchivo("slide4");
			banner4.setStatus("Activo");
			
			Banner banner5 = new Banner();
			banner5.setId(5);
			banner5.setTitulo("Slide 5");
			banner5.setFecha(formatter.parse("19-11-2019"));
			banner5.setArchivo("slide5");
			banner5.setStatus("Activo");
			
			Banner banner6 = new Banner();
			banner6.setId(6);
			banner6.setTitulo("Slide 6");
			banner6.setFecha(formatter.parse("19-11-2019"));
			banner6.setArchivo("slide6");
			banner6.setStatus("Activo");
			
			Banner banner7 = new Banner();
			banner7.setId(7);
			banner7.setTitulo("Slide 7");
			banner7.setFecha(formatter.parse("19-11-2019"));
			banner7.setArchivo("slide7");
			banner7.setStatus("Activo");
			
			lista.add(banner1);
			lista.add(banner2);
			lista.add(banner3);
			lista.add(banner4);
			lista.add(banner5);
			lista.add(banner6);
			lista.add(banner7);
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.itinajero.app.service.IBannerService#insertar(net.itinajero.app.model.Banner)
	 */
	@Override
	public void insertar(Banner banner) {
		lista.add(banner);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.itinajero.app.service.IBannerService#buscarTodos()
	 */
	@Override
	public List<Banner> buscarTodos() {
		return lista;
	}

}
