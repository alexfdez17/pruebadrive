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

import aiss.model.googlemaps.GoogleMapsSearch;

@Path("/location")
public class GoogleMapsResource {

	private static final String GOOGLE_API_KEY = "AIzaSyCWwbCsGSoxkT5ZItUBSDa2AjnTnaYo-vc";		
	private static final Logger log = Logger.getLogger(GoogleMapsResource.class.getName());
	private static GoogleMapsResource instance = null;
	
	public static GoogleMapsResource getInstance(){
		if(instance==null){
			instance = new GoogleMapsResource();
		}
		return instance;
	}
	
	@GET
	@Produces("application/json")
	@Path("/{query}")
	public GoogleMapsSearch getLocationOf(@PathParam("query")String query) throws UnsupportedEncodingException{
		String adress = URLEncoder.encode(query, "UTF-8");
		ClientResource cr = new ClientResource("https://maps.googleapis.com/maps/api/geocode/json?address="+adress+"&key="+GOOGLE_API_KEY);
		GoogleMapsSearch res = cr.get(GoogleMapsSearch.class);
		
		if(res == null){
			throw new NotFoundException("The location for: "+query+" was not successful");
		}else{
		log.log(Level.FINE, "Search success for adress:"+adress);
		return res;
		}
	}
	
}
