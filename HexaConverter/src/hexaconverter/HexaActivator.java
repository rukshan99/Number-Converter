package hexaconverter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class HexaActivator implements BundleActivator{
	
	private static BundleContext context;
	ServiceRegistration serviceRegistration;

	static BundleContext getContext() {
		return context;
	}

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Hexa Converter is started");
		HexaService hexaService = new HexaConverterCalculator();
		serviceRegistration = bundleContext.registerService(HexaService.class.getName(), hexaService, null);
		
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		System.out.println("Hexa Converter is stopped");
		serviceRegistration.unregister();
		
	}

}