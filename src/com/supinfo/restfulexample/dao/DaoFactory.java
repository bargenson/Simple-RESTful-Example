package com.supinfo.restfulexample.dao;

import javax.persistence.EntityManagerFactory;

import org.compass.core.Compass;

import com.supinfo.restfulexample.dao.jpa.JpaMarkDao;
import com.supinfo.restfulexample.dao.jpa.JpaStudentDao;
import com.supinfo.restfulexample.search.CompassManager;

public final class DaoFactory {
	
	private static final DaoFactory INSTANCE = new DaoFactory();
	
	public static DaoFactory getInstance() {
		return INSTANCE;
	}
	
	private final EntityManagerFactory emf;
	private final Compass compass;
	
	private DaoFactory() {
		emf = PersistenceManager.getInstance().getEntityManagerFactory();
		compass = CompassManager.getInstance().getCompass();
	}
	
	public StudentDao getStudentDao() {
		return new JpaStudentDao(emf, compass);
	}

	public MarkDao getMarkDao() {
		return new JpaMarkDao(emf);
	}

}
