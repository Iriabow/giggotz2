package giggotz.client.rpc.wikipedia;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface WikipediaServiceAsync {

	void getExtract(String artist, AsyncCallback<String> callback);

	
}
