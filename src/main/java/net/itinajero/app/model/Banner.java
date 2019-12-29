/**
 * 
 */
package net.itinajero.app.model;

import java.util.Date;

/**
 * @author Jose Alvaro
 *
 */
public class Banner {
	private int id;
	private String titulo;
	private Date fecha;
	private String archivo;
	private String status;

	/**
	 * 
	 */
	public Banner() {
		this.fecha = new Date();
		this.status = "Activo";
	}

	/**
	 * @param id
	 * @param titulo
	 * @param fecha
	 * @param archivo
	 * @param status
	 */
	public Banner(int id, String titulo, Date fecha, String archivo,
			String status) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.fecha = fecha;
		this.archivo = archivo;
		this.status = status;
	}

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
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the archivo
	 */
	public String getArchivo() {
		return archivo;
	}

	/**
	 * @param archivo
	 *            the archivo to set
	 */
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Banner [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha
				+ ", archivo=" + archivo + ", status=" + status + "]";
	}
}
