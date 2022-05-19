/**
 * 
 */
package com.mijasoftcode.proyectojpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.mijasoftcode.proyectojpa.dao.DisqueraDAO;
import com.mijasoftcode.proyectojpa.dao.impl.DisqueraDAOImpl;
import com.mijasoftcode.proyectojpa.entity.Disquera;

/**
 * @author mijasoftcode
 *
 */

class DisqueraDAOImplTest {
	
	private DisqueraDAO disqueraDAO = new DisqueraDAOImpl();
	
	/**
	 * Test method for {@link com.mijasoftcode.proyectojpa.dao.impl.DisqueraDAOImpl#guardar(com.mijasoftcode.proyectojpa.entity.Disquera)}.
	 */
	@Test
	public void testGuardar() {
		
		Disquera disquera = new Disquera();
		disquera.setDescripcion("Bat-Man");
		disquera.setFechaCreacion(LocalDateTime.now());
		disquera.setEstatus(true);
		
		this.disqueraDAO.guardar(disquera);
	}

	/**
	 * Test method for {@link com.mijasoftcode.proyectojpa.dao.impl.DisqueraDAOImpl#actualizar(com.mijasoftcode.proyectojpa.entity.Disquera)}.
	 */
	@Test
	void testActualizar() {
		Disquera disqueraConsulatada = this.disqueraDAO.consultarById(12L);
		disqueraConsulatada.setDescripcion("Disquera SpiderMan");
		this.disqueraDAO.actualizar(disqueraConsulatada);
	}

	/**
	 * Test method for {@link com.mijasoftcode.proyectojpa.dao.impl.DisqueraDAOImpl#eliminar(com.mijasoftcode.proyectojpa.entity.Disquera)}.
	 */
	@Test
	void testEliminar() {
		Long id = 10L;
		
		this.disqueraDAO.eliminar(id);
	}

	/**
	 * Test method for {@link com.mijasoftcode.proyectojpa.dao.impl.DisqueraDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		
		List<Disquera> disquerasConsultadas = this.disqueraDAO.consultar();
		
		assertTrue(disquerasConsultadas.size() > 0);
		
		disquerasConsultadas.forEach(disquera -> {
			System.out.println("Disquera: " + disquera.getDescripcion());
		});
	}

	/**
	 * Test method for {@link com.mijasoftcode.proyectojpa.dao.impl.DisqueraDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		Disquera disquera = this.disqueraDAO.consultarById(13L);
		
		System.out.println("Disquera: " + disquera.getDescripcion());
	}

}
