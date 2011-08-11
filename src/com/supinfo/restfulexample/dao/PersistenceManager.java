package com.supinfo.restfulexample.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class PersistenceManager {
	
	private static final PersistenceManager INSTANCE = new PersistenceManager();
	
	public static PersistenceManager getInstance() {
		return INSTANCE;
	}
	
	private final EntityManagerFactory emf;
	
	private PersistenceManager() {
		emf = Persistence.createEntityManagerFactory("restful-example");
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
	
	public void close() {
		if(emf.isOpen()) emf.close();
	}

}
