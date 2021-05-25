package aplicaciones;

import java.sql.Date;
import java.time.LocalDate;

import controladores.ControladorTrabajadores;
import entidades.Trabajadores;



public class PruebaControladorTrabajadores {
	public static void main(String[] args) {

		Date fechaIni = new Date(116,8,8);
		Date fechfincontrato= new Date(226,5,5);
		ControladorTrabajadores cc = new ControladorTrabajadores();	

		// Se imprimen todos los registros que haya en la tabla cliente
		imprimirEntidades(cc);

		Trabajadores t4 = new Trabajadores();
		t4.setNombre("Manuel");
		t4.setCodtrabajador(4);
		t4.setDni("08794682I");
		t4.setTelf("789456321");
		t4.setNumss("589-27-8945");
		t4.setApe1("Dominguez");
		t4.setApe2("Fernández");
		t4.setFechaini(fechaIni);
		t4.setFechfincontrato(fechfincontrato);
		t4.setTipocontrato("I");
		t4.setNomcontrato("Indefinido");

		cc.crearTrabajadores(t4);

		
		cc.borrarTrabajadores(cc.findByPK(20));
		
		System.out.println("Entidades en Trabajadores");
		imprimirEntidades(cc);
		
		System.out.println("---------BUSCAMOS AL TRABAJADOR CON PK 1----------");
		Trabajadores oliver = cc.findByPK(1);
		System.out.println("Nombre " + oliver.getNombre());

	}

	
	private static void imprimirEntidades(ControladorTrabajadores cc) {
		System.out.println("ENTIDADES EN LA BASE DE DATOS ---------------");
		// Al obtener un cliente, se obtiene también la tarjeta asociada gracias
		// a la bidireccionalidad
		for (Trabajadores c : cc.findAll()) {
			System.out.println(c);
		}
	}

}
