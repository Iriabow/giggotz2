package giggotz.client;

import giggotz.client.rpc.wikipedia.WikipediaService;
import giggotz.client.rpc.wikipedia.WikipediaServiceAsync;

import java.util.Map;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextArea;


public class WikipediaView extends Composite {

	private final WikipediaServiceAsync extracto = GWT
			.create(WikipediaService.class);
	private final HorizontalPanel main = new HorizontalPanel();

	public WikipediaView(Map<String, Object> params) {

		initWidget(main);

		//final Button buscar = new Button("Buscar"); //boton que busca información por artista
		final String artista = params.get("artista").toString(); 
		final TextArea texto = new TextArea();
		final TextArea error = new TextArea();
		
		//main.add(buscar);

		//buscar.addClickHandler(new ClickHandler() {
			//public void onClick(ClickEvent event) {

				extracto.getExtract(artista,
						new AsyncCallback<String>() {

							public void onSuccess(String result) {
								texto.setValue(result);
								main.add(texto);
							}

							public void onFailure(Throwable caught) {
								error.setText("Todavía estamos trabajando en ello");
								main.add(error);
							}

						});
			}
		//});
	}
//}
