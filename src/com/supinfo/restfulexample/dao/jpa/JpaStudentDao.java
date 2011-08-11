package com.supinfo.restfulexample.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.compass.core.Compass;
import org.compass.core.CompassHit;
import org.compass.core.CompassHits;
import org.compass.core.CompassSearchSession;

import com.supinfo.restfulexample.dao.StudentDao;
import com.supinfo.restfulexample.entity.Student;
import com.supinfo.restfulexample.exception.ItemAlreadyExistException;
import com.supinfo.restfulexample.exception.UnknownItemException;

public class JpaStudentDao implements StudentDao {

	private final EntityManagerFactory emf;
	private final Compass compass;
	
	
	public JpaStudentDao(EntityManagerFactory emf, Compass compass) {
		this.emf = emf;
		this.compass = compass;
	}
	
	@Override
	public void addStudent(Student student) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			
			if(em.find(Student.class, student.getIdBooster()) != null) {
				throw new ItemAlreadyExistException(student);
			}
			
			em.persist(student);
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}

	@Override
	public Student findStudentByIdBooster(Long idBooster) {
		EntityManager em = emf.createEntityManager();
		try {
			Student result = em.find(Student.class, idBooster);
			if(result == null) {
				throw new UnknownItemException(Student.class, idBooster);
			}
			return result;
		} finally {
			em.close();
		}
	}

	@Override
	public void updateStudent(Student student) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(student);
			em.getTransaction().commit();
		} catch (IllegalArgumentException e) {
			throw new UnknownItemException(Student.class, student.getIdBooster());
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}

	@Override
	public void removeStudentByIdBooster(Long idBooster) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Student student = em.find(Student.class, idBooster);
			if(student != null) { 
				em.remove(student);
				em.getTransaction().commit();
			} else {
				throw new UnknownItemException(Student.class, idBooster);
			}
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}

	@Override
	public void removeStudent(Student student) {
		removeStudentByIdBooster(student.getIdBooster());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {
		List<Student> result = new ArrayList<Student>();
		
		EntityManager em = emf.createEntityManager();
		try {
			result.addAll(em.createQuery("SELECT s FROM Student s").getResultList());
		} finally {
			em.close();
		}
		
		return result;
	}

	@Override
	public List<Student> searchStudent(String query) {
		ArrayList<Student> results = new ArrayList<Student>();
		
		CompassSearchSession searchSession = compass.openSearchSession();
		try {
			CompassHits hits = searchSession.find(query);
			for (CompassHit compassHit : hits) {
				results.add((Student) compassHit.data());
			}
		} finally {
			searchSession.close();
		}
		
		return results;
	}

}
