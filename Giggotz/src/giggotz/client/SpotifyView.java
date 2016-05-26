package giggotz.client;

import giggotz.client.rpc.spotify.SpotifyAsync;
import giggotz.shared.spotify.ExternalUrls;
import giggotz.shared.spotify.Item;
import giggotz.shared.spotify.SpotifyAlbums;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class SpotifyView implements EntryPoint {

	
	final Button buscar = new Button("buscar");
	final TextBox caja = new TextBox();
	HorizontalPanel mainPanel = new HorizontalPanel();
	final Label statusLabel = new Label();

	final SpotifyAsync Spotify = GWT.create(giggotz.client.rpc.spotify.Spotify.class);

	public void onModuleLoad() {
		caja.setText("Artista");

		mainPanel.add(caja);
		mainPanel.add(buscar);
		mainPanel.add(statusLabel);

		RootPanel.get("form").add(mainPanel);

		buscar.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				statusLabel.setText("buscando...");

				final String artista = caja.getText();

				RootPanel.get("spotify").clear();

				Spotify.getSpotifyTracks(artista,
						new AsyncCallback<SpotifyAlbums>() {

							@Override
							public void onSuccess(SpotifyAlbums result) {

								showAlbums(artista, result);
								statusLabel.setText("");
							}

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub

							}
						});
			}
		});

	}

	private void showAlbums(String artista, SpotifyAlbums result) {

		String output = "<fieldset>";

		output += "<legend> Albums de " + artista
				+ " ¡Clica en uno para ir a su pagina de spotify! </legend>";

		if (result != null) {

			for (Item i : result.getAlbums().getItems()) {
				output += getRefPrueba(i);
			}
		} else
			output += "<span> No results </span>";

		output += "</fieldset>";
		HTML albums = new HTML(output);

		RootPanel.get("spotify").add(albums);
	}

	// private String getRef(Item album) {
	// return "<span><a href=" + album.getExternalUrls().getSpotify() + "'>"
	// + album.getName() + "</a></span><br>";
	// }

	private String getRefPrueba(Item i) {
		return "<span><a href= 'https://open.spotify.com/album/"
				+ i.getSplitUri() + "' target='_blank'>" + i.getName()
				+ "</a></span><br>";
	}

	// private String getSpotify(ExternalUrls spotify) {
	// return spotify.getSpotify();
	// }
}
