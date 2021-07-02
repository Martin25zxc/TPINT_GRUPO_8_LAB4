package com.integrador.model;

import java.util.Date;

public class Cliente {
	private int clienteId;
	private Date fechaNacimiento;
	private String nombre;
	private String apellido;
	private String nacionalidad;
	private String direccion;
	private String localidad;
	private String provincia;
	private String email;
	private String nroDocumento;
	private String telefono1;
	private String telefono2;
	private int usuarioID;
	private boolean activo;
	
	public Cliente(Date fechaNacimiento, String nombre, String apellido, String nacionalidad, String direccion,
			String localidad, String provincia, String email, String nroDocumento, String telefono1, String telefono2,
			int usuarioID, boolean activo) {
		
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.email = email;
		this.nroDocumento = nroDocumento;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.activo = activo;
		this.usuarioID = usuarioID;
	}
	
	public Cliente(String nombre) {
		this.nombre = nombre;
	}
	
	public Cliente() {
	}
	
	public int getClienteId(){
		return clienteId;
	}
	
	public Date getFechaNacimiento(){
		return fechaNacimiento;
	}

	public void setFechaNacimiento(java.util.Date FechaNacimiento){
		this.fechaNacimiento=FechaNacimiento;
	}

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String Nombre){
		this.nombre=Nombre;
	}

	public String getApellido(){
		return apellido;
	}

	public void setApellido(String Apellido){
		this.apellido=Apellido;
	}

	public String getNacionalidad(){
		return nacionalidad;
	}

	public void setNacionalidad(String Nacionalidad){
		this.nacionalidad=Nacionalidad;
	}

	public String getDireccion(){
		return direccion;
	}

	public void setDireccion(String Direccion){
		this.direccion=Direccion;
	}

	public String getLocalidad(){
		return localidad;
	}

	public void setLocalidad(String Localidad){
		this.localidad=Localidad;
	}

	public String getProvincia(){
		return provincia;
	}

	public void setProvincia(String Provincia){
		this.provincia=Provincia;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String Email){
		this.email=Email;
	}

	public String getNrodocumento(){
		return nroDocumento;
	}

	public void setNrodocumento(String NroDocumento){
		this.nroDocumento=NroDocumento;
	}

	public String getTelefono1(){
		return telefono1;
	}

	public void setTelefono1(String Telefono1){
		this.telefono1=Telefono1;
	}

	public String getTelefono2(){
		return telefono2;
	}

	public void setTelefono2(String Telefono2){
		this.telefono2=Telefono2;
	}

	public int getUsuarioid(){
		return usuarioID;
	}

	public void setUsuarioid(int UsuarioID){
		this.usuarioID=UsuarioID;
	}

	public boolean isActive() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
