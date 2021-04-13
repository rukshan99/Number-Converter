package com.mtit.osgi.hexaconverter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class HexaActivator implements BundleActivator{

	@Override
	public void start(BundleContext arg0) throws Exception {
		System.out.println("Hexa Converter is started");
		
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		System.out.println("Hexa Converter is stopped");
		
	}

}
