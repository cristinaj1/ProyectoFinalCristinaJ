package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Contrato;
import entidades.Vehiculos;

public class ControladorVehiculos {
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("proyectoFinalCristinaJ");
	private EntityManager em;
	private Query consulta;

	// Borra elementos de la tabla vehiculos
	public void borrarVehiculos(Vehiculos c) {
		this.em = entityManagerFactory.createEntityManager();
		Vehiculos aux = null;
		this.em.getTransaction().begin();
		if (!this.em.contains(c)) {
			aux = this.em.merge(c);
		}
		this.em.remove(aux);
		this.em.getTransaction().commit();
		this.em.close();
	}

	// Modifica elementos de la tabla vehiculos
	public void modificarVehiculos(Vehiculos c) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.merge(c);
		this.em.getTransaction().commit();
		this.em.close();

	}

	// Crea un elemento en la tabla vehiculos
	public void crearVehiculos(Vehiculos cv) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.persist(cv);
		this.em.getTransaction().commit();
		this.em.close();
	}

	// Busca por primary key en este caso codvehiculo
	public Vehiculos findByPK(int pk) {
		this.em = entityManagerFactory.createEntityManager();
		Vehiculos aux = null;
		this.consulta = em.createNativeQuery("Select * from vehiculos where codvehiculo = ?", Vehiculos.class);
		this.consulta.setParameter(1, pk);

		try {
			aux = (Vehiculos) consulta.getSingleResult();
		} catch (NoResultException nre) {
			aux = null;
		}

		this.em.close();
		return aux;

	}

	// Busca según la matricula que se le pase
	public Vehiculos findByMatricula(String matricula) {
		this.em = entityManagerFactory.createEntityManager();
		Vehiculos aux = null;
		this.consulta = em.createNativeQuery("Select * from vehiculos where matricula = ?", Vehiculos.class);
		this.consulta.setParameter(1, matricula);
		try {
			aux = (Vehiculos) consulta.getSingleResult();
		} catch (NoResultException nre) {
			aux = null;
		}
		this.em.close();
		return aux;

	}

	// Aparecen todos los vehiculos
	public List<Vehiculos> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Vehiculos.findAll");
		List<Vehiculos> lista = (List<Vehiculos>) consulta.getResultList();
		this.em.close();
		return lista;
	}

}
