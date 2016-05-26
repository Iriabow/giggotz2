package giggotz.client.rpc.spotify;

import giggotz.shared.spotify.SpotifyAlbums;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("spotify")
public interface Spotify extends RemoteService {

	SpotifyAlbums getSpotifyTracks(String artist);

}
