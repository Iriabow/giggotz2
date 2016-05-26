package giggotz.server.rpc.wikipedia;

import giggotz.client.rpc.wikipedia.WikipediaService;
import giggotz.server.resource.wikipedia.WikiResource;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class WikipediaServiceImpl extends RemoteServiceServlet implements WikipediaService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	WikiResource w = new WikiResource();
	
	@Override
	public String getExtract(String artist) {
		return w.getExtract(artist);
	}

}
