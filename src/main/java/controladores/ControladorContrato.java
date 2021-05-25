package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Contrato;

public class ControladorContrato {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyectoFinalCristinaJ");
	private EntityManager em;
	private Query consulta;

	//Borra elementos de la tabla contrato
	public void borrarContrato(Contrato c) {
		this.em = entityManagerFactory.createEntityManager();
		Contrato aux = null;
		this.em.getTransaction().begin();
		if (!this.em.contains(c)) {
			aux = this.em.merge(c);
		}
		this.em.remove(aux);
		this.em.getTransaction().commit();
		this.em.close();
	}

	//Modifica un contrato
	public void modificarContrato(Contrato c) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.merge(c);
		this.em.getTransaction().commit();
		this.em.close();

	}

	//Crea un contrato nuevo
	public void crearContrato(Contrato c) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.persist(c);
		this.em.getTransaction().commit();
		this.em.close();
	}

	//Busca por primary key en este caso codcontrato
	public Contrato findByPK(int pk) {
		this.em = entityManagerFactory.createEntityManager();
		Contrato aux = null;
		
		this.consulta = em.createNativeQuery("select * from contrato where codcontrato = ?", Contrato.class);
		this.consulta.setParameter(1, pk);

		try {
			aux = (Contrato) consulta.getSingleResult();
		} catch (NoResultException nre) {
			aux = null;
		}

		this.em.close();
		return aux;

	}

	//Aparecen todos los contratos de la empresa
	public List<Contrato> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Contrato.findAll");
		List<Contrato> lista = (List<Contrato>) consulta.getResultList();
		this.em.close();
		return lista;
	}

}
