package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.restlet.resource.ClientResource;

import aiss.model.flickr.PhotoSearch;
@Path("/photos")
public class FlickrResource {

	private static final String FLICKR_API_KEY = "ec1948bb8bea5dbb4cf3e5feadf557a1";		
	private static final Logger log = Logger.getLogger(FlickrResource.class.getName());
	private static FlickrResource instance = null;
	
	public static FlickrResource getInstance(){
		if(instance==null){
			instance = new FlickrResource();
		}
		return instance;
		}
		
	
	
	@GET
	@Produces("application/json")
	@Path("/{lat}/{lng}")
	public PhotoSearch getPhotosByLocation(@PathParam("lat")Double lat, @PathParam("lng")Double lng) throws UnsupportedEncodingException{
		String latitud = URLEncoder.encode(lat.toString(), "UTF-8");
		String longitud = URLEncoder.encode(lng.toString(), "UTF-8");
		
		ClientResource cr = new ClientResource("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key="+FLICKR_API_KEY+"&accuracy=16&lat="+ latitud + "&lon=" + longitud + "&per_page=20&page=10&format=json&nojsoncallback=1");
		PhotoSearch res = cr.get(PhotoSearch.class);
		if(res == null){
			throw new NotFoundException("The search for the photos in lat: "+lat+" and lon: "+lng+" was not successful");
		}else{
			log.log(Level.FINE, "Photo search success for lat:"+lat+" and long:"+lng);
			return res;
		}
		
		
	}
}





