package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the personas database table.
 * 
 */
@Entity
@Table(name="personas")
@NamedQuery(name = "Personas.findAll", query = "SELECT p FROM Personas p")
public class Personas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codusuario;

	private String ape1;

	private String ape2;

	private String destino;

	private String dni;

	private String inicio;

	private String metodopago;

	private String nombre;

	private String telf;

	// Relación bidireccional uno a muchos a Contrato

	// Una persona puede hacer muchos contratos

	// Este atributo representa la lista de contratos que hace una persona

	// mappedBy indica el atributo asociado en la clase Contrato

	@OneToMany(mappedBy = "persona")
	private List<Contrato> contratosPersonas;

	public Personas() {
	}

	public int getCodusuario() {
		return this.codusuario;
	}

	public void setCodusuario(int codusuario) {
		this.codusuario = codusuario;
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

	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getInicio() {
		return this.inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getMetodopago() {
		return this.metodopago;
	}

	public void setMetodopago(String metodopago) {
		this.metodopago = metodopago;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelf() {
		return this.telf;
	}

	public void setTelf(String telf) {
		this.telf = telf;
	}

	public List<Contrato> getContratosPersonas() {
		return this.contratosPersonas;
	}

	public void setContratosPersonas(List<Contrato> contratosPersonas) {
		this.contratosPersonas = contratosPersonas;
	}

	public Contrato addContratosPersona(Contrato contratosPersona) {
		getContratosPersonas().add(contratosPersona);
		contratosPersona.setPersona(this);

		return contratosPersona;
	}

	public Contrato removeContratosPersona(Contrato contratosPersona) {
		getContratosPersonas().remove(contratosPersona);
		contratosPersona.setPersona(null);

		return contratosPersona;
	}

	@Override
	public String toString() {
		return "Personas [codusuario=" + codusuario + ", ape1=" + ape1 + ", ape2=" + ape2 + ", destino=" + destino
				+ ", dni=" + dni + ", inicio=" + inicio + ", metodopago=" + metodopago + ", nombre=" + nombre
				+ ", telf=" + telf + ", contratosPersonas=" + contratosPersonas + "]";
	}

}