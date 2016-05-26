package giggotz.shared.spotify;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Generated("org.jsonschema2pojo")
public class Albums implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7374435296419539541L;
	private String href;
	private List<Item> items = new ArrayList<Item>();
	private Integer limit;
	private String next;
	private Integer offset;
	private Integer total;

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
	 * @return The items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * 
	 * @param items
	 *            The items
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}

	/**
	 * 
	 * @return The limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * 
	 * @param limit
	 *            The limit
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * 
	 * @return The next
	 */
	public String getNext() {
		return next;
	}

	/**
	 * 
	 * @param next
	 *            The next
	 */
	public void setNext(String next) {
		this.next = next;
	}

	/**
	 * 
	 * @return The offset
	 */
	public Integer getOffset() {
		return offset;
	}

	/**
	 * 
	 * @param offset
	 *            The offset
	 */
	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	/**
	 * 
	 * @return The total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * 
	 * @param total
	 *            The total
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

}
