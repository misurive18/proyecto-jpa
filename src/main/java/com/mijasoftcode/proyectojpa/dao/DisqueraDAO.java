/**
 * 
 */
package com.mijasoftcode.proyectojpa.dao;

import java.util.List;

import com.mijasoftcode.proyectojpa.entity.Disquera;

/**
 * @author mijasoftcode
 * Interfaz que genera el DAO para las transacciones del CRUD a la tabla de disquera.
 */
public interface DisqueraDAO {

	void guardar(Disquera disquera);
	
	void actualizar(Disquera disquera);
	
	void eliminar(Long id);
	
	List<Disquera> consultar();
	
	Disquera consultarById(Long id);
	
	/**
	 * Metodo que permite consultar con JPQL la disquera a partir de una descripcion.
	 * @param descripcion {@link String} descripcion de la disquera.
	 * @return {@link Disquera} la disquera consultada.
	 */
	Disquera consultarByDescripcionJPQL(String descripcion);
	
	/**
	 * Metodo que permite consultar con SQL Nativo la disquera a partir de una descripcion.
	 * @param descripcion {@link String} descripcion de la disquera.
	 * @return {@link Disquera} la disquera consultada.
	 */
	Disquera consultarByDescripcionNative(String descripcion);
}
