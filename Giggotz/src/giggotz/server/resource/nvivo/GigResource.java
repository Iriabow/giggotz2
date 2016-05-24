package giggotz.server.resource.nvivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import giggotz.shared.nvivo.Example;
import giggotz.shared.nvivo.Gig;
import giggotz.shared.nvivo.Response;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;


public class GigResource {

	private final String uri="http://www.nvivo.es/api/request.php?";
	private final String key="62747d997af89fcaef4eb0d44e202fb4";
	private final String formato="&format=json";
	
	
	public Response getRespuestaPorCiudad(String ciudad) {
		String ciudadFormateada=daFormato(ciudad);
		//ClientResource rConcierto=null;
		Response r=new Response();
	
	//	try{
			//rConcierto = new ClientResource
				LectorJson lector=new LectorJson(uri+"api_key="+key+"&method=city.getEvents&city="+ciudad+formato);
				
						lector.parse();
					
						
					
					//("http://www.nvivo.es/api/request.php?api_key=62747d997af89fcaef4eb0d44e202fb4&method=city.getEvents&city=Sevilla&format=json");
			 r=lector.getResponse();
	/*	
		}
		catch(ResourceException re){
			System.err.println("Error al buscar el evento: " + rConcierto.getResponse().getStatus());
		}*/
		
		return r;
	}
	
	public Response getRespuestaPorArtista(String artista) {
        String artistaFormateado=daFormato(artista);
		
		Response r=new Response();
	
		//try{
			//rConcierto = new ClientResource
			LectorJson lector=new LectorJson(uri+"api_key="+key+"&method=artist.getEvents&artist="+artistaFormateado+formato);
			lector.parse();
			r=lector.getResponse();
		/*	
		//("http://www.nvivo.es/api/request.php?api_key=62747d997af89fcaef4eb0d44e202fb4&method=artist.getEvents&artist=Iron Maiden&format=json");
			
			r = rConcierto.get(Example.class);
			
					conciertos=r.getResponse().getGigs();
		}
		catch(ResourceException re){
			System.err.println("Error al buscar el evento: " + rConcierto.getResponse().getStatus());
		}*/
			
		
		return r;
	}
	private String daFormato(String cadena){
		String cadenaFormateada="";
		cadena.trim();
		if(cadena.contains(" ")){
			
			String[] fragmentosCadena=cadena.split(" ");
			
			for(int i=0;i<fragmentosCadena.length;i++){
				if(!fragmentosCadena[i].contains(" ")){
					cadenaFormateada=cadenaFormateada+fragmentosCadena[i]+"%20";
				}
			}
			
		}else{
			cadenaFormateada=cadena;
		}
		return cadenaFormateada;
	}
}
