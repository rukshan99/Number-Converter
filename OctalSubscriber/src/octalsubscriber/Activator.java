package octalsubscriber;


import octalpublisher.OctalService;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {


	ServiceReference serviceReference;


	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Start Octal Subsciber Service");	
		serviceReference = bundleContext.getServiceReference(OctalService.class.getName());
	    OctalService octalpublish = (OctalService) bundleContext.getService(serviceReference);

	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stop Octal Subsciber Service");	
		bundleContext.ungetService(serviceReference);
	}
}
