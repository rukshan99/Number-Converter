package binarypublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	ServiceRegistration binaryPublishServiceRegistration;
	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Binary publisher Started");
		BinaryService binaryService = new BinaryCalculate();
		binaryPublishServiceRegistration = bundleContext.registerService(BinaryService.class.getName(),binaryService,null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println("Binary publisher Stopped");
		binaryPublishServiceRegistration.unregister();
		
	}

}
