package com.app.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.dto.FourWheeler;
import com.app.dto.TwoWheeler;
import com.app.dto.Vehicle;

public class Test {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Vehicle.class).addAnnotatedClass(TwoWheeler.class)
				.addAnnotatedClass(FourWheeler.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");

		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicleName("Bike");
		twoWheeler.setSteeringTWOWheeler("Bike Steering Handle");

		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setVehicleName("Alto");
		fourWheeler.setSteeringFourWheeler("Alto Steering Wheel");

		session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);

		session.getTransaction().commit();

		session.close();

	}

}
