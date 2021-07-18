package com.integrador.model;

import java.time.LocalDate;

public class Cliente {
	private int clienteId;
	private LocalDate fechaNacimiento;
	private LocalDate fechaAlta;
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
	private int usuarioId;
	private boolean activo;
	
	private Usuario usuario;
	
	public Cliente(LocalDate fechaNacimiento, LocalDate fechaAlta, String nombre, String apellido, String nacionalidad, String direccion,
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
		this.usuarioId = usuarioID;
		this.fechaAlta = fechaAlta;
	}
	
	public Cliente(String nombre) {
		this.nombre = nombre;
	}
	
	public Cliente() {
	}
	
	public void setClienteId(int clienteId){
		this.clienteId = clienteId;
	}
	
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int getClienteId(){
		return clienteId;
	}
	
	public LocalDate getFechaNacimiento(){
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate date){
		this.fechaNacimiento=date;
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

	public int getUsuarioId(){
		return usuarioId;
	}

	public void setUsuarioId(int UsuarioID){
		this.usuarioId=UsuarioID;
	}

	public boolean isActive() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public int getUsuarioID() {
		return usuarioId;
	}

	public void setUsuarioID(int usuarioID) {
		this.usuarioId = usuarioID;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "(#"+this.clienteId+") " + this.apellido + ", " + this.nombre + " (" + this.nroDocumento+")";
	}
}
