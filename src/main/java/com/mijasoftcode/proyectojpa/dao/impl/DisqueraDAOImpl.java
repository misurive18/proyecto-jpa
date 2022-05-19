/**
 * 
 */
package com.mijasoftcode.proyectojpa.dao.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mijasoftcode.proyectojpa.dao.DisqueraDAO;
import com.mijasoftcode.proyectojpa.entity.Disquera;

/**
 * @author mijasoftcode Clase que implementa las transacciones para la tabla de
 *         Disquera.
 */
public class DisqueraDAOImpl implements DisqueraDAO {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceMijasoftcode");

	@Override
	public void guardar(Disquera disquera) {

		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin(); // inicia la transaccion

		try {

			em.persist(disquera); // encargado de almacenar la informacion de una nueva entidad en la tabla de DB.
			et.commit(); // asegura los resultados en la base de datos.
		} catch (Exception e) {

			if (et != null) {
				et.rollback();
			}
			e.printStackTrace(); // muestra error o excepcion en la consola
		} finally {
			em.close();
		}

	}

	@Override
	public void actualizar(Disquera disquera) {

		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin(); // inicia la transaccion

		try {

			em.merge(disquera); // encargado de almacenar la informacion de una nueva entidad en la tabla de DB.
			et.commit(); // asegura los resultados en la base de datos.
		} catch (Exception e) {

			if (et != null) {
				et.rollback();
			}
			e.printStackTrace(); // muestra error o excepcion en la consola
		} finally {
			em.close();
		}

	}

	@Override
	public void eliminar(Long id) {

		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		Disquera disqueraConsultada = em.find(Disquera.class, id);

		EntityTransaction et = em.getTransaction();
		et.begin(); // inicia la transaccion

		try {

			em.remove(disqueraConsultada); // encargado de almacenar la informacion de una nueva entidad en la tabla de
											// DB.
			et.commit(); // asegura los resultados en la base de datos.
		} catch (Exception e) {

			if (et != null) {
				et.rollback();
			}
			e.printStackTrace(); // muestra error o excepcion en la consola
		} finally {
			em.close();
		}

	}

	@Override
	public List<Disquera> consultar() {

		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		TypedQuery<Disquera> queryDisquera = (TypedQuery<Disquera>) em.createQuery("FROM Disquera ORDER BY descripcion");

		return queryDisquera.getResultList();

	}

	@Override
	public Disquera consultarById(Long id) {

		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		Disquera disqueraConsultado = em.find(Disquera.class, id);

		if (disqueraConsultado == null) {

			throw new EntityExistsException("La disquera con id" + id + "no se encontro");

		}

		return disqueraConsultado;
	}

}
