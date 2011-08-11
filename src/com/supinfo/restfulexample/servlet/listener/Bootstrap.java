package com.supinfo.restfulexample.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.supinfo.restfulexample.dao.PersistenceManager;
import com.supinfo.restfulexample.search.CompassManager;

public class Bootstrap implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		CompassManager.getInstance().startGps();
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		PersistenceManager.getInstance().close();
	}

}
