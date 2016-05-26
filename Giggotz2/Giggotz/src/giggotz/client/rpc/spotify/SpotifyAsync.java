package giggotz.client.rpc.spotify;

import giggotz.shared.spotify.SpotifyAlbums;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SpotifyAsync {

	void getSpotifyTracks(String artist, AsyncCallback<SpotifyAlbums> callback);

}
