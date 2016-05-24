package giggotz.client.rpc.wikipedia;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("wikipedia")
public interface WikipediaService extends RemoteService {

	String getExtract(String artist);
	
	
	
}
