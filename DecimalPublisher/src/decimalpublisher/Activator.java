package decimalpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration decimalPublishServiceRegistration;
	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Decimal publisher Started");
		DecimalConverterService decimalConverterService = new DecimalConverterCalculater();
		decimalPublishServiceRegistration = bundleContext.registerService(DecimalConverterService.class.getName(),decimalConverterService,null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println("Decimal publisher Stopped");
		decimalPublishServiceRegistration.unregister();
		
	}

}
