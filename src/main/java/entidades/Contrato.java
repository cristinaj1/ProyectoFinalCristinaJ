package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the contrato database table.
 * 
 */
@Entity
@Table(name="contrato")
@NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c")
public class Contrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codcontrato;

	// Relación bidireccional muchos a uno a Pack

	// Muchos contratos pueden contratar un mismo pack

	// Este atributo representa el pack involucrado en este contrato

	// La tabla Pack es la propietaria de la relación al tener la clave ajena

	// Esto se indica con @JoinColumn y el atributo de la tabla con el que obtener
	// los datos de la tabla pack

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codpack")
	private Pack pack;

	// Relación bidireccional muchos a uno a Personas

	// Muchos contratos pueden ser contratados por una misma persona

	// Este atributo representa la persona involucrado en este contrato

	// La tabla Persona es la propietaria de la relación al tener la clave ajena

	// Esto se indica con @JoinColumn y el atributo de la tabla con el que obtener
	// los datos de la tabla vehiculo

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codusuario")
	private Personas persona;

	// Relación bidireccional muchos a uno a Vehiculos

	// En mucho contratos pueden aparecer contratado un mismo vehiculo

	// Este atributo representa el vehiculo involucrado en este contrato

	// La tabla Vehiculos es la propietaria de la relación al tener la clave ajena

	// Esto se indica con @JoinColumn y el atributo de la tabla con el que obtener
	// los datos de la tabla vehiculo

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codvehiculo")
	private Vehiculos vehiculo;

	public Contrato() {
	}

	public int getCodcontrato() {
		return this.codcontrato;
	}

	public void setCodcontrato(int codcontrato) {
		this.codcontrato = codcontrato;
	}

	public Pack getPack() {
		return this.pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	public Personas getPersona() {
		return this.persona;
	}

	public void setPersona(Personas persona) {
		this.persona = persona;
	}

	public Vehiculos getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculos vehiculo) {
		this.vehiculo = vehiculo;
	}

	@Override
	public String toString() {
		return "Contrato [codcontrato=" + codcontrato + ", pack=" + pack + ", persona=" + persona + ", vehiculo="
				+ vehiculo + "]";
	}

}