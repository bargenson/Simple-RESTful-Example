package com.supinfo.restfulexample.search;

import javax.persistence.EntityManagerFactory;

import org.compass.core.Compass;
import org.compass.core.config.CompassConfiguration;
import org.compass.core.config.CompassEnvironment;
import org.compass.gps.CompassGps;
import org.compass.gps.device.jpa.JpaGpsDevice;
import org.compass.gps.device.support.parallel.SameThreadParallelIndexExecutor;
import org.compass.gps.impl.SingleCompassGps;

import com.supinfo.restfulexample.dao.PersistenceManager;
import com.supinfo.restfulexample.entity.Student;

public final class CompassManager {
	
	private final static CompassManager INSTANCE = new CompassManager();
	
	public static CompassManager getInstance() {
		return INSTANCE;
	}

	private final Compass compass;
	private final CompassGps compassGps;
	
	private CompassManager() {
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		
		compass = new CompassConfiguration().setConnection("gae://index")
				.setSetting(CompassEnvironment.ExecutorManager.EXECUTOR_MANAGER_TYPE, "disabled")
				.addScan(Student.class.getPackage().getName())
				.buildCompass();

		compassGps = new SingleCompassGps(compass);
		JpaGpsDevice jpaGpsDevice = new JpaGpsDevice("appengine", emf);
		jpaGpsDevice.setParallelIndexExecutor(new SameThreadParallelIndexExecutor());
		compassGps.addGpsDevice(jpaGpsDevice);
	}
	
	public Compass getCompass() {
		return compass;
	}
	
	public void startGps() {
		compassGps.start();
	}
	
	public void index() {
		compassGps.index();		
	}

}
