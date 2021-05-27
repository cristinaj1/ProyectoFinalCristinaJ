package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the vehiculos database table.
 * 
 */
@Entity
@Table(name = "vehiculos")
@NamedQuery(name = "Vehiculos.findAll", query = "SELECT v FROM Vehiculos v")
public class Vehiculos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codvehiculo;

	@Temporal(TemporalType.DATE)
	private Date fechaitv;

	@Lob
	private String fichatecnica;

	private String matricula;

	private String modelo;

	private double pesomax;

	private double tamanoalto;

	private double tamanoancho;

	/// Relación bidireccional uno a muchos a Contrato

	// Un vehiculo puede aparecer en un distintos contratos

	// Este atributo representa la lista de vehiculos que aparecen en contrato

	// mappedBy indica el atributo asociado en la clase Contrato

	@OneToMany(mappedBy = "vehiculo")
	private List<Contrato> contratosVehiculos;

	// Asociación bidireccional entre Vehiculos y Pack

	// Un vehiculo lleva un tipo de pack y un tipo de pack es transportado en un
	// vehiculo

	// Con este anotación y este atributo se puede saber qué vehiculo es furgoneta

	// Esto se indica con @JoinColumn y el atributo de la tabla con el que obtener
	// los datos de la tabla Pack

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codpack")
	private Pack pack;

	// Relación bidireccional uno a muchos con Trabajadores

	// Un vehiculo puede ser conducido por el mismo trabajador o distinto muchas
	// veces

	// Esto se indica con @JoinColumn y el atributo de la tabla con el que obtener
	// los datos de la tabla Trabajadores
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codtrabajador")
	private Trabajadores trabajadore;

	public Vehiculos() {
	}

	public int getCodvehiculo() {
		return this.codvehiculo;
	}

	public void setCodvehiculo(int codvehiculo) {
		this.codvehiculo = codvehiculo;
	}

	public Date getFechaitv() {
		return this.fechaitv;
	}

	public void setFechaitv(Date fechaitv) {
		this.fechaitv = fechaitv;
	}

	public String getFichatecnica() {
		return this.fichatecnica;
	}

	public void setFichatecnica(String fichatecnica) {
		this.fichatecnica = fichatecnica;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPesomax() {
		return this.pesomax;
	}

	public void setPesomax(double pesomax) {
		this.pesomax = pesomax;
	}

	public double getTamanoalto() {
		return this.tamanoalto;
	}

	public void setTamanoalto(double tamanoalto) {
		this.tamanoalto = tamanoalto;
	}

	public double getTamanoancho() {
		return this.tamanoancho;
	}

	public void setTamanoancho(double tamanoancho) {
		this.tamanoancho = tamanoancho;
	}

	public List<Contrato> getContratosVehiculos() {
		return this.contratosVehiculos;
	}

	public void setContratosVehiculos(List<Contrato> contratosVehiculos) {
		this.contratosVehiculos = contratosVehiculos;
	}

	public Contrato addContratosVehiculo(Contrato contratosVehiculo) {
		getContratosVehiculos().add(contratosVehiculo);
		contratosVehiculo.setVehiculo(this);

		return contratosVehiculo;
	}

	public Contrato removeContratosVehiculo(Contrato contratosVehiculo) {
		getContratosVehiculos().remove(contratosVehiculo);
		contratosVehiculo.setVehiculo(null);

		return contratosVehiculo;
	}

	public Pack getPack() {
		return this.pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	public Trabajadores getTrabajadore() {
		return this.trabajadore;
	}

	public void setTrabajadore(Trabajadores trabajadore) {
		this.trabajadore = trabajadore;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vehiculos [codvehiculo=");
		builder.append(codvehiculo);
		builder.append(", fechaitv=");
		builder.append(fechaitv);
		builder.append(", fichatecnica=");
		builder.append(fichatecnica);
		builder.append(", matricula=");
		builder.append(matricula);
		builder.append(", modelo=");
		builder.append(modelo);
		builder.append(", pesomax=");
		builder.append(pesomax);
		builder.append(", tamanoalto=");
		builder.append(tamanoalto);
		builder.append(", tamanoancho=");
		builder.append(tamanoancho);
		builder.append(", contratosVehiculos=");
		builder.append(contratos());
		builder.append(", pack=");
		builder.append(pack.getCodpack());
		builder.append(", trabajadore=");
		builder.append(trabajadore.getCodtrabajador());
		builder.append("]");
		return builder.toString();
	}

	//Para que aparezca la lista correctamente
	private String contratos() {
		String texto="";
		if (!contratosVehiculos.isEmpty()) {
			for (Contrato p : contratosVehiculos) {
				texto += String.valueOf(p.getCodcontrato()) + ", ";

			}
			return texto;
		}
		return "";
	}
}