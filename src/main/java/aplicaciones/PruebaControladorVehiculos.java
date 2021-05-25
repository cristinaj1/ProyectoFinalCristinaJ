package aplicaciones;

import java.util.Date;

import controladores.ControladorPack;
import controladores.ControladorTrabajadores;
import controladores.ControladorVehiculos;
import entidades.Vehiculos;

public class PruebaControladorVehiculos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date fecha = new Date(219, 7, 15);

		ControladorVehiculos cv = new ControladorVehiculos();
		ControladorPack cp = new ControladorPack();
		ControladorTrabajadores ct = new ControladorTrabajadores();

		// Se imprimen todos los registros que haya en la tabla cliente
		imprimirEntidades(cv);

		Vehiculos t4 = new Vehiculos();
		t4.setCodvehiculo(9);
		t4.setFechaitv(fecha);
		t4.setFichatecnica("Está en perfecto estado");
		t4.setMatricula("4578ADC");
		t4.setModelo("Seat");
		t4.setPack(cp.findByPK(1));
		t4.setPesomax(200);
		t4.setTamanoalto(24);
		t4.setTamanoancho(45);
		t4.setTrabajadore(ct.findByPK(1));

		cv.crearVehiculos(t4);
		imprimirEntidades(cv);
		System.out.println("----Con el vehiculo borrado-------------");
		cv.borrarVehiculos(t4);
		

		
		// Se persiste el cliente, una vez la tarjeta está en la BD
		System.out.println("Entidades en Vehiculos");
		imprimirEntidades(cv);

		System.out.println("---------BUSCAMOS AL VEHICULO CON PK 1----------");
		Vehiculos persona = cv.findByPK(1);
		System.out.println("Nombre " + persona.getModelo());
	}

	//Imprime las entidades de la bbdd 
	private static void imprimirEntidades(ControladorVehiculos cv) {
		System.out.println("ENTIDADES EN LA BASE DE DATOS ---------------");
		// Al obtener un cliente, se obtiene también la tarjeta asociada gracias
		// a la bidireccionalidad
		for (Vehiculos c : cv.findAll()) {
			System.out.println(c);
		}
	}

}
