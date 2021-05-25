package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Contrato;
import entidades.Personas;

public class ControladorPersonas {
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("proyectoFinalCristinaJ");
	private EntityManager em;
	private Query consulta;

	// Borra elementos de la tabla personas
	public void borrarPersonas(Personas c) {
		this.em = entityManagerFactory.createEntityManager();
		Personas aux = null;
		this.em.getTransaction().begin();
		if (!this.em.contains(c)) {
			aux = this.em.merge(c);
		}
		this.em.remove(aux);
		this.em.getTransaction().commit();
		this.em.close();
	}

	// Modifica elementos de la tabla personas
	public void modificarPersonas(Personas c) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.merge(c);
		this.em.getTransaction().commit();
		this.em.close();

	}

	// Crea un elemento en la tabla personas
	public void crearPersonas(Personas c) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.persist(c);
		this.em.getTransaction().commit();
		this.em.close();
	}

	// Busca por primary key en este caso codusuario
	public Personas findByPK(int pk) {
		this.em = entityManagerFactory.createEntityManager();
		Personas aux = null;
		this.consulta = em.createNativeQuery("Select * from personas where codusuario = ?", Personas.class);
		this.consulta.setParameter(1, pk);

		try {
			aux = (Personas) consulta.getSingleResult();
		} catch (NoResultException nre) {
			aux = null;
		}

		this.em.close();
		return aux;

	}

	//Busca por DNI
	public Personas findByDni(String dni) {
		this.em = entityManagerFactory.createEntityManager();
		Personas aux = null;
		this.consulta = em.createNativeQuery("Select * from personas where dni = ?", Personas.class);
		this.consulta.setParameter(1, dni);
		try {
			aux = (Personas) consulta.getSingleResult();
		} catch (NoResultException nre) {
			aux = null;
		}
		this.em.close();
		return aux;

	}

	// Aparecen todos las personas que aparecen en la tabla personas
	public List<Personas> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Personas.findAll");
		List<Personas> lista = (List<Personas>) consulta.getResultList();
		this.em.close();
		return lista;
	}

}
