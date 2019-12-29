package net.itinajero.app.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {

	/**
	 * Metodo que regresa una Lista de Strings con las fechas siguientes, segun el parametro count
	 * 
	 * @param count
	 * @return
	 */
	public static List<String> getNextDays(int count) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		// Today's Date
		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count); // Next N days from now
		Date endDate = cal.getTime();

		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(start);
		List<String> nextDays = new ArrayList<String>();
		while (!gcal.getTime().after(endDate)) {
			Date d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			nextDays.add(sdf.format(d));
		}
		return nextDays;
	}

	/**
	 * 
	 * @param multipart
	 * @param request
	 * @return
	 */
	public static String guardarImagen(MultipartFile multipart,
			HttpServletRequest request) {
		String nombreOriginal = multipart.getOriginalFilename();
		nombreOriginal = nombreOriginal.replace(" ", "-");
		String nombreFinal = randomAlphaNumeric(8) + nombreOriginal;
		String rutaFinal = request.getServletContext()
				.getRealPath("/resources/images/");

		try {
			File imageFile = new File(rutaFinal, nombreFinal);
			multipart.transferTo(imageFile);
			return nombreFinal;
		} catch (IOException e) {
			System.out.println("ERROR:" + e.getMessage());
			return null;
		}
	}

	/**
	 * 
	 * @param count
	 * @return
	 */
	public static String randomAlphaNumeric(int count) {
		String chars_upp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();

		while (count-- != 0) {
			int chars_num = (int) (Math.random() * chars_upp.length());
			builder.append(chars_upp.charAt(chars_num));
		}
		return builder.toString();
	}
}
