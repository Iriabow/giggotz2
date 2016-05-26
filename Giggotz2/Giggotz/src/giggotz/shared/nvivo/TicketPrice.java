
package giggotz.shared.nvivo;

import java.io.Serializable;


public class TicketPrice implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -5130812441207575030L;
	private String min="Desconocido";
    private String max="Desconocido";

    public TicketPrice(){}
    public String getMin() {
        return min;
    }

   
    public void setMin(Double min) {
        this.min = min.toString();
    }

  
    public String getMax() {
        return max;
    }

   
    public void setMax(Double max) {
        this.max = max.toString();
    }

}
