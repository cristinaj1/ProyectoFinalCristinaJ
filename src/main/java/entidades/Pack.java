package entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the pack database table.
 * 
 */
@Entity
@Table(name = "pack")
@NamedQuery(name = "Pack.findAll", query = "SELECT p FROM Pack p")
public class Pack implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codpack;

	private int codusuario;

	private String descriptipo;

	private String nompack;

	private String tipopack;

	// Relación bidireccional uno a muchos a Contratos

	// Un pack puede estar contratado muchas veces

	// Este atributo representa la lista de pack que se han contratado

	// mappedBy indica el atributo asociado en la clase Contrato

	@OneToMany(mappedBy = "pack", fetch = FetchType.EAGER)
	private List<Contrato> contratosPack;

	// Relación bidireccional uno a muchos a Vehiculos

	// Un vehículo puede estar alquilado muchas veces

	// Este atributo representa la lista de los vehiculos que han sido contratados

	// mappedBy indica el atributo asociado en la clase Vehiculos

	@OneToOne(mappedBy = "pack", fetch = FetchType.LAZY)
	private Vehiculos vehiculoPack;

	public Pack() {
	}

	public int getCodpack() {
		return this.codpack;
	}

	public void setCodpack(int codpack) {
		this.codpack = codpack;
	}

	public int getCodusuario() {
		return this.codusuario;
	}

	public void setCodusuario(int codusuario) {
		this.codusuario = codusuario;
	}

	public String getDescriptipo() {
		return this.descriptipo;
	}

	public void setDescriptipo(String descriptipo) {
		this.descriptipo = descriptipo;
	}

	public String getNompack() {
		return this.nompack;
	}

	public void setNompack(String nompack) {
		this.nompack = nompack;
	}

	public String getTipopack() {
		return this.tipopack;
	}

	public void setTipopack(String tipopack) {
		this.tipopack = tipopack;
	}

	public List<Contrato> getContratosPack() {
		return this.contratosPack;
	}

	public void setContratosPack(List<Contrato> contratosPack) {
		this.contratosPack = contratosPack;
	}

	public Contrato addContratosPack(Contrato contratosPack) {
		getContratosPack().add(contratosPack);
		contratosPack.setPack(this);

		return contratosPack;
	}

	public Contrato removeContratosPack(Contrato contratosPack) {
		getContratosPack().remove(contratosPack);
		contratosPack.setPack(null);

		return contratosPack;
	}

	public Vehiculos getVehiculoPack() {
		return this.vehiculoPack;
	}

	public void setVehiculoPack(Vehiculos vehiculoPack) {
		this.vehiculoPack = vehiculoPack;
	}

	@Override
	public String toString() {

		String vehiculoPack = (this.vehiculoPack != null) ? this.vehiculoPack.getMatricula() : "";

		StringBuilder builder = new StringBuilder();
		builder.append("Pack [codpack=");
		builder.append(codpack);
		builder.append(", codusuario=");
		builder.append(codusuario);
		builder.append(", descriptipo=");
		builder.append(descriptipo);
		builder.append(", nompack=");
		builder.append(nompack);
		builder.append(", tipopack=");
		builder.append(tipopack);
		builder.append(", contratosPack=");
		builder.append(contratos());
		builder.append(" vehiculoPack=");
		builder.append(vehiculoPack);
		builder.append("]");
		return builder.toString();
	}

	//para que aparezca la lista correctamente
	private String contratos() {
		String texto="";
		if (!contratosPack.isEmpty()) {
			for (Contrato p : contratosPack) {
				texto += String.valueOf(p.getCodcontrato()) + ", ";

			}
			return texto;
		}
		return "";
	}

}