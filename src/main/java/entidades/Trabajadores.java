package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the trabajadores database table.
 * 
 */
@Entity
@Table(name = "trabajadores")
@NamedQuery(name = "Trabajadores.findAll", query = "SELECT t FROM Trabajadores t")
public class Trabajadores implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codtrabajador;

	private String ape1;

	private String ape2;

	private String dni;

	@Temporal(TemporalType.DATE)
	private Date fechaini;

	@Temporal(TemporalType.DATE)
	private Date fechfincontrato;

	private String nombre;

	private String nomcontrato;

	private String numss;

	private double sueldo;

	private String telf;

	private String tipocontrato;

	// Relación bidireccional uno a muchos a Vehiculos

	// Un trabajador puede llevar varios coches

	// Este atributo representa la lista de vehiculos que llevan los trabajadores

	// mappedBy indica el atributo asociado en la clase Vehiculos

	@OneToMany(mappedBy = "trabajadore")
	private List<Vehiculos> vehiculosTrabajadores;

	public Trabajadores() {
	}

	public int getCodtrabajador() {
		return this.codtrabajador;
	}

	public void setCodtrabajador(int codtrabajador) {
		this.codtrabajador = codtrabajador;
	}

	public String getApe1() {
		return this.ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return this.ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaini() {
		return this.fechaini;
	}

	public void setFechaini(Date fechaini) {
		this.fechaini = fechaini;
	}

	public Date getFechfincontrato() {
		return this.fechfincontrato;
	}

	public void setFechfincontrato(Date fechfincontrato) {
		this.fechfincontrato = fechfincontrato;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNomcontrato() {
		return this.nomcontrato;
	}

	public void setNomcontrato(String nomcontrato) {
		this.nomcontrato = nomcontrato;
	}

	public String getNumss() {
		return this.numss;
	}

	public void setNumss(String numss) {
		this.numss = numss;
	}

	public double getSueldo() {
		return this.sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public String getTelf() {
		return this.telf;
	}

	public void setTelf(String telf) {
		this.telf = telf;
	}

	public String getTipocontrato() {
		return this.tipocontrato;
	}

	public void setTipocontrato(String tipocontrato) {
		this.tipocontrato = tipocontrato;
	}

	public List<Vehiculos> getVehiculosTrabajadores() {
		return this.vehiculosTrabajadores;
	}

	public void setVehiculosTrabajadores(List<Vehiculos> vehiculosTrabajadores) {
		this.vehiculosTrabajadores = vehiculosTrabajadores;
	}

	public Vehiculos addVehiculosTrabajadore(Vehiculos vehiculosTrabajadore) {
		getVehiculosTrabajadores().add(vehiculosTrabajadore);
		vehiculosTrabajadore.setTrabajadore(this);

		return vehiculosTrabajadore;
	}

	public Vehiculos removeVehiculosTrabajadore(Vehiculos vehiculosTrabajadore) {
		getVehiculosTrabajadores().remove(vehiculosTrabajadore);
		vehiculosTrabajadore.setTrabajadore(null);

		return vehiculosTrabajadore;
	}

	@Override
	public String toString() {
		return "Trabajadores [codtrabajador=" + codtrabajador + ", ape1=" + ape1 + ", ape2=" + ape2 + ", dni=" + dni
				+ ", fechaini=" + fechaini + ", fechfincontrato=" + fechfincontrato + ", nombre=" + nombre
				+ ", nomcontrato=" + nomcontrato + ", numss=" + numss + ", sueldo=" + sueldo + ", telf=" + telf
				+ ", tipocontrato=" + tipocontrato + "]";
	}

}