package com.mtit.osgi.decimalconverter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegistration;

	/*
	 * static BundleContext getContext() { return context; }
	 */
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting Decimal Converter Service...");
		DecimalConverterService dcService = new DecimalConverterCalculator();
		serviceRegistration = bundleContext.registerService(DecimalConverterService.class.getName(), dcService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stoping Decimal Converter Service...");
		serviceRegistration.unregister();
		//Activator.context = null;
	}

}
