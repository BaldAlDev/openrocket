package info.openrocket.swing.utils;

import info.openrocket.core.plugin.PluginModule;
import info.openrocket.core.startup.Application;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * Simple class which can be used to build basic applications.
 * 
 * It initializes the Application object with a Guice Injector configured with
 * the CoreServicesModule and PluginModule.
 * 
 * @author kruland
 *
 */
public class BasicApplication {
	
	public final void initializeApplication() {
		Module applicationModule = new CoreServicesModule();
		Module pluginModule = new PluginModule();
		
		Injector injector = Guice.createInjector(applicationModule, pluginModule);
		Application.setInjector(injector);
	}
	
}
