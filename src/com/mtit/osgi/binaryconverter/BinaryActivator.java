package com.mtit.osgi.binaryconverter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class BinaryActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Binary Converter is started");
		BinaryService binaryService = new BinaryCalculate();
		serviceRegistration = bundleContext.registerService(BinaryService.class.getName(), binaryService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Binary Converter is stopped");
		serviceRegistration.unregister();
	}

}
