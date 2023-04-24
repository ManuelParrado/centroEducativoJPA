package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Materia;

public class ControladorMateria {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo2");
	
	/**
	 * 
	 * @return
	 */
	public static List<Materia> findAll() {
		
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM materia;", Materia.class);
		List<Materia> l = (List<Materia>) q.getResultList();
		
		em.close();
		return l;
	}


}
