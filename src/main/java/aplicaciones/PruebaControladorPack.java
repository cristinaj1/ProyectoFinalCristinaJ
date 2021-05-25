package aplicaciones;

import controladores.ControladorContrato;
import controladores.ControladorPack;
import controladores.ControladorPersonas;
import controladores.ControladorVehiculos;
import entidades.Contrato;
import entidades.Pack;

public class PruebaControladorPack {

	public static void main(String[] args) {
		ControladorPack cp = new ControladorPack();
		ControladorPersonas cp2 = new ControladorPersonas();
		ControladorVehiculos cv = new ControladorVehiculos();

		// Se imprimen todos los registros que haya en la tabla cliente
		imprimirEntidades(cp);

		Pack t4 = new Pack();
		t4.setCodpack(4);
		t4.setCodusuario(2);
		t4.setDescriptipo("Contiene 10 cajas de cartón, 50 forros para vidrio y pegatina de frágil");
		t4.setNompack("Familiar");
		t4.setTipopack("F");
		t4.setVehiculoPack(cv.findByPK(2));

		cp.crearPack(t4);

		// Se persiste el cliente, una vez la tarjeta está en la BD
		System.out.println("Entidades en Trabajadores");
		imprimirEntidades(cp);

		System.out.println("---------BUSCAMOS EL PAQUETE CON PK 1----------");
		Pack contrato1 = cp.findByPK(1);
		System.out.println("Nombre " + contrato1.getNompack());
	}

	private static void imprimirEntidades(ControladorPack cp) {
		System.out.println("ENTIDADES EN LA BASE DE DATOS ---------------");
		// Al obtener un cliente, se obtiene también la tarjeta asociada gracias
		// a la bidireccionalidad
		for (Pack c : cp.findAll()) {
			System.out.println(c);
		}
	}

}
