package giggotz.server.rpc.spotify;

import giggotz.client.rpc.spotify.Spotify;
import giggotz.shared.spotify.SpotifyAlbums;

import org.restlet.resource.ClientResource;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class SpotifyImpl extends RemoteServiceServlet implements Spotify {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3157480965462750267L;

	public SpotifyAlbums getSpotifyTracks(String artist) {
		ClientResource cr = new ClientResource(
				"https://api.spotify.com/v1/search?q=" + artist + "&type=album");

		SpotifyAlbums track = cr.get(SpotifyAlbums.class);

		return track;

	}

}
