package giggotz.client;

import giggotz.client.rpc.nvivo.GigService;
import giggotz.client.rpc.nvivo.GigServiceAsync;
import giggotz.shared.nvivo.Artist;
import giggotz.shared.nvivo.Gig;
import giggotz.shared.nvivo.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



















import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ConciertosView extends Composite{
    private final GigServiceAsync gigService=GWT.create(GigService.class);
	private final VerticalPanel panel;
	//Estas dos listas sirven para cambiar dinamicamente los colores.
	private final List<DecoratorPanel> listaDecPanel=new ArrayList<DecoratorPanel>();
	private final List<Panel> listaDeIndices=new ArrayList<Panel>();
	private HorizontalPanel panelPaginas=new HorizontalPanel();
	
   
	
	public ConciertosView(Map<String,Object> params){
		
		panel=new VerticalPanel();
		initWidget(panel);
		//panel.setSize("500px", "1000px");
		//panel.add(b);
		//panel.add(new Label("sfadas"));
		ponConciertos(params);
		
	}
	//Básicamente esto crea la vista de conciertos además de gestionar la llamada a la API y los errores.
	private void ponConciertos(Map<String,Object> params){
		//Label error=new Label("No se ha encontrado resultados que coincidan con la busqueda");
		
		if(params.get("tipoBusqueda").equals("0")){
			gigService.getRespuestaPorArtista((String) params.get("busqueda"), new AsyncCallback<Response>(){

				
				public void onFailure(Throwable cosa) {
					 Giggotz.p.clear();
					Map<String,Object> params=new HashMap<String,Object>();
					 params.put("failure","Error:"+cosa.getMessage());
					 Giggotz.go("failure",params);
				 
				}

				public void onSuccess(Response response) {
				
					if(response.getStatus().equals("error")){
						Giggotz.p.clear();
						Map<String,Object> params=new HashMap<String,Object>();
					    params.put("busquedaFallida","No se han encontrado conciertos del artista buscado");
						Giggotz.go("init",params);
				
					
					}else{
						agregaPanelesConcierto(response);
				 }
					
				}	
				});
		}else if(params.get("tipoBusqueda").equals("1")){
			gigService.getRespuestaPorCiudad((String) params.get("busqueda"), new AsyncCallback<Response>(){

				
				public void onFailure(Throwable cosa) {
					 Giggotz.p.clear();
					 Map<String,Object> params=new HashMap<String,Object>();
					 params.put("failure","Error: "+cosa.getMessage());
					 Giggotz.go("failure",params);				
				}

				public void onSuccess(Response response) {
					if(response.getStatus().equals("error")){
						Giggotz.p.clear();
						Map<String,Object> params=new HashMap<String,Object>();
					    params.put("busquedaFallida","No se han encontrado conciertos en la ciudad buscada");
						Giggotz.go("init",params);
					
					
					}else{
					 
						agregaPanelesConcierto(response);
						
				  }	
				 }	
				});
		}
	}
	
	//Este método se encarga de agregar los distintos paneles que conforman la lista de conciertos.
	private void agregaPanelesConcierto(Response response){
		List<Gig> conciertos=response.getGigs();
		conciertos.remove(conciertos.size()-1);
		Integer nPaginas=(conciertos.size())/4;
		if((conciertos.size()%4)!=0){
			nPaginas++;
		}
		int toI;
		if(nPaginas>1){
			toI=4;
		}else{
			toI=conciertos.size();
		}
	    VerticalPanel conjunto4Conciertos=new VerticalPanel();
		 
		for(Gig g:conciertos.subList(0,toI)){
			    DecoratorPanel dP=getPanelConcierto(g);
			    conjunto4Conciertos.add(dP);
				listaDecPanel.add(dP);
				conjunto4Conciertos.add(dP);
				
		}
		panel.add(conjunto4Conciertos);
		panel.setSpacing(10);
		//getPanelIndices(nPaginas,conciertos,conjunto4Conciertos);
		panelPaginas=getPanelIndices(nPaginas,conciertos,conjunto4Conciertos);
		panel.add(panelPaginas);
		listaDeIndices.get(0).getElement().getStyle().setColor("blue");
		
		/*
		for(Gig g:conciertos){
			 DecoratorPanel dP=getPanelConcierto(g);	
			 panel.add(dP);
			 listaDecPanel.add(dP);
			 panel.setSpacing(10);
       }
       */
	}
	
	//Genera la lista de página de conciertos.
	private HorizontalPanel getPanelIndices(final Integer nPaginas,final List<Gig> conciertos,
			                                final VerticalPanel conjunto4Conciertos){
      HorizontalPanel indicesPagina=new HorizontalPanel();
      Label descripcionPaginas=new Label("Páginas: ");
      descripcionPaginas.setStyleName("mainText");
      indicesPagina.add(descripcionPaginas);
      indicesPagina.setSpacing(10);
      
      for(Integer i=1;i<=nPaginas;i++){
    	  final int u=i;
    	  final Label nPagina=new Label(i.toString()+"/");
    	  
    	  nPagina.setStyleName("mainText");
    	  final HorizontalPanel nPaginaPanel=new HorizontalPanel();
    	  nPaginaPanel.add(nPagina);
    	  nPaginaPanel.sinkEvents(Event.ONCLICK);
    	  nPaginaPanel.addDomHandler(new ClickHandler(){

  			@Override
  			public void onClick(ClickEvent event) {
  				conjunto4Conciertos.clear();
  				listaDecPanel.clear();
  				int fromI=u*4-4;
  				int toI;
  				if(u==nPaginas){
  					toI=conciertos.size();
  				}
  				else{
  					toI=u*4;
  				}
  				for(Panel p:listaDeIndices){
  					p.getElement().getStyle().setColor("black");
  				}
  				
  				listaDeIndices.get(u-1).getElement().getStyle().setColor("blue");
  				
  				//listaDeIndices.get(u-1).getElement().getStyle().setColor("blue");
  				
  				for(Gig g:conciertos.subList(fromI,toI)){
  					
  					DecoratorPanel dP=getPanelConcierto(g);
  					conjunto4Conciertos.add(dP);
  					listaDecPanel.add(dP);
  					conjunto4Conciertos.setSpacing(5);
  					//panel.add(getPanelConcierto(g));
  					
  				}
  				panel.setSpacing(10);
  				//panel.add(getPanelIndices(nPaginas,conciertos));
  				
  			}
  			
  		  },ClickEvent.getType() );
    	  if(!(listaDeIndices.contains(nPaginaPanel))){
    	  listaDeIndices.add(nPaginaPanel);
    	  }
    	  indicesPagina.add(nPaginaPanel);
    	  indicesPagina.setSpacing(5);
    	  
      }
      return indicesPagina;
	}
	
	//Genera cada panel individual para cada concierto.
	private DecoratorPanel getPanelConcierto(final Gig concierto){
		final DecoratorPanel decPanel = new DecoratorPanel();
		HorizontalPanel hPanelPrincipal=new HorizontalPanel();
		String imageUrl=concierto.getImages().getMedium();
		Image foto;
		if(imageUrl.contains("http") || imageUrl.contains("https")){
		  foto=new Image(imageUrl);
		}else{
		  foto=new Image("https://raw.githubusercontent.com/Iriabow/hello-world/master/simboloNoImagen.png");
		}
		hPanelPrincipal.add(foto);
		hPanelPrincipal.setSpacing(7);
		VerticalPanel texto=new VerticalPanel();
		
		texto.add(new Label("Concierto: "+concierto.getName()+"."));
		texto.add(new Label("Lugar: "+concierto.getVenue().getName()+"."));
		texto.add(new Label("Ciudad: "+concierto.getVenue().getLocation().getCity()+"."));
		texto.add(new Label("Dirección: "+concierto.getVenue().getLocation().getStreet()+"."));
		texto.add(new Label("Fecha: "+concierto.getStartDate()+"."));
		HorizontalPanel artistas=new HorizontalPanel();
		
		Double maximo=concierto.getTicketPrice().getMax();
		Double minimo=concierto.getTicketPrice().getMin();
		if(!(maximo.equals(minimo))){
		texto.add(new Label("Precio entrada: entre "+minimo+" y "
				                              +maximo+" €."));
		}else{
			texto.add(new Label("Precio entrada: "+maximo+" €."));
		}
		artistas.add(new Label("Artista:"));
		final ListBox listBoxArtistas=new ListBox();
		final List<Artist> listaArtistas=  concierto.getArtists();
		for(Artist a:listaArtistas){
			listBoxArtistas.addItem(a.getName());
		}
		artistas.setSpacing(6);
		artistas.add(listBoxArtistas);
        texto.add(artistas);
        texto.setWidth("400px");
		hPanelPrincipal.add(texto);
		 Button botonComprar=new Button("¡Comprar entrada!");
		    botonComprar.addClickHandler(new ClickHandler(){
		    	public void onClick(ClickEvent click){
		    		Window.open(concierto.getUrl(), "_blank", "");
		    	}

				
		    });
		hPanelPrincipal.add(botonComprar);    
		
		decPanel.add(hPanelPrincipal);
		decPanel.setWidth("650px");
		decPanel.sinkEvents(Event.ONCLICK);
		decPanel.addDomHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				for(DecoratorPanel d:listaDecPanel){
					d.getElement().getStyle().setBackgroundColor("#ffffff");
				}
				decPanel.getElement().getStyle().setBackgroundColor("#c9c9ff");
			
				Map<String,Object> params=new HashMap<String,Object>();
				params.put("artista",listaArtistas.get(listBoxArtistas.getSelectedIndex()).getName());
				Giggotz.go("spotifyWikipedia",params);
				
				
			}
			
		},ClickEvent.getType() );
		return decPanel;
		
	}
	
}
