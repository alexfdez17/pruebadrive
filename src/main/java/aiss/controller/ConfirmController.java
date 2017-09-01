package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmController extends HttpServlet {
	private static final Logger log = Logger.getLogger(DriveFileListController.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String id = req.getParameter("id");
		String link = req.getParameter("link");
		
		if(!link.equals("")){
			req.setAttribute("link", link);
			req.setAttribute("id", id);
			
			req.getRequestDispatcher("/confirm.jsp").forward(req,resp);
			
		}else{
			log.info("Trying to acces to google drive without an acces token, redirecting to OAuth servlet");
			req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req,resp);
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req,resp);
	}
}