package utn.frba.losjavaleros.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import utn.frba.losjavaleros.model.CaracteristicaCompleta;
import utn.frba.losjavaleros.model.Foto;
import utn.frba.losjavaleros.model.Mascota;
import utn.frba.losjavaleros.model.MascotaEstadoEnum;
import utn.frba.losjavaleros.model.Sexo;
import utn.frba.losjavaleros.model.Usuario;

public class MascotaDto {

	private int id;
	private Usuario duenio;
	private List<CaracteristicaCompleta> caracteristicas = new ArrayList<CaracteristicaCompleta>();
	private String chapita;
	private String tipo;
	private String nombre;
	private String apodo;
	private Integer edad;
	private Sexo sexo;
	private String descripcion;
	private List<Foto> fotos;
	private MascotaEstadoEnum estado;

	public MascotaDto(Mascota mascota) {
		this.id = mascota.getId();
		this.duenio = mascota.getDuenio();
		this.caracteristicas = mascota.getCaracteristicas();
		this.chapita = mascota.getChapita();
		this.tipo = mascota.getTipo();
		this.nombre = mascota.getNombre();
		this.apodo = mascota.getApodo();
		this.edad = mascota.getEdad();
		this.sexo = mascota.getSexo();
		this.descripcion = mascota.getDescripcion();
		this.fotos = mascota.getFotos();
		this.estado = mascota.getEstado();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getDuenio() {
		return duenio;
	}

	public void setDuenio(Usuario duenio) {
		this.duenio = duenio;
	}

	public List<CaracteristicaCompleta> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<CaracteristicaCompleta> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getChapita() {
		return chapita;
	}

	public void setChapita(String chapita) {
		this.chapita = chapita;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public MascotaEstadoEnum getEstado() {
		return estado;
	}

	public void setEstado(MascotaEstadoEnum estado) {
		this.estado = estado;
	}

	

}

