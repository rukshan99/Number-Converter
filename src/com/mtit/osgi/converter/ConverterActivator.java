package com.mtit.osgi.converter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import com.mtit.osgi.decimalconverter.DecimalConverterService;


public class ConverterActivator implements BundleActivator {

	private static BundleContext context;
	
	public ServiceRegistration serviceRegistration;
	

	public static ServiceTracker decimalTracker,binaryTracker,octalTracker,hexaTracker;
	public static DecimalConverterService decimalService;
	public static BinaryService binaryService;
	public static OctalService octalService;
	public static HexaService hexaService;

	

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Unit Converter Displayer service is started");
		ConverterService cds = new Converter();
		serviceRegistration = bundleContext.registerService(ConverterService.class.getName(), cds, null);
		
		decimalTracker = new ServiceTracker(bundleContext,DecimalService.class.getName(),null);
		binaryTracker = new ServiceTracker(bundleContext,BinaryService.class.getName(),null);
		octalTracker = new ServiceTracker(bundleContext, OctalService.class.getName(), null);
		hexaTracker = new ServiceTracker(bundleContext, HexaService.class.getName(), null);
	
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Converter  service is stopped");
		serviceRegistration.unregister();
	}

	public static boolean DecimalChecker() {
		decimalTracker.open();
		decimalService = (DecimalService) decimalTracker.getService();
		
		if (decimalService != null)
			return true;
		else
			return false;
	}
	
	public static boolean energyChecker() {
		binaryTracker.open();
		binaryService = (BinaryService) binaryTracker.getService();
		
		if (binaryService != null)
			return true;
		else
			return false;
	}
	
	public static boolean lengthChecker() {
		octalTracker .open();
		octalService = (OctalService) octalTracker.getService();
		
		if (octalService != null)
			return true;
		else
			return false;
	}
	public static boolean StorageChecker() {
		hexaTracker .open();
		hexaService = (HexaService) hexaTracker.getService();
		
		if (hexaService != null)
			return true;
		else
			return false;
	}

}
