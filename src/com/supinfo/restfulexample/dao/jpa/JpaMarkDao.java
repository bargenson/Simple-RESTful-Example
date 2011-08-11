package com.supinfo.restfulexample.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import com.supinfo.restfulexample.dao.MarkDao;
import com.supinfo.restfulexample.entity.Mark;
import com.supinfo.restfulexample.entity.Student;
import com.supinfo.restfulexample.exception.UnknownItemException;

public class JpaMarkDao implements MarkDao {

	private final EntityManagerFactory emf;
	
	
	public JpaMarkDao(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public Mark addMark(Long idBooster, Mark mark) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			
			Student student = em.find(Student.class, idBooster);
			if(student == null) {
				throw new UnknownItemException(Student.class, idBooster);
			}
			
			mark.setStudent(student);
			em.persist(mark);
			
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
		return mark;
	}

	@Override
	public Mark findMarkByKey(String key) {
		EntityManager em = emf.createEntityManager();
		try {
			Mark mark = em.find(Mark.class, key);
			if(mark == null) {
				throw new UnknownItemException(Mark.class, key);
			}
			return mark;
		} finally {
			em.close();
		}
	}

	@Override
	public void removeMark(String key) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			
			Mark mark = em.find(Mark.class, key);
			if(mark == null) {
				throw new UnknownItemException(Mark.class, key);
			}
			
			em.remove(mark);
			
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Mark> findAllMarksByIdBooster(Long idBooster) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			
			List<Mark> marks = (List<Mark>) 
				em.createQuery(
					"SELECT s.marks FROM Student s " +
					"WHERE s.idBooster = :idBooster"
				)
				.setParameter("idBooster", idBooster)
				.getSingleResult();
			
			em.getTransaction().commit();
			return marks;
		} catch (NoResultException e) {
			throw new UnknownItemException(Student.class, idBooster);
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}

}
