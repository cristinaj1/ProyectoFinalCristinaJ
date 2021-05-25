package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Contrato;
import entidades.Trabajadores;

public class ControladorTrabajadores {
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("proyectoFinalCristinaJ");
	private EntityManager em;
	private Query consulta;

	// Borra elementos de la tabla trabajadores
	public void borrarTrabajadores(Trabajadores c) {
		this.em = entityManagerFactory.createEntityManager();
		Trabajadores aux = null;
		this.em.getTransaction().begin();
		if (!this.em.contains(c)) {
			aux = this.em.merge(c);
		}
		this.em.remove(aux);
		this.em.getTransaction().commit();
		this.em.close();
	}

	// Modifica elementos de la tabla trabajadores
	public void modificarTrabajadores(Trabajadores c) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.merge(c);
		this.em.getTransaction().commit();
		this.em.close();

	}

	// Crea un elemento en la tabla trabajadores
	public void crearTrabajadores(Trabajadores c) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.persist(c);
		this.em.getTransaction().commit();
		this.em.close();
	}

	// Busca por primary key en este caso codtrabajadores
	public Trabajadores findByPK(int pk) {
		this.em = entityManagerFactory.createEntityManager();
		Trabajadores aux = null;
		this.consulta = em.createNativeQuery("Select * from trabajadores where codtrabajador = ?", Trabajadores.class);
		this.consulta.setParameter(1, pk);

		try {
			aux = (Trabajadores) consulta.getSingleResult();
		} catch (NoResultException nre) {
			aux = null;
		}

		this.em.close();
		return aux;

	}

	// BUsca según el telf que se le pasa
	public Trabajadores findByTelf(String telf) {
		this.em = entityManagerFactory.createEntityManager();
		Trabajadores aux = null;
		this.consulta = em.createNativeQuery("Select * from trabajadores where telf = ?", Trabajadores.class);
		this.consulta.setParameter(1, telf);
		try {
			aux = (Trabajadores) consulta.getSingleResult();
		} catch (NoResultException nre) {
			aux = null;
		}
		this.em.close();
		return aux;

	}

	// Aparecen todos los trabajadores de nuestra base de datos
	public List<Trabajadores> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Trabajadores.findAll");
		List<Trabajadores> lista = (List<Trabajadores>) consulta.getResultList();
		this.em.close();
		return lista;
	}

}
