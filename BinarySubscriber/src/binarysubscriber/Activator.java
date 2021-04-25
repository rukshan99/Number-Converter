package binarysubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import binarypublisher.BinaryService;

public class Activator implements BundleActivator {
	ServiceReference serviceReference;


	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Start Binary Subsciber Service");	
		serviceReference = bundleContext.getServiceReference(BinaryService.class.getName());
	    BinaryService binarypublish = (BinaryService) bundleContext.getService(serviceReference);
	    
	    
	}

	public void stop(BundleContext bundleContext) throws Exception {
		bundleContext.ungetService(serviceReference);
		System.out.println("Stop Binary Subsciber Service");
	}

}
