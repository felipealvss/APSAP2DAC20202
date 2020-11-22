package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import bo.MusicalInstrument;
import util.JPAUtil;

public class MusicalInstrumentDAO {

	// Save registers on Database - INSERT INTO ...
	public static void insertMusicaInstrument(MusicalInstrument mi) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		em.persist(mi);
		em.getTransaction().commit();
		em.close();
	}
	
	// List all the registers on the Database - SELECT * ...
	@SuppressWarnings("unchecked")
	public static List<MusicalInstrument> selectAllMusicalInstrument() {
		EntityManager em = JPAUtil.createEntityManager();
		Query query = em.createQuery("select mi from MusicalInstrument mi");
		List<MusicalInstrument> list = query.getResultList();
		return list;
	}
	
	// List a register by Id - SELECT ... WHERE ...
	public static MusicalInstrument selectMusicalInstrumentById(Integer miId) {
		EntityManager em = JPAUtil.createEntityManager();
		MusicalInstrument mi = em.find(MusicalInstrument.class, miId);
		em.close();
		return mi;
	}
	
	// Modify registers that is already on the Database - ALTER TABLE ...
	public static void updateMusicalInstrumentById(MusicalInstrument mi) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		em.merge(mi);
		em.getTransaction().commit();
		em.close();
	}
	
	// Delete register from the Database by Id - DELETE ... WHERE ...
	public static void deleteMusicalInstrumentById(MusicalInstrument mi) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		mi = em.find(MusicalInstrument.class, mi.getId());
		em.remove(mi);
		em.getTransaction().commit();
		em.close();
	}
	
	// Count the quantity of registers on the Database
	@SuppressWarnings("unchecked")
	public static List<MusicalInstrument> countMusicalInstrument() {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select count(mi) from MusicalInstrument mi");
		List<MusicalInstrument> count = query.getResultList();
		em.close();
		return count;
	}
}
