package aiss.model.resources;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.flickr.PhotoSearch;
import aiss.model.googlemaps.GoogleMapsSearch;

public class FlickrResourceTest {

	@Test
	public void FlickrTest1() throws UnsupportedEncodingException{
		Double lat = 40.7127837;
		Double lng = -74.00594130000002;
		
		FlickrResource flickr = new FlickrResource();
		PhotoSearch photos = flickr.getPhotosByLocation(lat, lng);
		
		assertNotNull("The search returned null", photos);
		assertNotNull("The search returned null", photos.getPhotos());
		assertFalse("The search returned 0 photos", photos.getPhotos().getPhoto().size()==0);
		
		System.out.println("The search for lat: "+lat+" y lon: "+lng+" resturned: "+photos.getPhotos().getPhoto().size()+" photos");
		
	}
	
	@Test
	public void FlickrTest2() throws UnsupportedEncodingException{
		String adress = "New York, NY, USA";
		
		GoogleMapsResource google = new GoogleMapsResource();
		GoogleMapsSearch latLon = google.getLocationOf(adress);
		
		Double lat = 0.;
		Double lng = 0.;
		
		FlickrResource flickr = new FlickrResource();
		PhotoSearch photos = null;
		
		for(int i=0;i<latLon.getResults().size();i++){
			lat = latLon.getResults().get(i).getGeometry().getLocation().getLat();
			lng = latLon.getResults().get(i).getGeometry().getLocation().getLng();
			
			photos = flickr.getPhotosByLocation(lat, lng);
			
			assertNotNull("The search returned null", photos);
			assertNotNull("The search returned null", photos.getPhotos());
			assertFalse("The search returned 0 photos", photos.getPhotos().getPhoto().size()==0);
		}
		
	}

}
