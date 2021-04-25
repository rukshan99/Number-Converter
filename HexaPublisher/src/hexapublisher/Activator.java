package hexapublisher;

import org.osgi.framework.BundleActivator;


import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceRegistration serviceRegistration;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Hexa Publisher is started");
		HexaService hexaService = new HexaConverterCalculator();
		serviceRegistration = bundleContext.registerService(HexaService.class.getName(), hexaService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Hexa Publisher is stopped");
		serviceRegistration.unregister();
		
	}

}
