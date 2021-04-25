package hexasubscriber;



import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import hexapublisher.HexaService;



public class Activator implements BundleActivator {

	ServiceReference serviceReference;



	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Hexa Subscriber stared");
		serviceReference = bundleContext.getServiceReference(HexaService.class.getName());
	    HexaService hexaService = (HexaService) bundleContext.getService(serviceReference);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Hexa Subscriber Stopped");
		bundleContext.ungetService(serviceReference);
	}

}
