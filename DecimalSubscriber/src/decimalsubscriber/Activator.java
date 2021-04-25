package decimalsubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import decimalpublisher.DecimalConverterService;


public class Activator implements BundleActivator {

	ServiceReference serviceReference;


	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Start Decimal Subsciber Service");	
		serviceReference = bundleContext.getServiceReference(DecimalConverterService.class.getName());
	    DecimalConverterService decimalpublish = (DecimalConverterService) bundleContext.getService(serviceReference);
	    
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stop Decimal Subscriber Service");
		bundleContext.ungetService(serviceReference);
	}

}
