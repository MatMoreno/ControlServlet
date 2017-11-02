package modelo;

import java.time.LocalDate;

public class Usuario {
    private int id;
	private String usuario;
	private String clave;

	

	public Usuario(int id,String usuario, String clave ) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.clave = clave;
		
		
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}



	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

}