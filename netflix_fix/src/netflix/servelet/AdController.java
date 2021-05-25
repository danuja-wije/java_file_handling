package netflix.servelet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import netflix.model.AdModel;
import netflix.service.AdService;
import netflix.service.AdServiceImpl;

/**
 * Servlet implementation class AdController
 */
@WebServlet("/AdController")
@MultipartConfig
public class AdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      AdService adService = null;
      
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdController() {
        super();
        adService = new AdServiceImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String action = request.getParameter("action");
				
				switch (action) {
				case "FORM" :
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Views/form.jsp");
					dispatcher.forward(request, response);
					break;
				case "DELETE" :
					deleteAd(request, response);
					break;
				case "EDIT" :
					editAd(request, response);
					break;
				default:addAd(request, response);
					break;
				}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		switch (action) {
		case "ADD" :
			addAd(request, response);
			break;
		case "UPDATE" :
			updateAd(request, response);
			break;
		default:addAd(request, response);
			break;
		}
	
	}

	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");

		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
	
	public void addAd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new Date();
		String d = date.toString().replace(" ", "").replace(":", "_");
		//get thumb file
		final String thumbPath = "C:\\Users\\LEGION\\Desktop\\ku\\netflix_fix\\WebContent\\Uploads\\Thumbs";
		final Part thumbFilePart = request.getPart("thumbFile");
		final String thumbFileName =getFileName(thumbFilePart);
		final String path = "C:\\Users\\LEGION\\Desktop\\ku\\netflix_fix\\WebContent\\Uploads";
		final Part filePart = request.getPart("file");
		
		final String fileName = getFileName(filePart);

		OutputStream out = null;
		OutputStream tout = null;
		InputStream filecontent = null;
		InputStream thumContent = null;
		final PrintWriter writer = response.getWriter();

		try {
			//for thumb
			tout = new FileOutputStream(new File(thumbPath + File.separator + thumbFileName));
			thumContent = thumbFilePart.getInputStream();
			
			//for content
			out = new FileOutputStream(new File(path + File.separator + fileName));
			filecontent = filePart.getInputStream();

			int read = 0;
			int tRead = 0;
			final byte[] thumbByte = new byte[thumContent.available()];
			final byte[] bytes = new byte[filecontent.available()];

			while ((tRead = thumContent.read(thumbByte)) != -1) {
				tout.write(thumbByte, 0, tRead);
			}
			

			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
		
			AdModel adModel = new AdModel(request.getParameter("adname"), request.getParameter("username"), request.getParameter("category"), request.getParameter("type"), request.getParameter("period"), fileName,thumbFileName);
			if(adService.addAd(adModel)) {
				
				  List<AdModel>adList = adService.allAds(); System.out.println(adList);
				  request.setAttribute("ads", adList);
				  RequestDispatcher dispatcher =request.getRequestDispatcher("/Views/contentView.jsp");
				  dispatcher.forward(request, response);
				 
				//writer.println("New file " + fileName + " created at " + path);
			}
			
		} catch (Exception fne) {
			writer.println("You either did not specify a file to upload or are "
					+ "trying to upload a file to a protected or nonexistent " + "location.");
			writer.println("<br/> ERROR: " + fne.getMessage());

		} finally {
			if (out != null) {
				out.close();
			}
			if (filecontent != null) {
				filecontent.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
	}
	public void deleteAd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		
		if (adService.deleteAd(Integer.parseInt(id))) {
			 RequestDispatcher dispatcher =request.getRequestDispatcher("/Views/contentView.jsp");
			  dispatcher.forward(request, response);
		}
		
	}
	public void editAd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		
		AdModel ad = adService.getAdById(Integer.parseInt(id));
		 request.setAttribute("ad", ad);
		 RequestDispatcher dispatcher =request.getRequestDispatcher("/Views/singleAd.jsp");
		 dispatcher.forward(request, response);
	}
	public void updateAd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String thumbPath = "C:\\Users\\LEGION\\Desktop\\ku\\netflix_fix\\WebContent\\Uploads\\Thumbs";
		final Part thumbFilePart = request.getPart("thumbFile");
		final String thumbFileName =getFileName(thumbFilePart);
		final String path = "C:\\Users\\LEGION\\Desktop\\ku\\netflix_fix\\WebContent\\Uploads";
		final Part filePart = request.getPart("file");
		
		final String fileName = getFileName(filePart);

		OutputStream out = null;
		OutputStream tout = null;
		InputStream filecontent = null;
		InputStream thumContent = null;
		final PrintWriter writer = response.getWriter();

		try {
			//for thumb
			tout = new FileOutputStream(new File(thumbPath + File.separator + thumbFileName));
			thumContent = thumbFilePart.getInputStream();
			
			//for content
			out = new FileOutputStream(new File(path + File.separator + fileName));
			filecontent = filePart.getInputStream();

			int read = 0;
			int tRead = 0;
			final byte[] thumbByte = new byte[thumContent.available()];
			final byte[] bytes = new byte[filecontent.available()];

			
			while ((tRead = thumContent.read(thumbByte)) != -1) {
				tout.write(thumbByte, 0, tRead);
			}
			

			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
		
			AdModel adModel = new AdModel();
			adModel.setAdName(request.getParameter("adname"));
			adModel.setCategory(request.getParameter("category"));
			adModel.setId(Integer.parseInt(request.getParameter("id")));
			adModel.setPath(fileName);
			adModel.setThumb(thumbFileName);
			adModel.setPeriod(request.getParameter("period"));
			if(adService.updateAd(adModel)) {
				
				  List<AdModel>adList = adService.allAds(); System.out.println(adList);
				  request.setAttribute("ads", adList);
				  RequestDispatcher dispatcher =request.getRequestDispatcher("/Views/contentView.jsp");
				  dispatcher.forward(request, response);
				 
				//writer.println("New file " + fileName + " created at " + path);
			}
			
		} catch (Exception fne) {
			writer.println("You either did not specify a file to upload or are "
					+ "trying to upload a file to a protected or nonexistent " + "location.");
			writer.println("<br/> ERROR: " + fne.getMessage());

		} finally {
			if (out != null) {
				out.close();
			}
			if (filecontent != null) {
				filecontent.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
		
	}

}
