package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.flickr.PhotoSearch;
import aiss.model.googlemaps.GoogleMapsSearch;
import aiss.model.resources.FlickrResource;
import aiss.model.resources.GoogleMapsResource;




/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(SearchController.class.getName());
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null;
		
		log.log(Level.FINE, "Searching for adress: " + query);
		GoogleMapsResource google = new GoogleMapsResource();
		GoogleMapsSearch results = google.getLocationOf(query);
		
		log.log(Level.FINE, "Searching for Flickr photos: " + query);
		FlickrResource flickr = new FlickrResource();
		PhotoSearch photos = flickr.getPhotosByLocation(results.getResults().get(0).getGeometry().getLocation().getLat(), results.getResults().get(0).getGeometry().getLocation().getLng());
		/*Location latLon = null;
		for(Result r : results.getResults()){
			if(query==r.getFormattedAddress()){
				latLon = r.getGeometry().getLocation();
			}
			
		}
		
		Double lat = latLon.getLat();
		Double lng = latLon.getLng();
		
		
		log.log(Level.FINE, "Searching for Flickr photos: " + query);
		FlickrResource flickr = new FlickrResource();
		PhotoSearch photos = flickr.getPhotosByLocation(lat, lng);*/

		if (results != null && photos!=null) {
			rd = request.getRequestDispatcher("/success.jsp");
			request.setAttribute("photos", photos.getPhotos());
			request.setAttribute("lat", results.getResults().get(0).getGeometry().getLocation().getLat());
			request.setAttribute("lng", results.getResults().get(0).getGeometry().getLocation().getLng());
		} else {
			log.log(Level.SEVERE, "Flickr object: " + results);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
