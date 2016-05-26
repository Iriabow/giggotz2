package giggotz.shared.spotify;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Generated("org.jsonschema2pojo")
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4617199974825863634L;
	private String albumType;
	private List<String> availableMarkets = new ArrayList<String>();
	private ExternalUrls external_urls;
	private String href;
	private String id;
	private List<Image> images = new ArrayList<Image>();
	private String name;
	private String type;
	private String uri;

	/**
	 * 
	 * @return The albumType
	 */
	public String getAlbumType() {
		return albumType;
	}

	public String getSplitUri() {
		String[] split = getUri().split(":");
		String res = split[2];
		return res;

	}

	/**
	 * 
	 * @param albumType
	 *            The album_type
	 */
	public void setAlbumType(String albumType) {
		this.albumType = albumType;
	}

	/**
	 * 
	 * @return The availableMarkets
	 */
	public List<String> getAvailableMarkets() {
		return availableMarkets;
	}

	/**
	 * 
	 * @param availableMarkets
	 *            The available_markets
	 */
	public void setAvailableMarkets(List<String> availableMarkets) {
		this.availableMarkets = availableMarkets;
	}

	/**
	 * 
	 * @return The externalUrls
	 */
	public ExternalUrls getExternalUrls() {
		return external_urls;
	}

	/**
	 * 
	 * @param externalUrls
	 *            The external_urls
	 */
	public void setExternalUrls(ExternalUrls externalUrls) {
		this.external_urls = externalUrls;
	}

	/**
	 * 
	 * @return The href
	 */
	public String getHref() {
		return href;
	}

	/**
	 * 
	 * @param href
	 *            The href
	 */
	public void setHref(String href) {
		this.href = href;
	}

	/**
	 * 
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The images
	 */
	public List<Image> getImages() {
		return images;
	}

	/**
	 * 
	 * @param images
	 *            The images
	 */
	public void setImages(List<Image> images) {
		this.images = images;
	}

	/**
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            The type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return The uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * 
	 * @param uri
	 *            The uri
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

}
