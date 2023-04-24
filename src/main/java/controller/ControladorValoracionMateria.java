package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.Materia;
import model.Valoracionmateria;

public class ControladorValoracionMateria {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo2");
	
	/**
	 * 
	 * @param l
	 */
	public static void guardar (Valoracionmateria l) {
		if (l.getId() == 0) {
			insertar(l);
		}
		else {
			modificar(l);
		}
	}
	
	/**
	 * 
	 * @param l
	 */
	public static void insertar (Valoracionmateria l) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * 
	 * @param l
	 */
	public static void modificar (Valoracionmateria l) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(l);
		em.getTransaction().commit();
		em.close();
	}
	

}
