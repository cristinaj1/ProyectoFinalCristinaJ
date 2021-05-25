package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Contrato;
import entidades.Pack;

public class ControladorPack {
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("proyectoFinalCristinaJ");
	private EntityManager em;
	private Query consulta;

	// Borra elementos de la tabla pack
	public void borrarPack(Pack c) {
		this.em = entityManagerFactory.createEntityManager();
		Pack aux = null;
		this.em.getTransaction().begin();
		if (!this.em.contains(c)) {
			aux = this.em.merge(c);
		}
		this.em.remove(aux);
		this.em.getTransaction().commit();
		this.em.close();
	}

	// Modifica elementos de la tabla pack
	public void modificarPack(Pack c) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.merge(c);
		this.em.getTransaction().commit();
		this.em.close();

	}

	// Crea un elemento en la tabla pack
	public void crearPack(Pack c) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.persist(c);
		this.em.getTransaction().commit();
		this.em.close();
	}

	// Busca por primary key en este caso codpack
	public Pack findByPK(int pk) {
		this.em = entityManagerFactory.createEntityManager();
		Pack aux = null;
		this.consulta = em.createNativeQuery("Select * from pack where codpack = ?", Pack.class);
		this.consulta.setParameter(1, pk);

		try {
			aux = (Pack) consulta.getSingleResult();
		} catch (NoResultException nre) {
			aux = null;
		}

		this.em.close();
		return aux;

	}

	//Busca según el tipo de pack que se le pasa
	public Pack findByTipoPack(String tipo) {
		this.em = entityManagerFactory.createEntityManager();
		Pack aux = null;
		this.consulta = em.createNativeQuery("Select * from pack where tipopack = ?", Pack.class);
		this.consulta.setParameter(1, tipo);
		try {
			aux = (Pack) consulta.getSingleResult();
		} catch (NoResultException nre) {
			aux = null;
		}
		this.em.close();
		return aux;

	}

	// Aparecen todos los packs de la empresa
	public List<Pack> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Pack.findAll");
		List<Pack> lista = (List<Pack>) consulta.getResultList();
		this.em.close();
		return lista;
	}

}
