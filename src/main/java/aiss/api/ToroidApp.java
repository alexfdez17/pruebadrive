package aiss.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;


import aiss.model.resources.FlickrResource;
import aiss.model.resources.GoogleDriveResource;
import aiss.model.resources.GoogleMapsResource;



public class ToroidApp extends Application{

	private Set<Object> o = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	
	public ToroidApp(){
		o.add(FlickrResource.getInstance());
		o.add(GoogleMapsResource.getInstance());
		o.add(GoogleDriveResource.getInstance());
	}
	
	public Set<Class<?>> getClasses(){
		return classes;
	}
	
	public Set<Object> getO(){
		return o;
	}
}
