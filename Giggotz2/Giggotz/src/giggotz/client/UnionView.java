package giggotz.client;

import java.util.Map;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class UnionView extends Composite{

	private static AbsolutePanel panel=new AbsolutePanel();

	public UnionView(Map<String,Object> params){
	
		initWidget(panel);
		//panel.setStyleName("unionView");

		DecoratorPanel decPanel = new DecoratorPanel();
		HorizontalPanel hPanelPrincipal=new HorizontalPanel();
		//Image foto=new Image(concierto.getImages().getMedium());
		//hPanelPrincipal.add(foto);
		hPanelPrincipal.add(new WikipediaView(params));
		decPanel.add(hPanelPrincipal);
		decPanel.setWidth("500px");
		
		
		panel.add(decPanel);
	}

	public static void actualizaPanel(Map<String,Object> params){
		panel.clear();
		DecoratorPanel decPanel = new DecoratorPanel();
		decPanel.setStyleName("unionPanel");
		HorizontalPanel hPanelPrincipal=new HorizontalPanel();
		
		//Image foto=new Image(concierto.getImages().getMedium());
		//hPanelPrincipal.add(foto);
		hPanelPrincipal.add(new WikipediaView(params));
		decPanel.add(hPanelPrincipal);
		decPanel.setWidth("500px");
		
		
		panel.add(decPanel);
	}
	
}
