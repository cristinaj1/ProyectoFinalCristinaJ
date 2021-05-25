package aplicaciones;

import controladores.ControladorPersonas;
import controladores.ControladorVehiculos;
import entidades.Personas;

public class PruebaControladorPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ControladorPersonas cp = new ControladorPersonas();
		
		// Se imprimen todos los registros que haya en la tabla cliente
		imprimirEntidades(cp);

		Personas t4 = new Personas();
		t4.setCodusuario(1);
		t4.setNombre("Antonia");
		t4.setApe1("Kelvin");
		t4.setApe2("Montoya");
		t4.setDestino("Calle Pepe Carrasco nº 26, 1ºF");
		t4.setInicio("Calle Monasterio nº5, 2ºC");
		t4.setMetodopago("T");
		t4.setTelf("789456123");
		t4.setDni("08794615L");

		cp.crearPersonas(t4);

		// Se persiste el cliente, una vez la tarjeta está en la BD
		System.out.println("Entidades en Trabajadores");
		imprimirEntidades(cp);

		System.out.println("---------BUSCAMOS A LA PERSONA CON PK 1----------");
		Personas persona = cp.findByPK(1);
		System.out.println("Nombre " + persona.getNombre());
	}

	private static void imprimirEntidades(ControladorPersonas cc) {
		System.out.println("ENTIDADES EN LA BASE DE DATOS ---------------");
		// Al obtener un cliente, se obtiene también la tarjeta asociada gracias
		// a la bidireccionalidad
		for (Personas c : cc.findAll()) {
			System.out.println(c);
		}
	}


}
