package appfinal;

import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

import controladores.ControladorContrato;
import controladores.ControladorPack;
import controladores.ControladorPersonas;
import controladores.ControladorTrabajadores;
import controladores.ControladorVehiculos;
import entidades.Contrato;
import entidades.Vehiculos;
import entidades.Pack;
import entidades.Personas;
import entidades.Trabajadores;

public class PruebaFinal {
	// Controladores que usaremos
	private static ControladorContrato controladorCont = new ControladorContrato();
	private static ControladorPack controladorPack = new ControladorPack();
	private static ControladorPersonas controladorPer = new ControladorPersonas();
	private static ControladorTrabajadores controladorTrab = new ControladorTrabajadores();
	private static ControladorVehiculos controladorVehi = new ControladorVehiculos();

	// ----------IMPRIMEN TABLAS---------

	// Imprime las entidades de la bbdd vehiculos
	private static void imprimirVehiculos(ControladorVehiculos cv) {
		System.out.println("ENTIDADES EN LA BASE DE DATOS ---------------");
		for (Vehiculos c : cv.findAll()) {
			System.out.println(c);
		}
	}

	// Imprime las entidades de la bbdd contratos
	private static void imprimirContratos(ControladorContrato cc) {
		System.out.println("ENTIDADES EN LA BASE DE DATOS ---------------");
		for (Contrato c : cc.findAll()) {
			System.out.println(c);
		}
	}

	// Imprime las entidades de la bbdd packs
	private static void imprimirPack(ControladorPack cpac) {
		System.out.println("ENTIDADES EN LA BASE DE DATOS ---------------");
		for (Pack c : cpac.findAll()) {
			System.out.println(c);
		}
	}

	// Imprime las entidades de la bbdd personas
	private static void imprimirPersonas(ControladorPersonas cper) {
		System.out.println("ENTIDADES EN LA BASE DE DATOS ---------------");
		for (Personas c : cper.findAll()) {
			System.out.println(c);
		}
	}

	// Imprime las entidades de la bbdd trabajadores
	private static void imprimirTrabajadores(ControladorTrabajadores ct) {
		System.out.println("ENTIDADES EN LA BASE DE DATOS ---------------");
		for (Trabajadores c : ct.findAll()) {
			System.out.println(c);
		}
	}

	// --------ELECCION DE TABLA----------

	// Elegimos la tabla con la que queremos trabajar
	public static void eleccionBD() {
		boolean repetir = true;
		do {
			String eleccionBD = JOptionPane.showInputDialog("Por favor, elija a qué parte desea entrar(solo número):"
					+ "\n1.Contrato\n2.Pack\n3.Persona\n4.Trabajadores\n5.Vehiculos" + "\n6.salir");
			switch (eleccionBD) {
			case "1":
				JOptionPane.showMessageDialog(null, "Ha elegido contrato");
				actosEnBD(eleccionBD);
				break;
			case "2":
				JOptionPane.showMessageDialog(null, "Ha elegido pack");
				actosEnBD(eleccionBD);
				break;
			case "3":
				JOptionPane.showMessageDialog(null, "Ha elegido personas");
				actosEnBD(eleccionBD);
				break;
			case "4":
				JOptionPane.showMessageDialog(null, "Ha elegido trabajadores");
				actosEnBD(eleccionBD);
				break;
			case "5":
				JOptionPane.showMessageDialog(null, "Ha elegido vehiculos");
				actosEnBD(eleccionBD);
				break;
			case "6":
				JOptionPane.showMessageDialog(null, "Usted ha decidido irse, hasta pronto");
				repetir = false;
				break;
			}
		} while (repetir);
	}

	// ----------- OPERACIONES CRUD DE CADA TABLA

	// Crea el elemento en la tabla elegida
	public static void crearEnBDElegida(String eleccionBD) {
		switch (eleccionBD) {
		case "1":// Tabla Contrato

			// Valores con los que trabajamos
			String pkCont = JOptionPane.showInputDialog("Introduzca pk del contrato nuevo");
			String pkPack = JOptionPane.showInputDialog("Introduzca pk del pack con el que quiere que se una");
			String pkPersona = JOptionPane.showInputDialog("Introduzca pk de la persona con el que quiere que se una");
			String pkVehiculo = JOptionPane.showInputDialog("Introduzca pk del vehiculo con el que quiere que se una");

			// Contrato nuevo
			Contrato t4 = new Contrato();
			t4.setCodcontrato(Integer.parseInt(pkCont));
			t4.setPack(controladorPack.findByPK(Integer.parseInt(pkPack)));
			t4.setPersona(controladorPer.findByPK(Integer.parseInt(pkPersona)));
			t4.setVehiculo(controladorVehi.findByPK(Integer.parseInt(pkVehiculo)));
			controladorCont.crearContrato(t4);

			// Aparece la tabla completa
			JOptionPane.showMessageDialog(null, "Ahora mismo esta es la tabla actualizada(Aparecerá por Consola)");
			imprimirContratos(controladorCont);
			break;

		case "2":// Tabla Pack

			// Valores con los que trabajamos
			String nPack = JOptionPane.showInputDialog("Introduzca pk del pack nuevo");
			String pkUsuario = JOptionPane.showInputDialog("Introduzca pk del usuario con el que quiere que se una");
			String descripcion = JOptionPane.showInputDialog("Introduzca una descripción");
			String nomPack = JOptionPane.showInputDialog("Introduzca una descripción");
			String tipoPack = JOptionPane.showInputDialog("Introduzca una descripción");
			String nVehiculo = JOptionPane.showInputDialog("Introduzca pk del vehiculo con el que quiere que se una");

			// Creación del elemento nuevo
			Pack t3 = new Pack();
			t3.setCodpack(Integer.parseInt(nPack));
			t3.setCodusuario(Integer.parseInt(pkUsuario));
			t3.setDescriptipo(descripcion);
			t3.setNompack(nomPack);
			t3.setTipopack(tipoPack);
			t3.setVehiculoPack(controladorVehi.findByPK(Integer.parseInt(nVehiculo)));

			controladorPack.crearPack(t3);

			// Aparece la tabla completa
			JOptionPane.showMessageDialog(null, "Ahora mismo esta es la tabla actualizada(Aparecerá por Consola)");
			imprimirPack(controladorPack);

			break;

		case "3":// Tabla Persona

			// Valores con los que trabajamos
			String codUsuario = JOptionPane.showInputDialog("Introduzca pk del usuario nuevo");
			String nombreUsuario = JOptionPane.showInputDialog("Introduzca el nombre");
			String ape1 = JOptionPane.showInputDialog("Introduzca el primer apellido");
			String ape2 = JOptionPane.showInputDialog("Introduzca el segundo apellido");
			String destino = JOptionPane.showInputDialog("Introduzca la dirección final/destino");
			String inicio = JOptionPane.showInputDialog("Introduzca la dirección de inicio/salida");
			String metodo = JOptionPane.showInputDialog("Introduzca la letra del método de pago");
			String telf = JOptionPane.showInputDialog("Introduzca el telefono");
			String dni = JOptionPane.showInputDialog("Introduzca el dni");

			// Creación del elemento nuevo
			Personas t2 = new Personas();
			t2.setCodusuario(Integer.parseInt(codUsuario));
			t2.setNombre(nombreUsuario);
			t2.setApe1(ape1);
			t2.setApe2(ape2);
			t2.setDestino(destino);
			t2.setInicio(inicio);
			t2.setMetodopago(metodo);
			t2.setTelf(telf);
			t2.setDni(dni);

			controladorPer.crearPersonas(t2);

			// Aparece la tabla completa
			JOptionPane.showMessageDialog(null, "Ahora mismo esta es la tabla actualizada(Aparecerá por Consola)");
			imprimirPersonas(controladorPer);

			break;

		case "4":// Tabla Trabajadores
			String codTrabajador = JOptionPane.showInputDialog("Introduzca pk del trabajador nuevo");
			String nombre = JOptionPane.showInputDialog("Introduzca el nombre");
			String ape1T = JOptionPane.showInputDialog("Introduzca el primer apellido");
			String ape2T = JOptionPane.showInputDialog("Introduzca el segundo apellido");
			String nmss = JOptionPane.showInputDialog("Introduzca el número de la seguridad social");

			String anioComienzo = JOptionPane.showInputDialog("Introduzca el año del comienzo del contrato");
			String mesComienzo = JOptionPane.showInputDialog("Introduzca el mes del comienzo del contrato");
			String diaComienzo = JOptionPane.showInputDialog("Introduzca el día del comienzo del contrato");

			String anioFin = JOptionPane.showInputDialog("Introduzca el año del fin del contrato");
			String mesFin = JOptionPane.showInputDialog("Introduzca el mes del fin del contrato");
			String diaFin = JOptionPane.showInputDialog("Introduzca el día del fin del contrato");

			// Se pone 1900 porque con Date se suma las fechas y con Date empieza en 1900 no
			// en el año 0
			int anioC = 1900 - Integer.parseInt(anioComienzo);
			int mesC = 1 - Integer.parseInt(mesComienzo);
			int diaC = Integer.parseInt(diaComienzo);
			Date comienzo = new Date(anioC, mesC, diaC);

			int anioF = 1900 - Integer.parseInt(anioFin);
			int mesF = 1 - Integer.parseInt(anioFin);
			int diaF = Integer.parseInt(anioFin);
			Date fin = new Date(anioF, mesF, diaF);

			String tipoContrato = JOptionPane.showInputDialog("Introduzca la letra del tipo de Contrato");
			String nomContrato = JOptionPane.showInputDialog("Introduzca el nombre del contrato");
			String telfTrab = JOptionPane.showInputDialog("Introduzca el telefono");
			String dniTrab = JOptionPane.showInputDialog("Introduzca el dni");

			Trabajadores t1 = new Trabajadores();
			t1.setNombre(nombre);
			t1.setCodtrabajador(Integer.parseInt(codTrabajador));
			t1.setDni(dniTrab);
			t1.setTelf(telfTrab);
			t1.setNumss(nmss);
			t1.setApe1(ape1T);
			t1.setApe2(ape2T);
			t1.setFechaini(comienzo);
			t1.setFechfincontrato(fin);
			t1.setTipocontrato(tipoContrato);
			t1.setNomcontrato(nomContrato);

			controladorTrab.crearTrabajadores(t1);

			// Aparece la tabla completa
			JOptionPane.showMessageDialog(null, "Ahora mismo esta es la tabla actualizada(Aparecerá por Consola)");
			imprimirTrabajadores(controladorTrab);
			break;

		case "5": // Tabla Vehiculos

			String codVehiculo = JOptionPane.showInputDialog("Introduzca pk del vehiculo nuevo");
			String ficha = JOptionPane.showInputDialog("Introduzca una descipción de estado del vehiculo");
			String matricula = JOptionPane.showInputDialog("Introduzca la matrícula");
			String modelo = JOptionPane.showInputDialog("Introduzca el modelo");
			String pack = JOptionPane.showInputDialog("Introduzca el número del paquete que quiere");

			String anioITV = JOptionPane.showInputDialog("Introduzca el año de la itv");
			String mesITV = JOptionPane.showInputDialog("Introduzca el mes de la itv");
			String diaITV = JOptionPane.showInputDialog("Introduzca el día de la itv");

			// Se pone 1900 porque con Date se suma las fechas y con Date empieza en 1900 no
			// en el año 0
			int anio = 1900 - Integer.parseInt(anioITV);
			int mes = 1900 - Integer.parseInt(mesITV);
			int dia = 1900 - Integer.parseInt(diaITV);
			Date itv = new Date(anio, mes, dia);

			String pesoMax = JOptionPane.showInputDialog("Introduzca el peso máximo del vehiculo(puede con decimales)");
			String alto = JOptionPane.showInputDialog("Introduzca la medida de alto");
			String ancho = JOptionPane.showInputDialog("Introduzca la medida de ancho");
			String trabajador = JOptionPane.showInputDialog("Introduzca el número de trabajador");

			Vehiculos t0 = new Vehiculos();
			t0.setCodvehiculo(Integer.parseInt(codVehiculo));
			t0.setFechaitv(itv);
			t0.setFichatecnica(ficha);
			t0.setMatricula(matricula);
			t0.setModelo(modelo);
			t0.setPack(controladorPack.findByPK(Integer.parseInt(pack)));
			t0.setPesomax(Double.parseDouble(pesoMax));
			t0.setTamanoalto(Double.parseDouble(alto));
			t0.setTamanoancho(Double.parseDouble(ancho));
			t0.setTrabajadore(controladorTrab.findByPK(Integer.parseInt(trabajador)));

			controladorVehi.crearVehiculos(t0);

			// Aparece la tabla completa
			JOptionPane.showMessageDialog(null, "Ahora mismo esta es la tabla actualizada(Aparecerá por Consola)");
			imprimirVehiculos(controladorVehi);

			break;
		}

	}

	// Imprime la tabla que elijamos
	public static void imprimirTabla(String eleccionBD) {
		JOptionPane.showMessageDialog(null, "La información aparecerá por consola actualizada");
		switch (eleccionBD) {

		case "1":
			imprimirContratos(controladorCont);
			break;
		case "2":
			imprimirPack(controladorPack);
			break;
		case "3":
			imprimirPersonas(controladorPer);
			break;
		case "4":
			imprimirTrabajadores(controladorTrab);
			break;
		case "5":
			imprimirVehiculos(controladorVehi);
			break;
		}

	}

	// Borra datos de las tablas de la bbdd que elijamos
	public static void borrarDatos(String eleccionBD) {

		switch (eleccionBD) {

		case "1":
			String claveCon = JOptionPane.showInputDialog("Introduzca la pk del contrato que desea eliminar");
			try {

				controladorCont.borrarContrato(controladorCont.findByPK(Integer.parseInt(claveCon)));
			} catch (IllegalArgumentException iae) {
				JOptionPane.showMessageDialog(null, "no existe en la tabla");
			}
			imprimirContratos(controladorCont);
			break;
		case "2":
			String clavePack = JOptionPane.showInputDialog("Introduzca la pk del pack que desea eliminar");
			try {

				controladorPack.borrarPack(controladorPack.findByPK(Integer.parseInt(clavePack)));
			} catch (IllegalArgumentException iae) {
				JOptionPane.showMessageDialog(null, "no existe en la tabla");
			}
			imprimirPack(controladorPack);
			break;
		case "3":
			String clavePer = JOptionPane.showInputDialog("Introduzca la pk de la persona que desea eliminar");
			try {
				controladorPer.borrarPersonas(controladorPer.findByPK(Integer.parseInt(clavePer)));
			} catch (IllegalArgumentException iae) {
				JOptionPane.showMessageDialog(null, "no existe en la tabla");
			}
			imprimirPersonas(controladorPer);
			break;
		case "4":
			String claveTrab = JOptionPane.showInputDialog("Introduzca la pk del trabajador que desea eliminar");
			try {
				controladorTrab.borrarTrabajadores(controladorTrab.findByPK(Integer.parseInt(claveTrab)));
			} catch (IllegalArgumentException iae) {
				JOptionPane.showMessageDialog(null, "no existe en la tabla");
			}
			imprimirTrabajadores(controladorTrab);
			break;
		case "5":
			String claveVeh = JOptionPane.showInputDialog("Introduzca la pk del contrato que desea eliminar");
			try {
				controladorVehi.borrarVehiculos(controladorVehi.findByPK(Integer.parseInt(claveVeh)));
			} catch (IllegalArgumentException iae) {
				JOptionPane.showMessageDialog(null, "no existe en la tabla");
			}
			imprimirVehiculos(controladorVehi);
			break;
		}

	}

	public static void modificarDatos(String eleccionBD) {
		switch (eleccionBD) {

		case "1":
			try {

				// Valores con los que trabajamos
				String pkCont = JOptionPane.showInputDialog("Introduzca pk del contrato existente");
				String pkPack = JOptionPane.showInputDialog("Introduzca pk del pack con el que quiere que se una");
				String pkPersona = JOptionPane
						.showInputDialog("Introduzca pk de la persona con el que quiere que se una");
				String pkVehiculo = JOptionPane
						.showInputDialog("Introduzca pk del vehiculo con el que quiere que se una");

				// Contrato nuevo
				Contrato t4 = new Contrato();
				t4.setCodcontrato(Integer.parseInt(pkCont));
				t4.setPack(controladorPack.findByPK(Integer.parseInt(pkPack)));
				t4.setPersona(controladorPer.findByPK(Integer.parseInt(pkPersona)));
				t4.setVehiculo(controladorVehi.findByPK(Integer.parseInt(pkVehiculo)));

				// Modifica el contrato
				controladorCont.modificarContrato(t4);

			} catch (IllegalArgumentException iae) {
				JOptionPane.showMessageDialog(null, "no existe");
			}

			imprimirContratos(controladorCont);
			break;
		case "2":
			try {
				// Valores con los que trabajamos
				String nPack = JOptionPane.showInputDialog("Introduzca pk del pack existente");
				String pkUsuario = JOptionPane
						.showInputDialog("Introduzca pk del usuario con el que quiere que se una");
				String descripcion = JOptionPane.showInputDialog("Introduzca una descripción");
				String nomPack = JOptionPane.showInputDialog("Introduzca una descripción");
				String tipoPack = JOptionPane.showInputDialog("Introduzca una descripción");
				String nVehiculo = JOptionPane
						.showInputDialog("Introduzca pk del vehiculo con el que quiere que se una");

				// Creación del elemento nuevo
				Pack t3 = new Pack();
				t3.setCodpack(Integer.parseInt(nPack));
				t3.setCodusuario(Integer.parseInt(pkUsuario));
				t3.setDescriptipo(descripcion);
				t3.setNompack(nomPack);
				t3.setTipopack(tipoPack);
				t3.setVehiculoPack(controladorVehi.findByPK(Integer.parseInt(nVehiculo)));

				controladorPack.modificarPack(t3);

			} catch (IllegalArgumentException iae) {
				JOptionPane.showMessageDialog(null, "no existe");
			}
			imprimirPack(controladorPack);
			break;
		case "3":
			try {
				// Valores con los que trabajamos
				String codUsuario = JOptionPane.showInputDialog("Introduzca pk del usuario existente");
				String nombreUsuario = JOptionPane.showInputDialog("Introduzca el nombre");
				String ape1 = JOptionPane.showInputDialog("Introduzca el primer apellido");
				String ape2 = JOptionPane.showInputDialog("Introduzca el segundo apellido");
				String destino = JOptionPane.showInputDialog("Introduzca la dirección final/destino");
				String inicio = JOptionPane.showInputDialog("Introduzca la dirección de inicio/salida");
				String metodo = JOptionPane.showInputDialog("Introduzca la letra del método de pago");
				String telf = JOptionPane.showInputDialog("Introduzca el telefono");
				String dni = JOptionPane.showInputDialog("Introduzca el dni");

				// Creación del elemento nuevo
				Personas t2 = new Personas();
				t2.setCodusuario(Integer.parseInt(codUsuario));
				t2.setNombre(nombreUsuario);
				t2.setApe1(ape1);
				t2.setApe2(ape2);
				t2.setDestino(destino);
				t2.setInicio(inicio);
				t2.setMetodopago(metodo);
				t2.setTelf(telf);
				t2.setDni(dni);

				controladorPer.modificarPersonas(t2);

			} catch (IllegalArgumentException iae) {

				JOptionPane.showMessageDialog(null, "no existe");
			}
			imprimirPersonas(controladorPer);
			break;
		case "4":
			try {
				String codTrabajador = JOptionPane.showInputDialog("Introduzca pk del trabajador existente");
				String nombre = JOptionPane.showInputDialog("Introduzca el nombre");
				String ape1T = JOptionPane.showInputDialog("Introduzca el primer apellido");
				String ape2T = JOptionPane.showInputDialog("Introduzca el segundo apellido");
				String nmss = JOptionPane.showInputDialog("Introduzca el número de la seguridad social");

				String anioComienzo = JOptionPane.showInputDialog("Introduzca el año del comienzo del contrato");
				String mesComienzo = JOptionPane.showInputDialog("Introduzca el mes del comienzo del contrato");
				String diaComienzo = JOptionPane.showInputDialog("Introduzca el día del comienzo del contrato");

				String anioFin = JOptionPane.showInputDialog("Introduzca el año del fin del contrato");
				String mesFin = JOptionPane.showInputDialog("Introduzca el mes del fin del contrato");
				String diaFin = JOptionPane.showInputDialog("Introduzca el día del fin del contrato");

				// Se pone 1900 porque con Date se suma las fechas y con Date empieza en 1900 no
				// en el año 0
				int anioC = 1900 - Integer.parseInt(anioComienzo);
				int mesC = 1900 - Integer.parseInt(mesComienzo);
				int diaC = 1900 - Integer.parseInt(diaComienzo);
				Date comienzo = new Date(anioC, mesC, diaC);

				int anioF = 1900 - Integer.parseInt(anioFin);
				int mesF = 1900 - Integer.parseInt(anioFin);
				int diaF = 1900 - Integer.parseInt(anioFin);
				Date fin = new Date(anioF, mesF, diaF);

				String tipoContrato = JOptionPane.showInputDialog("Introduzca la letra del tipo de Contrato");
				String nomContrato = JOptionPane.showInputDialog("Introduzca el nombre del contrato");
				String telfTrab = JOptionPane.showInputDialog("Introduzca el telefono");
				String dniTrab = JOptionPane.showInputDialog("Introduzca el dni");

				Trabajadores t1 = new Trabajadores();
				t1.setNombre(nombre);
				t1.setCodtrabajador(Integer.parseInt(codTrabajador));
				t1.setDni(dniTrab);
				t1.setTelf(telfTrab);
				t1.setNumss(nmss);
				t1.setApe1(ape1T);
				t1.setApe2(ape2T);
				t1.setFechaini(comienzo);
				t1.setFechfincontrato(fin);
				t1.setTipocontrato(tipoContrato);
				t1.setNomcontrato(nomContrato);

				controladorTrab.modificarTrabajadores(t1);

			} catch (IllegalArgumentException iae) {
				JOptionPane.showMessageDialog(null, "no existe");
			}
			imprimirTrabajadores(controladorTrab);
			break;
		case "5":
			try {
				String codVehiculo = JOptionPane.showInputDialog("Introduzca pk del vehiculo nuevo");
				String ficha = JOptionPane.showInputDialog("Introduzca una descipción de estado del vehiculo");
				String matricula = JOptionPane.showInputDialog("Introduzca la matrícula");
				String modelo = JOptionPane.showInputDialog("Introduzca el modelo");
				String pack = JOptionPane.showInputDialog("Introduzca el número del paquete que quiere");

				String anioITV = JOptionPane.showInputDialog("Introduzca el año de la itv");
				String mesITV = JOptionPane.showInputDialog("Introduzca el mes de la itv");
				String diaITV = JOptionPane.showInputDialog("Introduzca el día de la itv");

				// Se pone 1900 porque con Date se suma las fechas y con Date empieza en 1900 no
				// en el año 0
				int anio = 1900 - Integer.parseInt(anioITV);
				int mes = 1 - Integer.parseInt(mesITV);
				int dia = Integer.parseInt(diaITV);
				Date itv = new Date(anio, mes, dia);

				String pesoMax = JOptionPane
						.showInputDialog("Introduzca el peso máximo del vehiculo(puede con decimales)");
				String alto = JOptionPane.showInputDialog("Introduzca la medida de alto");
				String ancho = JOptionPane.showInputDialog("Introduzca la medida de ancho");
				String trabajador = JOptionPane.showInputDialog("Introduzca el número de trabajador");

				Vehiculos t0 = new Vehiculos();
				t0.setCodvehiculo(Integer.parseInt(codVehiculo));
				t0.setFechaitv(itv);
				t0.setFichatecnica(ficha);
				t0.setMatricula(matricula);
				t0.setModelo(modelo);
				t0.setPack(controladorPack.findByPK(Integer.parseInt(pack)));
				t0.setPesomax(Double.parseDouble(pesoMax));
				t0.setTamanoalto(Double.parseDouble(alto));
				t0.setTamanoancho(Double.parseDouble(ancho));
				t0.setTrabajadore(controladorTrab.findByPK(Integer.parseInt(trabajador)));

				controladorVehi.modificarVehiculos(t0);

			} catch (IllegalArgumentException iae) {
				JOptionPane.showMessageDialog(null, "no existe en la tabla");
			}
			imprimirVehiculos(controladorVehi);
			break;
		}

	}
	// --------ELECCIÓN DE OPERACÓN CRUD-------

	// Hace las operaciones crud del programa
	public static void actosEnBD(String eleccion) {
		boolean repetir;
		String opcion = JOptionPane.showInputDialog("Introduzca una de las siguientes opciones(solo número):"
				+ "\n1.Ver plantilla completa" + "\n2.Darme/dar de alta un elemento/persona nuevo en la empresa"
				+ "\n3.Moficar datos \n4.Borrar cuenta/elemento");
		do {
			repetir = true;
			switch (opcion) {
			case "1":
				imprimirTabla(eleccion);
				break;
			case "2":
				crearEnBDElegida(eleccion);
				break;
			case "3":
				modificarDatos(eleccion);
				break;
			case "4":
				borrarDatos(eleccion);
				break;
			}

		} while (!repetir);
	}

	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null, "Hola, bienvenid@ a tu empresa de mundaza favorita\n Nómadas");
		

		eleccionBD();

	}

}
