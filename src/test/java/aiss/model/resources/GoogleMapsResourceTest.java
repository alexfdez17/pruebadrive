package aiss.model.resources;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.googlemaps.GoogleMapsSearch;

public class GoogleMapsResourceTest {

	@Test
	public void test() throws UnsupportedEncodingException{
		String adress = "New York, NY, USA";

		GoogleMapsResource google = new GoogleMapsResource();
		GoogleMapsSearch latLon = google.getLocationOf(adress);

		Double lat = 0.;
		Double lng = 0.;

		for (int i = 0; i < latLon.getResults().size(); i++) {
			lat = latLon.getResults().get(i).getGeometry().getLocation().getLat();
			lng = latLon.getResults().get(i).getGeometry().getLocation().getLng();
			
			assertNotNull("The search returned null", latLon);
			assertNotNull("The search returned null lat", lat);
			assertNotNull("The serach returned null lng", lng);
			assertFalse("The search returned 0 results", latLon.getResults().size()==0);
			
			System.out.println("The search for adress: "+adress+", returned lat: "+lat+" and lng: "+lng);

		}
		
		

	}

}
