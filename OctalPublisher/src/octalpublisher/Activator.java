package octalpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {


	ServiceRegistration octalPublishServiceRegistration;
	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Octal publisher Started");
		OctalService octalService = new OctalConverter();
		octalPublishServiceRegistration = bundleContext.registerService(OctalService.class.getName(),octalService,null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println("Octal publisher Stopped");
		octalPublishServiceRegistration.unregister();
		
	}


}
