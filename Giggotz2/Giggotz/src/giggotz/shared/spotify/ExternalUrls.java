
package giggotz.shared.spotify;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
@Generated("org.jsonschema2pojo")
public class ExternalUrls implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4528583539494692805L;
	private String spotify;

    /**
     * 
     * @return
     *     The spotify
     */
    public String getSpotify() {
        return spotify;
    }

    /**
     * 
     * @param spotify
     *     The spotify
     */
    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }

}
