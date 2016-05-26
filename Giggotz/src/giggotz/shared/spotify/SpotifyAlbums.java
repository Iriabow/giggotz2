package giggotz.shared.spotify;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Generated("org.jsonschema2pojo")
public class SpotifyAlbums implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6976696920410940581L;
	private Albums albums;

	/**
	 * 
	 * @return The albums
	 */
	public Albums getAlbums() {
		return albums;
	}

	/**
	 * 
	 * @param albums
	 *            The albums
	 */
	public void setAlbums(Albums albums) {
		this.albums = albums;
	}

}
