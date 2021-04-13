package com.mtit.osgi.octalconverter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class OctalActivator implements BundleActivator {

	private static BundleContext context;
	ServiceRegistration serviceRegistration;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("Octal service is started");
		
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println("Octal service is stopped");
		
		
	}


}
