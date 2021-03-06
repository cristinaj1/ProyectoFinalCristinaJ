package appfinal;

import java.util.Date;
import java.util.InputMismatchException;
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
		try {
			do {
				String eleccionBD = JOptionPane
						.showInputDialog("Por favor, elija a qu?? parte desea entrar(solo n??mero):"
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
		} catch (Exception e) {

		}
	}

	// ----------- OPERACIONES CRUD DE CADA TABLA

	// Crea el elemento en la tabla elegida
	public static void crearEnBDElegida(String eleccionBD) {
		try {
			switch (eleccionBD) {
			case "1":// Tabla Contrato

				// Valores con los que trabajamos
				String pkPack = JOptionPane.showInputDialog("Introduzca pk del pack con el que quiere que se una");
				String pkPersona = JOptionPane
						.showInputDialog("Introduzca pk de la persona con el que quiere que se una");
				String pkVehiculo = JOptionPane
						.showInputDialog("Introduzca pk del vehiculo con el que quiere que se una");

				// Contrato nuevo
				Contrato t4 = new Contrato();
				t4.setPack(controladorPack.findByPK(Integer.parseInt(pkPack)));
				t4.setPersona(controladorPer.findByPK(Integer.parseInt(pkPersona)));
				t4.setVehiculo(controladorVehi.findByPK(Integer.parseInt(pkVehiculo)));
				controladorCont.crearContrato(t4);

				// Aparece la tabla completa
				JOptionPane.showMessageDialog(null, "Ahora mismo esta es la tabla actualizada(Aparecer?? por Consola)");
				imprimirContratos(controladorCont);
				break;

			case "2":// Tabla Pack

				// Valores con los que trabajamos
				String pkUsuario = JOptionPane
						.showInputDialog("Introduzca pk del usuario con el que quiere que se una");
				String descripcion = JOptionPane.showInputDialog("Introduzca una descripci??n");
				String nomPack = JOptionPane.showInputDialog("Introduzca nombre del pack");
				String tipoPack = JOptionPane.showInputDialog("Introduzca inicial del tipo pack (M,F,I)");
				String nVehiculo = JOptionPane
						.showInputDialog("Introduzca pk del vehiculo con el que quiere que se una");

				// Creaci??n del elemento nuevo
				Pack t3 = new Pack();
				t3.setCodusuario(Integer.parseInt(pkUsuario));
				t3.setDescriptipo(descripcion);
				t3.setNompack(nomPack);
				t3.setTipopack(tipoPack);
				t3.setVehiculoPack(controladorVehi.findByPK(Integer.parseInt(nVehiculo)));

				controladorPack.crearPack(t3);

				// Aparece la tabla completa
				JOptionPane.showMessageDialog(null, "Ahora mismo esta es la tabla actualizada(Aparecer?? por Consola)");
				imprimirPack(controladorPack);

				break;

			case "3":// Tabla Persona

				// Valores con los que trabajamos
				String nombreUsuario = JOptionPane.showInputDialog("Introduzca el nombre");
				String ape1 = JOptionPane.showInputDialog("Introduzca el primer apellido");
				String ape2 = JOptionPane.showInputDialog("Introduzca el segundo apellido");
				String destino = JOptionPane.showInputDialog("Introduzca la direcci??n final/destino");
				String inicio = JOptionPane.showInputDialog("Introduzca la direcci??n de inicio/salida");
				String metodo = JOptionPane.showInputDialog("Introduzca la letra del m??todo de pago");
				String telf = JOptionPane.showInputDialog("Introduzca el telefono");
				String dni = JOptionPane.showInputDialog("Introduzca el dni");

				// Creaci??n del elemento nuevo
				Personas t2 = new Personas();
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
				JOptionPane.showMessageDialog(null, "Ahora mismo esta es la tabla actualizada(Aparecer?? por Consola)");
				imprimirPersonas(controladorPer);

				break;

			case "4":// Tabla Trabajadores
				String nombre = JOptionPane.showInputDialog("Introduzca el nombre");
				String ape1T = JOptionPane.showInputDialog("Introduzca el primer apellido");
				String ape2T = JOptionPane.showInputDialog("Introduzca el segundo apellido");
				String nmss = JOptionPane.showInputDialog("Introduzca el n??mero de la seguridad social");

				String anioComienzo = JOptionPane.showInputDialog("Introduzca el a??o del comienzo del contrato");
				String mesComienzo = JOptionPane.showInputDialog("Introduzca el mes del comienzo del contrato");
				String diaComienzo = JOptionPane.showInputDialog("Introduzca el d??a del comienzo del contrato");

				String anioFin = JOptionPane.showInputDialog("Introduzca el a??o del fin del contrato");
				String mesFin = JOptionPane.showInputDialog("Introduzca el mes del fin del contrato");
				String diaFin = JOptionPane.showInputDialog("Introduzca el d??a del fin del contrato");

				// Se pone 1900 porque con Date se suma las fechas y con Date empieza en 1900 no
				// en el a??o 0
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
				JOptionPane.showMessageDialog(null, "Ahora mismo esta es la tabla actualizada(Aparecer?? por Consola)");
				imprimirTrabajadores(controladorTrab);
				break;

			case "5": // Tabla Vehiculos

				String ficha = JOptionPane.showInputDialog("Introduzca una descipci??n de estado del vehiculo");
				String matricula = JOptionPane.showInputDialog("Introduzca la matr??cula");
				String modelo = JOptionPane.showInputDialog("Introduzca el modelo");
				String pack = JOptionPane.showInputDialog("Introduzca el n??mero del paquete que quiere");

				String anioITV = JOptionPane.showInputDialog("Introduzca el a??o de la itv");
				String mesITV = JOptionPane.showInputDialog("Introduzca el mes de la itv");
				String diaITV = JOptionPane.showInputDialog("Introduzca el d??a de la itv");

				// Se pone 1900 porque con Date se suma las fechas y con Date empieza en 1900 no
				// en el a??o 0
				int anio = 1900 - Integer.parseInt(anioITV);
				int mes = Integer.parseInt(mesITV);
				int dia = 1 - Integer.parseInt(diaITV);
				Date itv = new Date(anio, mes, dia);

				String pesoMax = JOptionPane
						.showInputDialog("Introduzca el peso m??ximo del vehiculo(puede con decimales)");
				String alto = JOptionPane.showInputDialog("Introduzca la medida de alto");
				String ancho = JOptionPane.showInputDialog("Introduzca la medida de ancho");
				String trabajador = JOptionPane.showInputDialog("Introduzca el n??mero de trabajador");

				Vehiculos t0 = new Vehiculos();
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
				JOptionPane.showMessageDialog(null, "Ahora mismo esta es la tabla actualizada(Aparecer?? por Consola)");
				imprimirVehiculos(controladorVehi);

				break;
			}
		} catch (Exception e) {

		}
	}

	// Imprime la tabla que elijamos
	public static void imprimirTabla(String eleccionBD) {
		JOptionPane.showMessageDialog(null, "La informaci??n aparecer?? por consola actualizada");
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
		try {
			switch (eleccionBD) {

			case "1":
				imprimirContratos(controladorCont);
				String claveCon = JOptionPane.showInputDialog("Introduzca la pk del contrato que desea eliminar");

				controladorCont.borrarContrato(controladorCont.findByPK(Integer.parseInt(claveCon)));

				imprimirContratos(controladorCont);
				break;
			case "2":
				imprimirPack(controladorPack);
				String clavePack = JOptionPane.showInputDialog("Introduzca la pk del pack que desea eliminar");

				controladorPack.borrarPack(controladorPack.findByPK(Integer.parseInt(clavePack)));

				imprimirPack(controladorPack);
				break;
			case "3":
				imprimirPersonas(controladorPer);
				String clavePer = JOptionPane.showInputDialog("Introduzca la pk de la persona que desea eliminar");

				controladorPer.borrarPersonas(controladorPer.findByPK(Integer.parseInt(clavePer)));

				imprimirPersonas(controladorPer);
				break;
			case "4":
				imprimirTrabajadores(controladorTrab);
				String claveTrab = JOptionPane.showInputDialog("Introduzca la pk del trabajador que desea eliminar");

				controladorTrab.borrarTrabajadores(controladorTrab.findByPK(Integer.parseInt(claveTrab)));

				imprimirTrabajadores(controladorTrab);
				break;
			case "5":
				imprimirVehiculos(controladorVehi);
				String claveVeh = JOptionPane.showInputDialog("Introduzca la pk del contrato que desea eliminar");

				controladorVehi.borrarVehiculos(controladorVehi.findByPK(Integer.parseInt(claveVeh)));

				imprimirVehiculos(controladorVehi);
				break;
			}
		} catch (IllegalArgumentException iae) {
			JOptionPane.showMessageDialog(null, "no existe en la tabla");
		}

	}

	public static void modificarDatos(String eleccionBD) {
		try {
			switch (eleccionBD) {

			case "1":
				imprimirContratos(controladorCont);
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

				imprimirContratos(controladorCont);
				break;
			case "2":
				imprimirPack(controladorPack);
				// Valores con los que trabajamos
				String nPack = JOptionPane.showInputDialog("Introduzca pk del pack existente");
				String pkUsuario = JOptionPane
						.showInputDialog("Introduzca pk del usuario con el que quiere que se una");
				String descripcion = JOptionPane.showInputDialog("Introduzca una descripci??n");
				String nomPack = JOptionPane.showInputDialog("Introduzca nombre del Pack");
				String tipoPack = JOptionPane.showInputDialog("Introduzca inicial del tipo pack(M,F,I)");
				String nVehiculo = JOptionPane
						.showInputDialog("Introduzca pk del vehiculo con el que quiere que se una");

				// Creaci??n del elemento nuevo
				Pack t3 = new Pack();
				t3.setCodpack(Integer.parseInt(nPack));
				t3.setCodusuario(Integer.parseInt(pkUsuario));
				t3.setDescriptipo(descripcion);
				t3.setNompack(nomPack);
				t3.setTipopack(tipoPack);
				t3.setVehiculoPack(controladorVehi.findByPK(Integer.parseInt(nVehiculo)));

				controladorPack.modificarPack(t3);

				imprimirPack(controladorPack);
				break;
			case "3":
				imprimirPersonas(controladorPer);
				// Valores con los que trabajamos
				String codUsuario = JOptionPane.showInputDialog("Introduzca pk del usuario existente");
				String nombreUsuario = JOptionPane.showInputDialog("Introduzca el nombre");
				String ape1 = JOptionPane.showInputDialog("Introduzca el primer apellido");
				String ape2 = JOptionPane.showInputDialog("Introduzca el segundo apellido");
				String destino = JOptionPane.showInputDialog("Introduzca la direcci??n final/destino");
				String inicio = JOptionPane.showInputDialog("Introduzca la direcci??n de inicio/salida");
				String metodo = JOptionPane.showInputDialog("Introduzca la letra del m??todo de pago");
				String telf = JOptionPane.showInputDialog("Introduzca el telefono");
				String dni = JOptionPane.showInputDialog("Introduzca el dni");

				// Creaci??n del elemento nuevo
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

				imprimirPersonas(controladorPer);
				break;
			case "4":
				imprimirTrabajadores(controladorTrab);
				String codTrabajador = JOptionPane.showInputDialog("Introduzca pk del trabajador existente");
				String nombre = JOptionPane.showInputDialog("Introduzca el nombre");
				String ape1T = JOptionPane.showInputDialog("Introduzca el primer apellido");
				String ape2T = JOptionPane.showInputDialog("Introduzca el segundo apellido");
				String nmss = JOptionPane.showInputDialog("Introduzca el n??mero de la seguridad social");

				String anioComienzo = JOptionPane.showInputDialog("Introduzca el a??o del comienzo del contrato");
				String mesComienzo = JOptionPane.showInputDialog("Introduzca el mes del comienzo del contrato");
				String diaComienzo = JOptionPane.showInputDialog("Introduzca el d??a del comienzo del contrato");

				String anioFin = JOptionPane.showInputDialog("Introduzca el a??o del fin del contrato");
				String mesFin = JOptionPane.showInputDialog("Introduzca el mes del fin del contrato");
				String diaFin = JOptionPane.showInputDialog("Introduzca el d??a del fin del contrato");

				// Se pone 1900 porque con Date se suma las fechas y con Date empieza en 1900 no
				// en el a??o 0
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

				imprimirTrabajadores(controladorTrab);
				break;
			case "5":
				imprimirVehiculos(controladorVehi);
				String codVehiculo = JOptionPane.showInputDialog("Introduzca pk del vehiculo nuevo");
				String ficha = JOptionPane.showInputDialog("Introduzca una descipci??n de estado del vehiculo");
				String matricula = JOptionPane.showInputDialog("Introduzca la matr??cula");
				String modelo = JOptionPane.showInputDialog("Introduzca el modelo");
				String pack = JOptionPane.showInputDialog("Introduzca el n??mero del paquete que quiere");

				String anioITV = JOptionPane.showInputDialog("Introduzca el a??o de la itv");
				String mesITV = JOptionPane.showInputDialog("Introduzca el mes de la itv");
				String diaITV = JOptionPane.showInputDialog("Introduzca el d??a de la itv");

				// Se pone 1900 porque con Date se suma las fechas y con Date empieza en 1900 no
				// en el a??o 0
				int anio = 1900 - Integer.parseInt(anioITV);
				int mes = 1 - Integer.parseInt(mesITV);
				int dia = Integer.parseInt(diaITV);
				Date itv = new Date(anio, mes, dia);

				String pesoMax = JOptionPane
						.showInputDialog("Introduzca el peso m??ximo del vehiculo(puede con decimales)");
				String alto = JOptionPane.showInputDialog("Introduzca la medida de alto");
				String ancho = JOptionPane.showInputDialog("Introduzca la medida de ancho");
				String trabajador = JOptionPane.showInputDialog("Introduzca el n??mero de trabajador");

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

				imprimirVehiculos(controladorVehi);
				break;
			}
		} catch (IllegalArgumentException iae) {
			JOptionPane.showMessageDialog(null, "no existe en la tabla");
		}

	}
	// --------ELECCI??N DE OPERAC??N CRUD-------

	// Hace las operaciones crud del programa
	public static void actosEnBD(String eleccion) {
		boolean repetir;
		String opcion = JOptionPane.showInputDialog("Introduzca una de las siguientes opciones(solo n??mero):"
				+ "\n1.Ver plantilla completa" + "\n2.Darme/dar de alta un elemento/persona nuevo en la empresa"
				+ "\n3.Moficar datos \n4.Borrar cuenta/elemento");
		try {
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
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null, "Hola, bienvenid@ a tu empresa de mundaza favorita\n N??madas");

		eleccionBD();

	}

}
