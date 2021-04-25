package convertersubscriber;

import binarypublisher.BinaryService;
import decimalpublisher.DecimalConverterService;
import hexapublisher.HexaService;
import octalpublisher.OctalService;
import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;


public class Activator implements BundleActivator {

private static BundleContext context;
	
	public ServiceRegistration serviceRegistration;
	

	public static ServiceTracker decimalTracker,binaryTracker,octalTracker,hexaTracker;
	public static DecimalConverterService decimalService;
	public static BinaryService binaryService;
	public static OctalService octalService;
	public static HexaService hexaService;
	

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Number Converter Displayer service is started");
		ConverterService cds = new Converter();
		serviceRegistration = bundleContext.registerService(ConverterService.class.getName(), cds, null);
		
		decimalTracker = new ServiceTracker(bundleContext,DecimalConverterService.class.getName(),null);
		binaryTracker = new ServiceTracker(bundleContext,BinaryService.class.getName(),null);
		octalTracker = new ServiceTracker(bundleContext, OctalService.class.getName(), null);
		hexaTracker = new ServiceTracker(bundleContext, HexaService.class.getName(), null);
	
		cds.startService();
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Converter service is stopped");
		serviceRegistration.unregister();
	}

	public static boolean DecimalChecker() {
		decimalTracker.open();
		decimalService = (DecimalConverterService) decimalTracker.getService();
		
		if (decimalService != null)
			return true;
		else
			return false;
	}
	
	public static boolean BinaryChecker() {
		binaryTracker.open();
		binaryService = (BinaryService) binaryTracker.getService();
		
		if (binaryService != null)
			return true;
		else
			return false;
	}
	
	public static boolean OctalChecker() {
		octalTracker .open();
		octalService = (OctalService) octalTracker.getService();
		
		if (octalService != null)
			return true;
		else
			return false;
	}
	public static boolean HexaChecker() {
		hexaTracker .open();
		hexaService = (HexaService) hexaTracker.getService();
		
		if (hexaService != null)
			return true;
		else
			return false;
	}

}
