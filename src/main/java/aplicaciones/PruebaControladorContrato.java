package aplicaciones;

import java.sql.Date;

import controladores.ControladorContrato;
import controladores.ControladorPack;
import controladores.ControladorPersonas;
import controladores.ControladorTrabajadores;
import controladores.ControladorVehiculos;
import entidades.Contrato;
import entidades.Trabajadores;

public class PruebaControladorContrato {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ControladorContrato cc = new ControladorContrato();
		ControladorPack cp = new ControladorPack();
		ControladorPersonas cp2 = new ControladorPersonas();
		ControladorVehiculos cv = new ControladorVehiculos();
		
		
		// Se imprimen todos los registros que haya en la tabla cliente
		imprimirEntidades(cc);

		Contrato t4 = new Contrato();
		t4.setCodcontrato(3);
		t4.setPack(cp.findByPK(1));
		t4.setPersona(cp2.findByPK(1));
		t4.setVehiculo(cv.findByPK(1));

		cc.crearContrato(t4);

		// Se persiste el cliente, una vez la tarjeta está en la BD
		System.out.println("Entidades en Controles");
		imprimirEntidades(cc);

		System.out.println("---------BUSCAMOS AL CONTRATO CON PK 1----------");
		Contrato contrato1 = cc.findByPK(1);
		System.out.println("Nombre " + contrato1.getCodcontrato());
	}

	private static void imprimirEntidades(ControladorContrato cc) {
		System.out.println("ENTIDADES EN LA BASE DE DATOS ---------------");
		// Al obtener un cliente, se obtiene también la tarjeta asociada gracias
		// a la bidireccionalidad
		for (Contrato c : cc.findAll()) {
			System.out.println(c);
		}
	}

}
