package giggotz.server.resource.wikipedia;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class WikiResource {

	private String uri = "https://es.wikipedia.org/w/api.php?action=query&prop=extracts&exintro&explaintext&titles=";

	public String getExtract(String artist) {
		
		ClientResource cr = null;
		String all = null;
		String[] llavesIzq = null;
		String res = null;
		
		try{
			
			cr = new ClientResource(uri + artist + "&format=json");
			all = cr.get(String.class);
			llavesIzq = all.split(":");
			res = llavesIzq[8];
			//TODO QUITAR LOS PARENTESIS Y LOS RETORNOS DE CARRO
		
		} catch (ResourceException re) {
			System.err.println("Error intentando obtener la clase principal: " + cr.getResponse().getStatus());
		}
		
		return res;	
	}
}
