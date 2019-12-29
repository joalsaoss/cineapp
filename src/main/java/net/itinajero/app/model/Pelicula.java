package net.itinajero.app.model;

import java.util.Date;

/**
 * 
 * @author Jose Alvaro
 *
 */
public class Pelicula {

	private int id;
	private String titulo;
	private int duracion;
	private String clasificacion;
	private String genero;
	private String imagen = "cinema.png"; // default
	private Date fechaEstreno;
	private String estatus = "Activa";

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * @return the duracion
	 */
	public int getDuracion() {
		return duracion;
	}
	
	/**
	 * @param duracion
	 *            the duracion to set
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	/**
	 * @return the clasificacion
	 */
	public String getClasificacion() {
		return clasificacion;
	}
	
	/**
	 * @param clasificacion
	 *            the clasificacion to set
	 */
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	
	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}
	
	/**
	 * @param imagen
	 *            the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	/**
	 * @return the fechaEstreno
	 */
	public Date getFechaEstreno() {
		return fechaEstreno;
	}
	
	/**
	 * @param fechaEstreno
	 *            the fechaEstreno to set
	 */
	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	
	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}
	
	/**
	 * @param estatus
	 *            the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}
	
	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", duracion="
				+ duracion + ", clasificacion=" + clasificacion + ", imagen="
				+ imagen + ", fechaEstreno=" + fechaEstreno + ", estatus="
				+ estatus + "]";
	}
}
